package com.soccer.www.dao.soccerdao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.soccer.www.vo.soccervo.PlaylistVO;

@Repository
@Mapper
public interface PlaylistDao {
	
	List<PlaylistVO> selectTest();
}
