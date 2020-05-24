package com.disney.studios.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserVote {
	
		@Id
		@GeneratedValue
		private String userid;
		private Long votid;
		private boolean voted;

		public String getUserid() {
			return userid;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}

		public long getDid() {
			return votid;
		}

		public void setDid(long votid) {
			this.votid = votid;
		}

		public boolean isVoted() {
			return voted;
		}

		public void setVoted(boolean voted) {
			this.voted = voted;
		}

		@Override
		public String toString() {
			return "VoteUpDown [userid=" + userid + ", votid=" + votid + ", voted=" + voted + "]";
		}

	}
	

