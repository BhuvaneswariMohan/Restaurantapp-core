package com.bhuvana.validator;



import java.util.logging.Level;
import java.util.logging.Logger;

import com.bhuvana.exception.ItemNotFoundException;
import com.bhuvana.model.MenuItems;




public class ItemValidator {
	private static final Logger logger = Logger.getLogger(ItemValidator.class.getName());

	public void listByItem(MenuItems itemPrice) {

		if ("".equals(itemPrice.getFoodItem()) || " ".equals(itemPrice.getFoodItem())) {
			try {

				throw new ItemNotFoundException("Item not in menu list");
			} catch (ItemNotFoundException e) {

				logger.log(Level.SEVERE, "Exceptions Occured", e);
			}

		}
	}
}

