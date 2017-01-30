package com.bhuvana.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;

import com.bhuvana.model.ItemQuantity;
import com.bhuvana.model.MenuItems;
import com.bhuvana.model.SessionSchedule;
import com.bhuvana.util.ConnectionUtil;



public class ItemQuantityDAO {

	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();


	public void save(final ItemQuantity item) {
		final String sql = "insert into item_quantity(ID,FOOD_TYPE,MENU_TYPE,QTY)"
				+ "values (?,?,?,?) ";
		final Object[] params = { item.getID(), item.getFoodType(), item.getMenuType(),item.getQty()
				 };
		final int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);
	}

	
	public void delete(final int id) {
		final String sql = "delete from item_quantity where id=?";
		final int rows = jdbcTemplate.update(sql, id);
		System.out.println(rows);
	}

	
	public void update(final ItemQuantity item) {
		final String sql = "update item_quantity set menu_type=? where ID=?";
		final Object[] params = { item.getFoodType(), item.getID() };
		final int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);
	}

	
	public List<ItemQuantity> list() {
		final String sql = "Select ID,MENU_ID,FOOD_ID,QTY from item_quantity";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final ItemQuantity item = convert(rs);
			return item;
		});
	}

	public ItemQuantity convert(final ResultSet rs) throws SQLException {
		final ItemQuantity item = new ItemQuantity();

		item.setID(rs.getInt("ID"));
		final MenuItems itemPrice = new MenuItems();
		 itemPrice.setId(rs.getInt("MENU_ID"));
	     item.setMenuType(itemPrice);
		final SessionSchedule category=new SessionSchedule();
		category.setId(rs.getInt("FOOD_ID"));
		item.setFoodType(category);
		 item.setQty(rs.getInt("QTY"));
		return item;
		
	

}
}
