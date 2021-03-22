package com.allmuslim.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.allmuslim.dao.QuranDao;
import com.allmuslim.mysqlconfig.DbConnection;

import com.allmuslim.response.SurrahListResponse;

@Repository
public class QuranDaoImpl implements QuranDao{
	PreparedStatement statement=null;
	ResultSet resultSet=null;
	Statement stmt=null;
	private static final Logger log=LoggerFactory.getLogger(QuranDaoImpl.class);
	@Override
	public List<SurrahListResponse> getSurrahList() {
		Connection con=DbConnection.getConnection();
		List<SurrahListResponse> list=null;
		try
		{
			String sql="select surrahname,page,numberofayah from fahras order by page";
			statement=con.prepareStatement(sql);
			list=new ArrayList<SurrahListResponse>();
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				SurrahListResponse surahRes=new SurrahListResponse();
				surahRes.setSurahname(resultSet.getString("surrahname"));
				surahRes.setPage(resultSet.getInt("page"));
				surahRes.setNumberOfAyat(resultSet.getInt("numberofayah"));
				list.add(surahRes);
			}
			
		}catch(Exception ex)
		{
			log.error(ex.getMessage());
		}
		
		
		return list;
	}

}
