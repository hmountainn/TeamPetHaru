package com.petharu.web.service;

import java.sql.SQLException;
import java.util.List;

import com.petharu.web.entity.Schedule;

public interface ScheduleService {
	List<Schedule> getList();
	List<Schedule> getList(int month, int memberId);
	
	//스케쥴 한개 리턴 해주는 서비스(스케줄아이디로)
	Schedule get(int scheduleId);
	
	//insert
	int insert(Schedule schedule) throws SQLException, ClassNotFoundException;

	int update(Schedule schedule);
	
	int delete(int scheduleId);
	
}
