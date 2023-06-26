package com.RestApi.binding;

import java.util.Date;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

	private Integer ticketId;

	private String name;

	private String source;

	private String destination;

	private Date journeryDate;

	private Integer trainNum;

	private String ticketPnr;

	private String ticketStatus;

}
