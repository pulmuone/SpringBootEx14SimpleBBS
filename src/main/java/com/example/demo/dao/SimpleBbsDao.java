package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.SimpleBbsDto;

@Repository
public class SimpleBbsDao implements ISimpleBbsDao  {

	@Autowired
	JdbcTemplate template;
	
	@Override
	public List<SimpleBbsDto> listDao() {
		System.out.println("listDao()");

		String query = "select * from simple_bbs order by id desc";
		//여러줄은 query
		List<SimpleBbsDto> dtos = template.query(
				query, new BeanPropertyRowMapper<SimpleBbsDto>(SimpleBbsDto.class));
		
		return dtos;
	}

	@Override
	public SimpleBbsDto viewDao(String id) {
		System.out.println("viewDao()");
		
		String query = "select * from simple_bbs where id = " + id;
		//단일 행은 queryForObject
		SimpleBbsDto dto = template.queryForObject(
				query, new BeanPropertyRowMapper<SimpleBbsDto>(SimpleBbsDto.class));
		return dto;
	}

	@Override
	public int writeDao(String writer, String title, String content) {
		System.out.println("writeDao()");
		
		String query = 
				"insert into simple_bbs (id, writer, title, content) " +
		        " values (nextval(simple_bbs_seq), ?, ?, ?)";
		return template.update(query, writer, title, content);
	}

	@Override
	public int deleteDao(String id) {
		System.out.println("deleteDao()");
		
		String query = "delete from simple_bbs where id = ?";
		return template.update(query, Integer.parseInt(id));
	}
}
