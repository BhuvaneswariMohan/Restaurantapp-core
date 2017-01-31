package com.bhuvana.dao;

import java.util.Iterator;
import java.util.List;

import com.bhuvana.model.ItemQuantity;
import com.bhuvana.model.MenuItems;
import com.bhuvana.model.SessionSchedule;

//import com.rashika.model.FoodStocks;

public class TestItemQuantityDAO {

	public static void main(final String[] args) {

		ItemQuantityDAO itemDAO = new ItemQuantityDAO();

		ItemQuantity item = new ItemQuantity();
		SessionSchedule sess = new SessionSchedule();
		sess.setId(2);
		MenuItems mn = new MenuItems();
		mn.setId(7);

		item.setID(17);
		item.setFoodType(sess);
		item.setMenuType(mn);
		item.setQty(300);

		itemDAO.save(item);
		// itemDAO.delete(17);
		//
		// List<ItemQuantity> list=itemDAO.list();
		// Iterator i=list.iterator();
		// while(i.hasNext())
		// {
		// ItemQuantity item1 = (ItemQuantity) i.next();
		// System.out.println( item1.getID()+"\t"+
		// item1.getFoodType().getId()+"\t"+ item1.getMenuType().getId()
		// +"\t"+ item1.getQty());
		//
		// }
		//
		// }
	}
}
