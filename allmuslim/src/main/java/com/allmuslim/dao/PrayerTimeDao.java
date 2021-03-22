package com.allmuslim.dao;

import java.util.List;

import com.allmuslim.response.CalcMethodResponse;
import com.allmuslim.response.CalcValResponse;

public interface PrayerTimeDao {

	CalcMethodResponse getCalTypeByCountry(String country);

	CalcMethodResponse getCalcvalue(String type, CalcMethodResponse resp);

	List<CalcValResponse> getcalcValResponse();

}
