package com.bhuvana.dao;


	import java.util.Iterator;
	import java.util.List;

import com.bhuvana.model.ItemQuantity;



	//import com.rashika.model.FoodStocks;

	public class TestItemQuantityDAO {

		public static void main(final String[] args) {

		 ItemQuantityDAO itemDAO = new ItemQuantityDAO();
			
		 
//		ItemQuantity  item = new ItemQuantity();

//		  item.setSno(17);
//		  item.setMealid(4);
//		  item.setFoodid(17);
//	      item.setQuantity(300);
	// 


//		 itemDAO.save( item);
		// itemDAO.delete(17);
		 
		 List<ItemQuantity> list=itemDAO.list();
			Iterator i=list.iterator();
			while(i.hasNext())
			{
				ItemQuantity  item = (ItemQuantity) i.next();
				System.out.println( item.getID()+"\t"+ item.getFoodType().getId()+"\t"+ item.getMenuType().getId()
						+"\t"+ item.getQty());
				
			}
			
		}
}
