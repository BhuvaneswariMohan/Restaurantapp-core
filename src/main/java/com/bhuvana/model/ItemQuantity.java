package com.bhuvana.model;


	import lombok.Data;

 @Data
	public class ItemQuantity {

		private int ID;
	
		private SessionSchedule foodType;
		private MenuItems menuType;
		private int qty;
	}


