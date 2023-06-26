package com.RestApi.service;

import java.util.List;

import com.RestApi.entity.Passenger;
import com.RestApi.entity.Ticket;

public interface TicketService {

	public Ticket bookTicket(Passenger passengerInfo);

	public Ticket getTicket(Integer ticketId);

	public String updateTicket(Passenger passenger,Integer ticketId);

	public String deleteTicket(Integer ticketId);

	public List<Ticket> getAlltickets();
}
