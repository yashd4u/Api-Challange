package com.disney.studios.services;

import java.util.List;

import com.disney.studios.model.DogDetails;
import com.disney.studios.model.UserVote;

public interface DogDetailService {
	
		public List<DogDetails> findDogsByBreed(String breed);
		public String voteUpDown(UserVote userVote);
		//public String voteUpDown(UserVote userVote);
		public List<DogDetails> findDogsGroupByBreed();
		public DogDetails findDogDetail(String id);
		
	}

