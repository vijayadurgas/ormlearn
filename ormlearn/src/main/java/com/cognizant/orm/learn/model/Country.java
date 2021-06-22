package com.cognizant.orm.learn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "country")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "country", schema = "ormlearn")

public class Country {

	@Id
	@Column(name = "co_code")
	private String code;

	@Column(name = "co_name")
	private String name;

}
