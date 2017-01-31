package com.bhuvana.dao;
	import java.time.LocalTime;

	import com.bhuvana.model.SessionSchedule;



	public class TestSessionScheduleDAO {


		public static void main(String[] args) {
			
		

		SessionScheduleDAO categoryDAO = new 	SessionScheduleDAO();
			
		 
		 SessionSchedule category = new  SessionSchedule();

		 category.setId(8);
		 category.setFoodtype("Lunch");
		 category.setStarttime(LocalTime.parse("23:15:00"));
		 category.setEndtime(LocalTime.parse("01:15:00"));


		 categoryDAO.save(category);
		//categoryDAO.delete(5);
			
		}
}
