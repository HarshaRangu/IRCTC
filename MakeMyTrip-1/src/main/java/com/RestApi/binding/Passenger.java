package com.RestApi.binding;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
	
	private Integer pid;

	private String name;

	private String source;

	private String destination;

	private Date journeryDate;

	private Double fare;

	private Integer trainNum;

}
