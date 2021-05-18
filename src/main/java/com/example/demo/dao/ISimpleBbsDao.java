package com.example.demo.dao;

import java.util.List;

import com.example.demo.dto.SimpleBbsDto;

public interface ISimpleBbsDao {

	public List<SimpleBbsDto> listDao();
	public SimpleBbsDto viewDao(String id);
	public int writeDao(String writer, String title, String content);
	public int deleteDao(String id);
	
}
