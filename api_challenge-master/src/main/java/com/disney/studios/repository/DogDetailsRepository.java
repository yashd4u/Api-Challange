package com.disney.studios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.disney.studios.model.DogDetails;

public interface DogDetailsRepository extends CrudRepository<DogDetails, String> {

	@Query(value = "SELECT * FROM Dog_Details e ORDER BY e.breed DESC", nativeQuery = true)

	public List<DogDetails> findDogsGroupByBreed();

	public List<DogDetails> findDogsByBreed(String breed);

	// @Query(value ="SELECT *FROM Dog_Details WHERE id=:id", nativeQuery= true)
	public DogDetails findDogById( String id);

}
