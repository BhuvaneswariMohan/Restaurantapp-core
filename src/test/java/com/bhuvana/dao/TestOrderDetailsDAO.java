package com.bhuvana.dao;



import java.util.Iterator;
import java.util.List;

import com.bhuvana.model.OrderDetails;



public class TestOrderDetailsDAO {

	public static void main(final String[] args) {

		OrderDetailsDAO orderItemDAO = new OrderDetailsDAO();
		
		

	
        

	 //OrderDetailsDAO.save(orderItem);
	// OrderDetailsDAO.delete(5);
		
	List<OrderDetails> list=orderItemDAO.list();
	Iterator i=list.iterator();
	while(i.hasNext())
	{
		OrderDetails orderItem = (OrderDetails) i.next();
		System.out.println(orderItem.getId()+"\t"+orderItem.getSeatNo().getId()+"\t"+orderItem.getFoodItem().getId()
				+"\t"+orderItem.getQty()+"\t"+orderItem.getBillAmount()+"\t"+orderItem.getOrderDate()+"\t"+orderItem.getBillStatus());
		
		
	}
	
		
	}
}
