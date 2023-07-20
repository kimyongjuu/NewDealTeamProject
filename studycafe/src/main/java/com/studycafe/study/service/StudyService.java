package com.studycafe.study.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.studycafe.study.entity.StudyEntity;

public interface StudyService {

	public void studyInsert(StudyEntity studyEntity); // 스터디 모집 게시글 등록
	public StudyEntity studySelect(int id); // 스터디 모집 게시글 검색
	public Page<StudyEntity> studyList(Pageable pageable);
	public Page<StudyEntity> studySearchList(String keyword, Pageable pageable);
}
