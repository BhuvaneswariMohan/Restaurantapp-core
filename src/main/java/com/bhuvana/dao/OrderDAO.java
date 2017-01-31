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


	public class OrderDAO {


		private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
		

		public String placeOrder(int seatNo,String foodItem,int qty,String message) {
	        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("ORDERS")
	                .declareParameters(
	                		
	                        new SqlParameter("SEAT", Types.INTEGER),
	                        new SqlParameter("ITEM", Types.VARCHAR),
	                        new SqlParameter("QUANTITY", Types.INTEGER));
	                       // new SqlOutParameter("MESSAGE", Types.VARCHAR));
	        call.setAccessCallParameterMetaData(false);
	        
	        SqlParameterSource in = new MapSqlParameterSource().addValue("SEAT",seatNo)
	        													.addValue("ITEM", foodItem)
	        													.addValue("QUANTITY",qty );
	        Map<String, Object> execute = call.execute(in);
	        String status = (String) execute.get(execute);
	        return status;
	 
	    }


	}

