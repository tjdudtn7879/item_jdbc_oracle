package com.lgy.item_jdbc_oracle.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.item_jdbc_oracle.service.ItemContentService;
import com.lgy.item_jdbc_oracle.service.ItemService;
import com.lgy.item_jdbc_oracle.service.ItemWriteService;
import com.lgy.item_jdbc_oracle.util.Constant;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ItemController {
	ItemService service;
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
//		url 치고 들어오는 애
	@RequestMapping("/write_view")
	public String write_view() {
		log.info("@# write_view");
		
		return "item_write";
	}
	
	@RequestMapping("/write_result")
	public String write(HttpServletRequest request, Model model) {
		log.info("@# write_result");
		
		model.addAttribute("request", request);
		
		service = new ItemWriteService();
		service.execute(model);
		
		return "write_result";
	}
//	게시판 목록 조회
	@RequestMapping("/content_view")
	public String list(Model model) {
		log.info("@# content_view");
		
		service = new ItemContentService();
		service.execute(model);
		
		return "content_view";
	}
}
