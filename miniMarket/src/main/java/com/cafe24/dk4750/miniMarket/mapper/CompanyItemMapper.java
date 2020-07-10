package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.CompanyItem;
import com.cafe24.dk4750.miniMarket.vo.CompanyItemAndCompanyAndCompanyItemPic;

@Mapper
public interface CompanyItemMapper {
	
	// 업체 아이템 수정 (폼)
	public CompanyItem selectCompanyItemOneForUpdate(int companyItemNo);
	
	// 업체 아이템 수정 액션
	public int updateCompanyItem(CompanyItem companyItem);
	
	// 업체 아이템 있는 지 없는지 체크
	public int selectCompanyItemCheck(String companyUniqueNo);
	
	// 업체 아이템 추가(한번만 가능)
	public int insertCompanyItem(CompanyItem companyItem);
	
	// 홍보중인  업체 리스트
	public List<CompanyItemAndCompanyAndCompanyItemPic> selectCompanyItemList(Map<String, Object> map);
	
	// 카테고리별 홍보중인  업체 리스트 
	public List<CompanyItemAndCompanyAndCompanyItemPic> selectCompanyItemListByCategory(Map<String, Object> map);
	
	// 내가 좋아요 한 업체 아이템 리스트 출력
	public List<CompanyItemAndCompanyAndCompanyItemPic> selectMyLikeCompanyItem(Map<String, Object> map);
	
	// 다음 업체 아이템의 넘버를 알기위해서 현재 업체 아이템넘버 max+1 값 구해오기
	public int selectMaxPlusCompanyItemNo();
	
	// 업체 아이템 삭제(비활성화)
	public int disabledCompanyItem(CompanyItem companyItem);
}
