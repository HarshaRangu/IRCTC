package com.RestApi.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestApi.entity.Passenger;
import com.RestApi.entity.Ticket;
import com.RestApi.repo.PassengerRepository;
import com.RestApi.repo.TicketRepository;
import com.RestApi.service.TicketService;

@Service
public class TicketServiceImp implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private PassengerRepository passengerRepository;

	private Map<String, Ticket> tickmap = new HashMap<>();

	@Override
	public Ticket bookTicket(Passenger passengerInfo) {

		passengerRepository.save(passengerInfo);
		String pnr = "";

		for (int i = 0; i <= 8; i++) {
			pnr = pnr + (int) (Math.random() * 10);
		}

		Ticket tic = new Ticket();
		tic.setName(passengerInfo.getName());
		tic.setJourneryDate(passengerInfo.getJourneryDate());
		tic.setSource(passengerInfo.getSource());
		tic.setDestination(passengerInfo.getDestination());
		tic.setJourneryDate(passengerInfo.getJourneryDate());
		tic.setTicketPnr(pnr);
		tic.setTicketStatus("confirmed");
		tic.setTrainNum(passengerInfo.getTrainNum());

		ticketRepository.save(tic);

		tickmap.put(pnr, tic);
		return tic;
	}

	@Override
	public Ticket getTicket(Integer ticketId) {
		Ticket ticket = ticketRepository.findById(ticketId).get();

		return ticket;
	}

	@Override
	public String updateTicket(Passenger passenger, Integer ticketid) {

		Optional<Ticket> findById = ticketRepository.findById(ticketid);
		Ticket existingTicket = findById.get();

		existingTicket.setTrainNum(passenger.getTrainNum());

		passengerRepository.save(passenger);

		return "Ticket Updated Succeslly";
	}

	@Override
	public String deleteTicket(Integer ticketId) {

		ticketRepository.deleteById(ticketId);

		return "Ticket deleted succefully";
	}

	@Override
	public List<Ticket> getAlltickets() {

		return ticketRepository.findAll();
	}

}
