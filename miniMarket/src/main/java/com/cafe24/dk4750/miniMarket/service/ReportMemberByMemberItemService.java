package com.cafe24.dk4750.miniMarket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.ReportMemberByMemberItemMapper;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByMemberItem;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByMemberItemAndMemberItem;

@Service
@Transactional
public class ReportMemberByMemberItemService {
	@Autowired
	private ReportMemberByMemberItemMapper reportMemberByMemberItemMapper;
	
	// 신고 total 리스트 (페이징)
	public Map<String, Object> getReportMemberByMemberItemList(int currentPage, String reportState) {
		int rowPerPage = 10;
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		map.put("reportState", reportState);
		// lastPage
		int totalRow = reportMemberByMemberItemMapper.getTotalRow(reportState);
		int lastPage = totalRow/rowPerPage;
		if(totalRow%rowPerPage != 0) {
			lastPage += 1;
		}
		// list와 lastPage Map에 담는다
		List<ReportMemberByMemberItem> reportMemberByMemberItemList = reportMemberByMemberItemMapper.selectReportMemberByMemberItemAll(map);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("reportMemberByMemberItemList", reportMemberByMemberItemList);
		map2.put("lastPage", lastPage);
		
		return map2;
	}
	// 신고내용 상세보기
	public ReportMemberByMemberItemAndMemberItem getReportMemberByMemberItemOne(int reportNo) {
		return reportMemberByMemberItemMapper.selectReportMemberByMemberItemOne(reportNo);
	}
	// 신고 접수
	public int addReportMemberByMemberItem(ReportMemberByMemberItem reportMemberByMemberItem) {
		return reportMemberByMemberItemMapper.insertReportMemberByMemberItem(reportMemberByMemberItem);
	}
	//상태 수정
	public int modifyMemberByMemberItemState(ReportMemberByMemberItem reportMemberByMemberItem) {
		return reportMemberByMemberItemMapper.updateMemberByMemberItemState(reportMemberByMemberItem);
	}
}
