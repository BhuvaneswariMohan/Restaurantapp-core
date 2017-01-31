package com.bhuvana.dao;


	



	public class TestOrderCancelDAO {

		public static void main(String[] args) {

			OrderCancelDAO cancelFoodDao = new OrderCancelDAO();
			String status = cancelFoodDao.cancelOrder(1, "seat8", "North Indian Thali", "@cancel_message");
			System.out.println(status);
		}


}
