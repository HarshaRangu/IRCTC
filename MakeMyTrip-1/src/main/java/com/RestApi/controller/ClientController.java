package com.RestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestApi.binding.Passenger;
import com.RestApi.binding.Ticket;
import com.RestApi.service.MTMServiceI;

@RestController
@RequestMapping("/makemyTrip")
public class ClientController {

	@Autowired
	private MTMServiceI service;

	@GetMapping("/getTickets")
	public ResponseEntity<List<Ticket>> getAllTicktes() {

		List<Ticket> allTickets = service.getAllTickets();

		return new ResponseEntity<List<Ticket>>(allTickets, HttpStatus.OK);
	}

	@PostMapping("/bookTicket")
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger) {
		Ticket bookTicket = service.bookTicket(passenger);
		return new ResponseEntity<Ticket>(bookTicket, HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteTicket/{ticketId}")
	public ResponseEntity<String> deleteTicket(@PathVariable("ticketId") Integer ticketId) {
		String deleteTicket = service.deleteTicket(ticketId);
		return new ResponseEntity<String>("Ticket Deleted Succesfully", HttpStatus.OK);

	}

	@GetMapping(value = "/getTicket/{id}")
	public ResponseEntity<Ticket> getTicket(@PathVariable("id") Integer ticketId) {
		Ticket ticket = service.getTicket(ticketId);
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);

	}

}
