package com.studycafe.team.teamboard.service;

import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.studycafe.team.teamboard.dto.TeamBoardDTO;
import com.studycafe.team.teamboard.entity.TeamBoardEntity;
import com.studycafe.team.teamboard.repository.TeamBoardRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TeamBoardServiceImpl implements TeamBoardService {

	@Autowired
	private TeamBoardRepository teamBoardRepository;

	// 팀 등록 게시판 리스트
	@Override
	public Page<TeamBoardDTO> getTeamBoardList(Pageable pageable) {
		
		Page<TeamBoardEntity> boardList = teamBoardRepository.findAll(pageable);
        
        return new TeamBoardDTO().toDtoList(boardList);
        
	}

	// 팀 게시글 등록
	@Override
	@Transactional
	public Long teamBoardRegis(TeamBoardDTO teamBoardDTO) {

		log.info("팀 등록 글 작성로직 실행");

		return teamBoardRepository.save(teamBoardDTO.sendDataToEntity()).getTeamBoardNum();

	}

	// 조회하기
	@Override
	@Transactional
	public TeamBoardDTO getTeamBoardPost(long idx) {

		log.info("{} 번 게시글 조회", idx);

		TeamBoardEntity teamBoardEntity = teamBoardRepository.findById(idx)
				.orElseThrow(new Supplier<IllegalArgumentException>() {
					@Override
					public IllegalArgumentException get() {

						return new IllegalArgumentException("해당 게시글은 삭제되었거나 존재하지 않는 게시글입니다.");
					}
				});

		TeamBoardDTO teamBoards = TeamBoardDTO.builder()

				.teamBoardNum(teamBoardEntity.getTeamBoardNum()).teamBoardTitle(teamBoardEntity.getTeamBoardTitle())
				.teamBoardContent(teamBoardEntity.getTeamBoardContent())
				.teamBoardWriter(teamBoardEntity.getTeamBoardWriter()).createDate(teamBoardEntity.getCreateDate())
				.build();

		return teamBoards;
	}

}
