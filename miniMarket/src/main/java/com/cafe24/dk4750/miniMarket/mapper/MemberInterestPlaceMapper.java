package com.cafe24.dk4750.miniMarket.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.MemberInterestPlace;

@Mapper
public interface MemberInterestPlaceMapper {
	
	// 멤버 아이디로 관심동네 찾기
	public MemberInterestPlace selectMemberInterestPlace(String memberId);
}
