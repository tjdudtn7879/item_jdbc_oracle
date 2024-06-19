package com.lgy.item_jdbc_oracle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ItemDTO {
	private String name;
	private int price;
	private String description;
}
