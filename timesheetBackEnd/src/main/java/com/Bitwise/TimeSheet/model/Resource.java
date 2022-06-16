package com.Bitwise.TimeSheet.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resource {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int resourseId;

	private String resourceName;
	private String team;
	

//	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	private TimeSheet timesheet;
//	@ManyToOne(cascade = CascadeType.DETACH)
//	private TotalSum sum;
//	
	@OneToOne (cascade = CascadeType.ALL)
	private TimeSheet timesheet;
}
