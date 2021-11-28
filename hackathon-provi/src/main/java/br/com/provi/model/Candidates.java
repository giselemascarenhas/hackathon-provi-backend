package br.com.provi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_candidate")
public class Candidates {
		
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private long id;
			
			@NotNull
			private String candidates;
			
			private String phone;

			@Email
			@NotNull
			private String email;
			
			@NotNull
			private String education;
			
			private String skills;
			
			private String interests;

			public long getId() {
				return id;
			}

			public void setId(long id) {
				this.id = id;
			}

			public String getCandidate() {
				return candidates;
			}

			public void setCandidate(String candidates) {
				this.candidates = candidates;
			}

			public String getPhone() {
				return phone;
			}

			public void setPhone(String phone) {
				this.phone = phone;
			}

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}

			public String getEducation() {
				return education;
			}

			public void setEducation(String education) {
				this.education = education;
			}

			public String getSkills() {
				return skills;
			}

			public void setSkills(String skills) {
				this.skills = skills;
			}

			public String getInterests() {
				return interests;
			}

			public void setInterests(String interests) {
				this.interests = interests;
			}
}
