
package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewBook {
	private String title;
	private String link;
	private String img;
	
	public NewBook(String title, String link) {
		super();
		this.title = title;
		this.link = link;
	}
	
	
}
