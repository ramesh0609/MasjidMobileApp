package com.allmuslim.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allmuslim.dao.PrayerTimeDao;
import com.allmuslim.exception.CustomException;
import com.allmuslim.response.CalcMethodResponse;
import com.allmuslim.response.CalcValResponse;
import com.allmuslim.service.PrayerTimeService;

@Service
@Transactional
public class PrayerTimeServiceImpl implements PrayerTimeService{
	@Autowired
	private PrayerTimeDao prayerTimeDao;
	@Override
	public CalcMethodResponse getCalTypeByCountry(String country) {
		CalcMethodResponse resp=prayerTimeDao.getCalTypeByCountry(country);
		
		/*
		 * if(resp.getType()==null) { throw new
		 * CustomException("Country not available"); }
		 */
		//CalcMethodResponse responseData=prayerTimeDao.getCalcvalue(resp.getType(),resp);
		return resp;
	}
	@Override
	public List<CalcValResponse> calcValResponse() {
		List<CalcValResponse> calcValResponseList=prayerTimeDao.getcalcValResponse();
		return calcValResponseList;
	}
	

}
