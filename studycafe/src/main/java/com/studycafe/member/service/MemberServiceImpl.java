package com.studycafe.member.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studycafe.member.entity.MemberAddressEntity;
import com.studycafe.member.entity.MemberEntity;
import com.studycafe.member.repository.MemberAddressRepository;
import com.studycafe.member.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memRe;

	@Autowired
	private MemberAddressRepository memberAddRe;

	@Override
	@Transactional
	public boolean insertMember(MemberEntity memberEntity, MemberAddressEntity memberAddressEntity) {

		try {
			MemberEntity insert1 = memRe.save(memberEntity);
			log.info("insert1 : {}", insert1);
			if (insert1 != null) {
				try {
					memberAddressEntity.setMemberEntity(memberEntity);
					MemberAddressEntity insert2 = memberAddRe.save(memberAddressEntity);
					log.info("insert2 : {}", insert2);
					if (insert2 != null) {
						return true;
					}
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return false;
	}

	@Override
	@Transactional
	public boolean idCheck(String username) {

		try {
			boolean idCheck = memRe.existsByUsername(username);
			log.info("idCheck 의 값은 ? :{}", idCheck);
			if (idCheck == true) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;

	}

	@Override
	@Transactional
	public boolean nickCheck(String nickName) {

		try {
			boolean nickCheck = memRe.existsByNickName(nickName);
			if (nickCheck == true) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public int getNewMemberCount() {
		// TODO Auto-generated method stub
		return memRe.findNewUser();
	}

	@Override
	public List<MemberEntity> getAllMember() {
		// TODO Auto-generated method stub
		return memRe.findAll();
	}

}
