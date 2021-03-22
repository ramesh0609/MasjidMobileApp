package com.allmuslim.serviceimpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allmuslim.dao.QuranDao;
import com.allmuslim.response.SuraResponse;
import com.allmuslim.response.SurrahListResponse;
import com.allmuslim.service.QuranService;

@Transactional
@Service
public class QuranServiceImpl implements QuranService{
	
	@Autowired
	private QuranDao quranDao;

	@Override
	public List<SuraResponse> getSurrah(String language) {
		
		return null;
	}

	@Override
	public List<SurrahListResponse> getSurrahList() {
		List<SurrahListResponse> surahList=quranDao.getSurrahList();
		return surahList;
	}

}
