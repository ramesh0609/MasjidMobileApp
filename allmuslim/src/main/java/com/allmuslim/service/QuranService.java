package com.allmuslim.service;

import java.util.List;
import java.util.Set;

import com.allmuslim.response.SuraResponse;
import com.allmuslim.response.SurrahListResponse;

public interface QuranService {

	List<SuraResponse> getSurrah(String language);

	List<SurrahListResponse> getSurrahList();

}
