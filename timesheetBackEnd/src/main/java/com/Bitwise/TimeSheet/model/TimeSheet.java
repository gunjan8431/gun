package com.Bitwise.TimeSheet.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TimeSheet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int TimeSheetId;
	private String month;
	private int year=2022;
	private int week1;
	private int week2;
	private int week3;
	private int week4;
	
	private int week5;
	private int total=0;
	
//@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	private List<Resource> resource =new ArrayList<Resource>();
}
  