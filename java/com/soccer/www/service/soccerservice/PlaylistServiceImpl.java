package com.soccer.www.service.soccerservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soccer.www.dao.soccerdao.PlaylistDao;
import com.soccer.www.vo.soccervo.PlaylistVO;



@Service
public class PlaylistServiceImpl implements PlaylistService {

	@Autowired
	public PlaylistDao mapper;
	
	@Override
	public List<PlaylistVO> selectTest() throws Exception {
		return mapper.selectTest();
	}


       

}
