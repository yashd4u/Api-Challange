package com.disney.studios.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class UserLiked {
	@Id
	@GeneratedValue
	private String userid;
	private boolean voted;
	private Date timestamp;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public boolean isVoted() {
		return voted;
	}

	public void setVoted(boolean voted) {
		this.voted = voted;
	}

	public Date getTimeStamp() {
		return timestamp;
	}

	public void setTimeStamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@ManyToOne
	private DogDetails dogDetails;
	
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public DogDetails getDogDetails() {
		return dogDetails;
	}

	public void setDogDetails(DogDetails dogDetails) {
		this.dogDetails = dogDetails;
	}

	@Override
	public String toString() {

		return "UserFavorited [userid=" + userid + ", voted=" + voted + ", doe=" + timestamp + "]";
	}
}
