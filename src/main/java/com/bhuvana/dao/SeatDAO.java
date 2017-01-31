package com.bhuvana.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bhuvana.model.Seat;
import com.bhuvana.util.ConnectionUtil;



public class SeatDAO {

	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();


	public void save(final Seat seat) {
		final String sql = "insert into seat(ID,SEAT_NO,STATUS,CHECK_SEAT) values (?,?,?,?)";
		final Object[] params = { seat.getId(), seat.getSeatNo(), seat.getSeatStatus(), seat.getCheckSeat()};
		 jdbcTemplate.update(sql, params);
		
	}


	public void update(final Seat seat) {
		final String sql = "update seat set SEAT_STATUS=? where SEAT_NO= ?";
		final Object[] params = { seat.getSeatStatus(), seat.getSeatNo() };
		jdbcTemplate.update(sql, params);
		
	}


	public void delete(final int id) {
		final String sql = "delete from seat where id=?";
		 jdbcTemplate.update(sql, id);
	
	}


	public List<Seat> list() {
		final String sql = "Select ID,SEAT_NO,SEAT_STATUS from seat";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			return convert(rs);
		});

	}
	
	public Seat convert(final ResultSet rs) throws SQLException {
		final Seat seat = new Seat();
		seat.setId(rs.getInt("ID"));
		seat.setSeatNo(rs.getInt("SEAT_NO"));
		seat.setSeatStatus(rs.getString("SEAT_STATUS"));
		seat.setCheckSeat(rs.getInt("CHECK_SEAT"));
		return seat;
	}

}
