package com.tcs.springassesment.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Question")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private List<String> answers;

	private int vote;

	private int u_id;

	@JsonIgnore
	@ManyToOne
	private User user;

	@Override
	public String toString() {
		return "Question [id=" + id + ", answers=" + answers + ", vote=" + vote + ", u_id=" + u_id + ", user=" + user
				+ "]";
	}

}
