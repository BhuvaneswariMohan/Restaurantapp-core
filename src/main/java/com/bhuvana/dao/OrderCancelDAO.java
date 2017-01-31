package com.bhuvana.dao;



import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.bhuvana.util.ConnectionUtil;



public class OrderCancelDAO {

	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public String cancelOrder(int orderId, String seatno, String item, String cancelMessage) {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("cancel_order").declareParameters(
				new SqlParameter("order_id", Types.INTEGER), new SqlParameter("seatno", Types.VARCHAR),
				new SqlParameter("item", Types.VARCHAR), new SqlOutParameter("cancel_message", Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);
		SqlParameterSource in = new MapSqlParameterSource().addValue("order_id", orderId).addValue("seatno", seatno)
				.addValue("item", item);

		Map<String, Object> execute = call.execute(in);
		return (String) execute.get(execute);

	}
}

