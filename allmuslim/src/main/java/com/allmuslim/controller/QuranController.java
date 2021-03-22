package com.allmuslim.controller;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.allmuslim.response.SuraResponse;
import com.allmuslim.response.SurrahListResponse;
import com.allmuslim.service.QuranService;

@RestController
@RequestMapping("/quran")
public class QuranController {
	
	@Autowired
	private QuranService quranService;
	
	private static final Logger log=LoggerFactory.getLogger(QuranController.class);
	@RequestMapping(value="getSurrah/{language}",method=RequestMethod.GET)
	public ResponseEntity<?> getSurrah(@PathVariable String language)
	{
		List<SuraResponse> response=quranService.getSurrah(language);
		return  ResponseEntity.ok(response);
		
	}
	@RequestMapping(value="getSurrahList",method=RequestMethod.GET)
	public ResponseEntity<?> getSurrahList()
	{
		List<SurrahListResponse> response=quranService.getSurrahList();
		return  ResponseEntity.ok(response);
		
	}
	
	

}
