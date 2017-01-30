package com.bhuvana.dao;

import com.bhuvana.model.Seat;

public class TestSeatDAO {

	public static void main(String[] args) {

	SeatDAO seatDAO = new SeatDAO();

	 Seat seat = new Seat();

		 seat.setId(9);
		 seat.setId(9);
		 seat.setSeatStatus("AVAILABLE");
		 seat.setCheckSeat(0);

		seatDAO.save(seat);
		// seatsDAO.update(seats);
		// seatsDAO.delete(1);

	}
}
