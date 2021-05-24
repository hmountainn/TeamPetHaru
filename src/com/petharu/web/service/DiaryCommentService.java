package com.petharu.web.service;

import java.util.List;

import com.petharu.web.entity.DiaryComment;

public interface DiaryCommentService {
	
	List<DiaryComment> getList(int id);
	DiaryComment get(int id);
	
	int delete(int id);
	int insert(DiaryComment diaryComment);
	int update(DiaryComment diaryComment);
	int reply(DiaryComment diaryComment);

}
