package com.allmuslim.service;

import java.util.List;


import com.allmuslim.response.CalcMethodResponse;
import com.allmuslim.response.CalcValResponse;

public interface PrayerTimeService {

	CalcMethodResponse getCalTypeByCountry(String country);
	//@Cacheable("calcValResponse")
	List<CalcValResponse> calcValResponse();
	
	

}
