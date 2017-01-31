package com.bhuvana.dao;


	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.List;

	import org.springframework.jdbc.core.JdbcTemplate;

import com.bhuvana.model.SessionSchedule;
import com.bhuvana.util.ConnectionUtil;

	

	public class SessionScheduleDAO {
		private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	
		public void save(final SessionSchedule category) {
			final String sql = "insert into session_schedule (ID,FOOD_TYPE,START_TIME,END_TIME) values (?,?,?,?) ";
			final Object[] params = { category.getId(), category.getFoodtype(), category.getStarttime(),
					category.getEndtime() };
			jdbcTemplate.update(sql, params);
			
		}

		
		public void delete(final int id) {
			final String sql = "delete from session_schedule where ID=?";
			final Object[] params = { id };
			 jdbcTemplate.update(sql, params);
			
		}

		public void update(final SessionSchedule category) {
			final String sql = "update session_schedule set category_description=? where ID=?";
			final Object[] params = { category.getFoodtype(), category.getId() };
		 jdbcTemplate.update(sql, params);
		
		}

		public List<SessionSchedule> list() {
			final String sql = "select ID,CATEGORY_DESCRIPTION,START_TIME,END_TIME from category_master";
			return jdbcTemplate.query(sql, (rs, rowNum) -> {
		    return convert(rs);
 
			});

		}

		static SessionSchedule convert(final ResultSet rs) throws SQLException {
			final SessionSchedule category = new SessionSchedule();
			category.setId(rs.getInt("ID"));
			category.setFoodtype(rs.getString("CATEGORY_DESCRIPTION"));
			category.setStarttime(rs.getTime("START_TIME").toLocalTime());
			category.setEndtime(rs.getTime("END_TIME").toLocalTime());
			return category;
		}
	}

