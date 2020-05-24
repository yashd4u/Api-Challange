package com.disney.studios.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney.studios.PetLoader;
import com.disney.studios.model.DogDetails;
import com.disney.studios.model.UserLiked;
import com.disney.studios.model.UserVote;
import com.disney.studios.repository.DogDetailsRepository;
import com.disney.studios.repository.UserLikedRepository;

@Service
public class DogDetailServiceImpl implements DogDetailService {

	@Autowired
	private DogDetailsRepository dogDetailsRepository;

	@Autowired
	private UserLikedRepository userLikedRepository;

	@Override
	public List<DogDetails> findDogsByBreed(String breed) {
		List<DogDetails> dogDetails = dogDetailsRepository.findDogsByBreed(breed);
		return dogDetails;

	}

	@Override
	public String voteUpDown(UserVote userVote) {
		UserLiked userLiked = userLikedRepository.findOne(userVote.getUserid());
		if (userLiked == null) {
			DogDetails dogDetails = dogDetailsRepository.findDogById(String.valueOf(userVote.getDid()));
			UserLiked userInitiakLiked = new UserLiked();
			userInitiakLiked.setUserid(userVote.getUserid());
			userInitiakLiked.setVoted(userVote.isVoted());
			userInitiakLiked.setDogDetails(dogDetails);
			userLikedRepository.save(userInitiakLiked);
			return "voted";
		} else {
			return "already voted";
		}
	}


	@Override
	public List<DogDetails> findDogsGroupByBreed() {
		List<DogDetails> dogDetails = dogDetailsRepository.findDogsGroupByBreed();
		return dogDetails;
	}

	@Override
	public DogDetails findDogDetail(String id) {
		
		DogDetails dogDetails=dogDetailsRepository.findDogById(id);
		DogDetails dog=new DogDetails();
		List<UserLiked> users=new ArrayList<>();
		BeanUtils.copyProperties(dogDetails, dog,"users");
		List<UserLiked> favoritedEntities=dogDetails.getUserLiked();
		if(favoritedEntities!=null && favoritedEntities.size()>0){
		for(UserLiked entity:favoritedEntities){
			UserLiked favorited=new UserLiked();
			BeanUtils.copyProperties(entity, favorited,"dog");
			users.add(favorited);
		}
		dog.setUserLiked(users);
		}
		return dog;
}
	
}
