/*package com.disney.studios;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.disney.studios.batchProcess.DogDetailsItemProcessor;
import com.disney.studios.model.DogDetails;

import org.springframework.core.io.Resource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.core.launch.support.RunIdIncrementer;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Value("classpath:data/dog_*.txt")
	private Resource [] resources;

	@Bean
	public FlatFileItemReader<DogDetails> reader() {
		FlatFileItemReader<DogDetails> dogReader = new FlatFileItemReader<DogDetails>();

		dogReader.setLineMapper(new DefaultLineMapper<DogDetails>() {
			{

				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "id", "url", "breed", "num_likes" });

					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<DogDetails>() {
					{
						setTargetType(DogDetails.class);
					}
				});

			}
		});
		return dogReader;

	}

	@Bean
	public MultiResourceItemReader<DogDetails> multiResourceItemReader() {

		MultiResourceItemReader<DogDetails> multiResourcesReader = new MultiResourceItemReader<DogDetails>();
		multiResourcesReader.setResources((Resource[]) resources);
		multiResourcesReader.setDelegate(reader());

		return multiResourcesReader;
	}

	@Bean
	public DogDetailsItemProcessor process() {

		return new DogDetailsItemProcessor();
	}
	
	@Bean
	public Job myJob() {
		return jobBuilderFactory.get("myJob")
				.incrementer(new RunIdIncrementer())
                .flow(step1())
                .end()
                .build();
	}         
		
	@Bean
	public 	Step step1 () {
			return stepBuilderFactory.get("step1")
					.<DogDetails, DogDetails> chunk(15)
			        .reader(multiResourceItemReader())
			        .processor(process())
			       // .writer(writer())
					.build();
			
		}
		
	}*/

