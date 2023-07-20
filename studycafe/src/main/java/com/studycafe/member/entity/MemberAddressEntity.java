package com.studycafe.member.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


import lombok.Data;

@Data
@Entity
public class MemberAddressEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressIdx;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "idx")
	private MemberEntity memberEntity;
	
	@NotNull
	private String zipcode; // 우편번호
	
	@NotNull
	private String address1; // 상세주소1, 시, 도 등등
	
	private String address2; // 상세주소2, 나머지 주소. null 가능
}
