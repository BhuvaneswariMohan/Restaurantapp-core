package com.bhuvana.dao;


	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.List;

	import org.springframework.jdbc.core.JdbcTemplate;

import com.bhuvana.model.MenuItems;
import com.bhuvana.model.OrderDetails;
import com.bhuvana.model.Seat;
import com.bhuvana.util.ConnectionUtil;


	public class OrderDetailsDAO {

		private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	
		public void save(final OrderDetails orderItem) {
			final String sql = "insert into order_records(ID,SEAT_NO,FOOD_ITEM,QTY,BILL_AMOUNT,ORDER_DATE,STATUS)"
					+ "values (?,?,?,?,?,?,?) ";
			final Object[] params = { orderItem.getId(), orderItem.getSeatNo(), orderItem.getFoodItem(),
					orderItem.getQty(), orderItem.getBillAmount(), orderItem.getBillStatus() };
			jdbcTemplate.update(sql, params);
			
		}

	
		public void delete(final int id) {
			final String sql = "delete from order_records where id=?";
			 jdbcTemplate.update(sql, id);
			
		}

	
		public List<OrderDetails> list() {
			final String sql = "Select ID,SEAT_NO,FOOD_ITEM,QTY,BILL_AMOUNT,ORDER_DATE,STATUS from order_records";
			return jdbcTemplate.query(sql, (rs, rowNum) -> {
				final OrderDetails item = convert(rs);
				return item;
			});
		}
	
		public OrderDetails convert(final ResultSet rs) throws SQLException {
				final OrderDetails orderItem = new OrderDetails();
				orderItem.setId(rs.getInt("ID"));
				Seat seat=new Seat();
				seat.setSeatNo(rs.getInt("SEAT_NO"));
				orderItem.setSeatNo(seat);
			    MenuItems itemPrice=new MenuItems();
				itemPrice.setFoodItem(rs.getString("FOOD_ITEM"));
				orderItem.setFoodItem(itemPrice);
				orderItem.setQty(rs.getInt("QTY"));
				orderItem.setBillAmount(rs.getInt("BILL_AMOUNT"));
				orderItem.setOrderDate(rs.getTimestamp("ORDER_DATE").toLocalDateTime());
				orderItem.setBillStatus(rs.getString("STATUS"));
				return orderItem;


		}
}
