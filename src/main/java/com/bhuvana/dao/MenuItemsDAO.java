package com.bhuvana.dao;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.List;
	import org.springframework.jdbc.core.JdbcTemplate;
    import com.bhuvana.model.MenuItems;
    import com.bhuvana.util.ConnectionUtil;
	public class MenuItemsDAO {

		private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

		
		public void save(final MenuItems itemPrice) {
			final String sql = "insert into menu_items(ID,FOOD_ITEMS,RATE) values (?,?,?)";
			final Object[] params = { itemPrice.getId(), itemPrice.getFoodItem(), itemPrice.getRate() };
			final int rows = jdbcTemplate.update(sql, params);
			System.out.println(rows);
		}

		
		public void update(final MenuItems itemPrice) {
			final String sql = "update menu_items set =FOOD_ITEMS? where ID=? ";
			final Object[] params = { itemPrice.getFoodItem(), itemPrice.getId() };
			final int rows = jdbcTemplate.update(sql, params);
			System.out.println(rows);
		}

		
		public void delete(final int id) {
			final String sql = "delete from menu_items where ID=?";

			final int rows = jdbcTemplate.update(sql, id);
			System.out.println(rows);

		}

		
		public List<MenuItems> list() {
			final String sql = "select ID,FOOD_ITEMS,RATE from menu_items";
			return jdbcTemplate.query(sql, (rs, rowNum) -> {
				final MenuItems itemPrice = convert(rs);
				return itemPrice;

			});
		}
	
		static MenuItems convert(final ResultSet rs) throws SQLException {
			final MenuItems itemPrice = new MenuItems();
			itemPrice.setId(rs.getInt("ID"));
			itemPrice.setFoodItem(rs.getString("ITEM_NAME"));
			itemPrice.setRate(rs.getInt("PRICE"));

			return itemPrice;
		}

	}


