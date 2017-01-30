package com.bhuvana.model;



import java.time.LocalTime;

import lombok.Data;
@Data

public class SessionSchedule {

	private int id;
	private String foodtype;
	private LocalTime starttime;
	private LocalTime endtime;

}

