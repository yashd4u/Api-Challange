package com.disney.studios.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

public class DogDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column
	private String url;

	@Column
	private String breed;

	@Column
	private int numLikes = 0;
	@Column
	private String description;
	@Column
	//@OneToMany
	//private UserLiked users;
	
	@ElementCollection
	private List<UserLiked> userLiked;

	

	public DogDetails() {

	}

	/**
	 * @param id
	 * @param url
	 * @param breed
	 * @param numLikes
	 */

	public DogDetails(String id, String url, String breed, int numLikes) {
		super();
		this.id = id;
		this.url = url;
		this.numLikes = numLikes;
		this.breed = breed;

	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the breed
	 */
	public String getBreed() {
		return breed;
	}

	/**
	 * @param breed the breed to set
	 */
	public void setBreed(String breed) {
		this.breed = breed;
	}

	/**
	 * @return the numLikes
	 */
	public int getNumLikes() {
		return numLikes;
	}

//	public List<UserLiked> getUserLiked() {
//		return userLiked;
//	}

	/**
	 * @param numLikes the numLikes to set
	 */
	public void setNumLikes(int numLikes) {
		this.numLikes = numLikes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

/*	public UserLiked getUsers() {
		return users;
	}*/
	public List<UserLiked> getUserLiked() {
		return userLiked;
	}

	public void setUserLiked(List<UserLiked> userLiked) {
		this.userLiked = userLiked;
	}
	
}
