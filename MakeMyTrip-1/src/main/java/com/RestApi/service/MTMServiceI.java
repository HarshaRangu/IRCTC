package com.RestApi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.RestApi.binding.Passenger;
import com.RestApi.binding.Ticket;

public interface MTMServiceI {

	public List<Ticket> getAllTickets();

	public Ticket bookTicket(Passenger p);

	public Ticket getTicket(Integer ticketId);

	public String deleteTicket(Integer ticketId);

	public Ticket updateTicket(Integer ticketId,Passenger passenger);

}
