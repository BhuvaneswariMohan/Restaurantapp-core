package com.bhuvana.dao;

import com.bhuvana.model.MenuItems;
import com.bhuvana.validator.ItemValidator;

public class TestItemValidatorDAO {

	public static void main(String[] args) {
		

		MenuItems itemPrice = new MenuItems();
		itemPrice.setFoodItem("");
		ItemValidator itemValidator = new ItemValidator();
		itemValidator.listByItem(itemPrice);
		
	}

}

