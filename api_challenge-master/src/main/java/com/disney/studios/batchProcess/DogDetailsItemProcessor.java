package com.disney.studios.batchProcess;
import org.springframework.batch.item.ItemProcessor;

import com.disney.studios.model.DogDetails;


public class DogDetailsItemProcessor  implements ItemProcessor<DogDetails,DogDetails>{

	@Override
	public DogDetails process(final DogDetails dog) throws Exception {
		// TODO Auto-generated method stub
		
		final String  id =dog.getId();
		final String breed =dog.getBreed();
		
		final String url =dog.getUrl();
		final int num_totals =dog.getNumLikes();
		
		final DogDetails dogDetailsTransform = new DogDetails("id","breed","url",num_totals);
		return dogDetailsTransform;
	}

	

}
