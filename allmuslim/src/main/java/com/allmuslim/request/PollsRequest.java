package com.allmuslim.request;

import java.util.List;

public class PollsRequest {
	
	private Long id;
	private List<String> info;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<String> getInfo() {
		return info;
	}
	public void setInfo(List<String> info) {
		this.info = info;
	}
	
	

}
