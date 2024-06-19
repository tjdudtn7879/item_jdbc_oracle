package com.lgy.item_jdbc_oracle.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.lgy.item_jdbc_oracle.dto.ItemDTO;
import com.lgy.item_jdbc_oraclel.dao.ItemDAO;


public class ItemContentService implements ItemService{

	@Override
	public void execute(Model model) {
		ItemDAO dao = new ItemDAO();
		ArrayList<ItemDTO> dtos = dao.list();
		model.addAttribute("content_view", dtos);
	}
	
}
