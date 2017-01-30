package com.bhuvana.model;

import java.time.LocalDateTime;

	import lombok.Data;

	@Data
	public class OrderDetails {

		private int id;
		private Seat seatNo;
		private MenuItems foodItem;
		private int qty;
		private int billAmount;
		private LocalDateTime orderDate;
	
		private String billStatus;
	}