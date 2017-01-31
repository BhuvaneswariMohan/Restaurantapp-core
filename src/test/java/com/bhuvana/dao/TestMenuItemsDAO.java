package com.bhuvana.dao;

import com.bhuvana.model.MenuItems;

public class TestMenuItemsDAO {
	public static void main(String[] args) {

		MenuItemsDAO itemPriceDAO = new 	MenuItemsDAO();

		MenuItems itemPrice = new MenuItems();

		 itemPrice.setId(19);
		 itemPrice.setFoodItem("milk");
		 itemPrice.setRate(30);

		 itemPriceDAO.save(itemPrice);
		// foodDAO.update(food);
		//foodDAO.delete(1);

	}
	
}

