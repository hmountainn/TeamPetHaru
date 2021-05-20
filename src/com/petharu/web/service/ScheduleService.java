package com.petharu.web.service;

import java.util.List;

import com.petharu.web.entity.Schedule;

public class ScheduleService {
	List<Schedule> getList();
	List<Schedule> getList(int month, int userId);
}
