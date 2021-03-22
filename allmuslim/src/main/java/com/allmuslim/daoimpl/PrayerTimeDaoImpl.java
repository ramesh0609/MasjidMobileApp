package com.allmuslim.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.allmuslim.dao.PrayerTimeDao;
import com.allmuslim.mysqlconfig.DbConnection;
import com.allmuslim.response.CalcMethodResponse;
import com.allmuslim.response.CalcValResponse;


@Repository
public class PrayerTimeDaoImpl implements PrayerTimeDao{

	PreparedStatement statement=null;
	ResultSet resultSet=null;
	Statement stmt=null;
	private static final Logger log=LoggerFactory.getLogger(PrayerTimeDaoImpl.class);
	@Override
	public CalcMethodResponse getCalTypeByCountry(String country) {
		Connection con=DbConnection.getConnection();
		CalcMethodResponse res=new CalcMethodResponse();
		try
		{
			String sql="select type,calc_value,timezone from calc_method where alhpa=?";
			statement=con.prepareStatement(sql);
			statement.setString(1, country); 
			
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				res.setType(resultSet.getString("type"));
				res.setCalc_value(resultSet.getInt("calc_value"));
				res.setTimezone(resultSet.getDouble("timezone"));
			}
			
		}catch(Exception ex)
		{
			log.error(ex.getMessage());
		}
		
		
		return res;
	}
	@Override
	public CalcMethodResponse getCalcvalue(String type,CalcMethodResponse resp) {
		Connection con=DbConnection.getConnection();
		CalcMethodResponse res=new CalcMethodResponse();
		try
		{
			String sql="select * from calc_value where type=?";
			statement=con.prepareStatement(sql);
			statement.setString(1, type); 
			res=new CalcMethodResponse();
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				res.setType(resp.getType());
				res.setCalc_value(resp.getCalc_value());
				res.setTimezone(resultSet.getDouble("timezone"));
				res.setVal1(resultSet.getDouble("val1"));
				res.setVal2(resultSet.getDouble("val2"));
				res.setVal3(resultSet.getDouble("val3"));
				res.setVal4(resultSet.getDouble("val4"));
				res.setVal5(resultSet.getDouble("val5"));
				
				
			}
			
		}catch(Exception ex)
		{
			log.error(ex.getMessage());
		}
		
		
		return res;
	}
	@Override
	public List<CalcValResponse> getcalcValResponse() {
		Connection con=DbConnection.getConnection();
		List<CalcValResponse> resList=new ArrayList<CalcValResponse>();
		try
		{
			String sql="select * from calc_value ORDER BY order_id ASC";
			statement=con.prepareStatement(sql);
			resList=new ArrayList<CalcValResponse>();
			
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				CalcValResponse res=new CalcValResponse();
				res.setOrderid(resultSet.getInt("order_id"));
				res.setVal1(resultSet.getDouble("val1"));
				res.setVal2(resultSet.getDouble("val2"));
				res.setVal3(resultSet.getDouble("val3"));
				res.setVal4(resultSet.getDouble("val4"));
				res.setVal5(resultSet.getDouble("val5"));
				resList.add(res);
				
			}
			
		}catch(Exception ex)
		{
			log.error(ex.getMessage());
		}
		
		
		return resList;
	}

}
