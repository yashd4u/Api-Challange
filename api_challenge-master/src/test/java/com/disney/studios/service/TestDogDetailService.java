package com.disney.studios.service;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.disney.studios.model.DogDetails;
import com.disney.studios.model.UserVote;
import com.disney.studios.repository.DogDetailsRepository;

import com.disney.studios.services.DogDetailServiceImpl;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class TestDogDetailService {

	@Mock
	private DogDetailsRepository dogDetailsRepository;

	@InjectMocks
	DogDetailServiceImpl dogDetailsService;

	@Before(value = "")
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void findDogsByBreed() {

		List<DogDetails> dogs = new ArrayList<DogDetails>();
		DogDetails dd = new DogDetails();

		dogs.add(new DogDetails("tUZhJYN", "pug", "http://i.imgur.com/tUZhJYN.png", 2));
		dogs.add(new DogDetails("HrscSnK", "pug", "http://i.imgur.com/HrscSnK.png", 3));
		DogDetails dogDetails = new DogDetails();

		given(dogDetailsRepository.findDogsByBreed(dd.getBreed())).willReturn(dogs);

		List<DogDetails> expected = dogDetailsService.findDogsByBreed(dd.getBreed());

		assertEquals(expected, dogs);

	}

	@Test
	public void TestfindDogsGroupByBreed() {

		List<DogDetails> dogs = new ArrayList<DogDetails>();

		dogs.add(new DogDetails("tUZhJYN", "pug", "http://i.imgur.com/tUZhJYN.png", 2));
		dogs.add(new DogDetails("HrscSnK", "pug", "http://i.imgur.com/HrscSnK.png", 3));
		given(dogDetailsRepository.findDogsGroupByBreed()).willReturn(dogs);

		List<DogDetails> expected = dogDetailsService.findDogsGroupByBreed();

		assertEquals(expected, dogs);

	}

	@Test
	public void TestfindDogDetail() {
		// return null;
		DogDetails dog = new DogDetails("tUZhJYN", "pug", "http://i.imgur.com/tUZhJYN.png", 2);
		String id = "tUZhJYN";

		given(dogDetailsRepository.findDogById(id)).willReturn(dog);

		DogDetails expected = dogDetailsService.findDogDetail(id);

		assertNotEquals(expected, dog);

	}
}
