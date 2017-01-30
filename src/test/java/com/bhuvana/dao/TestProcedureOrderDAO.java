package com.bhuvana.dao;

	import java.time.LocalTime;
	import java.time.format.DateTimeFormatter;
	import java.util.Locale;

	public class TestProcedureOrderDAO {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			OrderDAO orderdao = new OrderDAO();
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ENGLISH);
			LocalTime time = LocalTime.now();
			String timeForm = formatter.format(time);
			
			
			
			String status = orderdao.placeOrder(2,"south indian meals",2,"@message");
			System.out.println(status);

		}
	}

