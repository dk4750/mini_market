package com.cafe24.dk4750.miniMarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cafe24.dk4750.miniMarket.service.CompanyItemService;
import com.cafe24.dk4750.miniMarket.vo.CompanyItem;
import com.cafe24.dk4750.miniMarket.vo.CompanyItemAndCompanyAndCompanyItemPic;

@Controller
public class CompanyItemController {
	@Autowired private CompanyItemService companyItemService;
	
	// 홍보중인 업체 아이템 리스트 출력하기
	@GetMapping("/getCompanyItemList")
	public String getCompanyItemList(Model model) {
		System.out.println("getCompanyItemList<== 겟메핑 시작");
		
		// 리스트 받아오기
		List<CompanyItemAndCompanyAndCompanyItemPic> list = companyItemService.getCompanyItemList();
		
		// 리스트 모델에 담아서 페이지로 보내주기
		model.addAttribute("list", list);
		System.out.println(list+"<---리스트 정보");
		
		//페이지 요청
		return "getCompanyItemList";
	}
	
	// 업체 아이템 삭제(비활성화)
	@GetMapping("/disabledCompanyItem")
	public String disabledCompanyItem(CompanyItem companyItem) {
		System.out.println("disabledCompanyItem 겟매핑 시작");
		System.out.println(companyItem + "<==업체 아이템 삭제 / 업체 아이템 넘버 디버깅");
		
		String companyItemState = "삭제";
		companyItem.setCompanyItemState(companyItemState);
		
		companyItemService.disabledCompanyItem(companyItem);
		
		return "redirect:/getCompanyItemList";
	}
	
}
