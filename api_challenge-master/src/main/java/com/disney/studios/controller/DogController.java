package com.disney.studios.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.disney.studios.model.DogDetails;
import com.disney.studios.model.DogExceptionHandler;
import com.disney.studios.model.UserLiked;
import com.disney.studios.model.UserVote;
import com.disney.studios.services.DogDetailService;

@RestController

public class DogController {
	@Autowired
	private DogDetailService dogDetailService;

	private UserVote userLiked;

	@GetMapping(value = "/groupByBreed", produces = "application/json; charset=UTF-8")
	public List<DogDetails> groupByBreed() throws DogExceptionHandler {
		return dogDetailService.findDogsGroupByBreed();
	}

	@GetMapping(value = "/dogs/{breed}", produces = "application/json; charset=UTF-8")
	public List<DogDetails> getDogsForBreed(@PathVariable String breed) throws DogExceptionHandler {
		return dogDetailService.findDogsByBreed(breed);

	}

	@GetMapping(value = "/dog/{id}", produces = "application/json; charset=UTF-8")
	public DogDetails getDog(@PathVariable String id) throws DogExceptionHandler {
		return dogDetailService.findDogDetail(id);

	}

	@GetMapping(value = "/voteUpDogPick", produces = "application/json; charset=UTF-8")

	public void voteUpDogPicture(@PathVariable String id, HttpServletRequest request)
			throws DogExceptionHandler {
		dogDetailService.voteUpDown(userLiked);
	}

}
