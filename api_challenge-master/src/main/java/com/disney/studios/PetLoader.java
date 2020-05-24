package com.disney.studios;

import static org.slf4j.LoggerFactory.getLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.disney.studios.model.DogDetails;
import com.disney.studios.repository.DogDetailsRepository;

@Component
public class PetLoader implements InitializingBean {

	private static final Logger LOGGER = getLogger(PetLoader.class);

	// Resources to the different files we need to load.
	@Value("classpath:data/labrador.txt")
	private Resource labradors;

	@Value("classpath:data/pug.txt")
	private Resource pugs;

	@Value("classpath:data/retriever.txt")
	private Resource retrievers;

	@Value("classpath:data/yorkie.txt")
	private Resource yorkies;

	@Autowired
	DataSource dataSource;

	private static DogDetails dt;

	private DogDetailsRepository dogDetailsRepository;

	@Autowired
	public PetLoader(DogDetailsRepository dogDetailsRepository) {
		this.dogDetailsRepository = dogDetailsRepository;
	}

	/**
	 * Load the different breeds into the data source after the application is
	 * ready.
	 *
	 * @throws Exception In case something goes wrong while we load the breeds.
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		loadBreed("Labrador", labradors);
		loadBreed("Pug", pugs);
		// loadBreed("Retriever", retrievers);
		loadBreed("Yorkie", yorkies);

		showDogs();
	}

	/**
	 * Reads the list of dogs in a category and (eventually) add them to the data
	 * source.
	 * 
	 * @param breed  The breed that we are loading.
	 * @param source The file holding the breeds.
	 * @throws IOException  In case things go horribly, horribly wrong.
	 * @throws SQLException
	 */

	public void showDogs() {
		Iterable<DogDetails> dogs = dogDetailsRepository.findAll();
		for (DogDetails dogDetail : dogs) {
			System.out.println(dogDetail);
		}
	}

	private void loadBreed(String breed, Resource source) throws IOException {
		LOGGER.debug("Loading breed {}", breed);

		List<String> dogs = new ArrayList<>();
		try (

				BufferedReader br = new BufferedReader(new InputStreamReader(source.getInputStream()))) {
			String line;
			while ((line = br.readLine()) != null) {
				LOGGER.debug(line);
				// TODO: Create appropriate objects and save them to the datasource.
				dogs.add(line);
			}
		}

		for (String line : dogs) {
			line = line.trim();

			// make sure we have a valid entry
			if (line.length() > 0 && line.startsWith("http")) {
				int indexOflastSlash = line.lastIndexOf("/");
				int indexOfLastDot = line.lastIndexOf(".");

				String id = line.substring(indexOflastSlash + 1, indexOfLastDot);
				String url = line;

				// cleanse the breed
				breed = breed.trim().toLowerCase();

				// id alone is not unique for the data set
				String uniqueID = "_" + breed;
				uniqueID = uniqueID.toLowerCase();
				int counter = 0;
				dt = new DogDetails(id, url, breed, counter);

				dogDetailsRepository.save(dt);
			}

		}
	}
}
