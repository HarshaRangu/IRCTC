package com.RestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestApi.entity.Passenger;
import com.RestApi.entity.Ticket;
import com.RestApi.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketService service;

	@PostMapping(value = "/bookTicket", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger) {
		Ticket bookTicket = service.bookTicket(passenger);
		System.out.println(passenger);
		return new ResponseEntity<Ticket>(bookTicket, HttpStatus.CREATED);
	}

	@GetMapping("/getTicket/{id}")
	public ResponseEntity<Ticket> getTicket(@PathVariable("id") Integer ticketId) {
		Ticket ticket = service.getTicket(ticketId);

		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}

	@PutMapping("/updateTicket/{ticketId}")
	public ResponseEntity<String> updateTicket(@RequestBody Passenger passenger,
			@PathVariable("ticketId") Integer ticketId) {
		String updateTicket = service.updateTicket(passenger, ticketId);

		System.out.println(updateTicket);
		return new ResponseEntity<String>(updateTicket, HttpStatus.OK);

	}

	@DeleteMapping("/deleteTicket/{ticketId}")
	public ResponseEntity<String> deleteTicket(@PathVariable("ticketId") Integer ticketId) {
		String deleteTicket = service.deleteTicket(ticketId);
		return new ResponseEntity<String>(deleteTicket, HttpStatus.OK);
	}

	@GetMapping("/getAllTickets")
	public ResponseEntity<List<Ticket>> getAllTicket() {
		List<Ticket> allTickets = service.getAlltickets();

		return new ResponseEntity<List<Ticket>>(allTickets, HttpStatus.OK);
	}
}
