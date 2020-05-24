package com.disney.studios.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.disney.studios.model.DogDetails;
import com.disney.studios.model.UserLiked;

public interface UserLikedRepository extends CrudRepository<UserLiked, String> {
	@Query("FROM DogDetails  WHERE id=:id")
	public UserLiked findOne(@Param("id") String id);

}