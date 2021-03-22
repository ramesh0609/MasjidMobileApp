package com.allmuslim.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;

import com.allmuslim.mysqlconfig.DbConnection;
import com.allmuslim.response.CalcValResponse;

public class GetCalcValue {
	private static final Logger log=LoggerFactory.getLogger(GetCalcValue.class);
	static PreparedStatement statement=null;
	ResultSet resultSet=null;
	Statement stmt=null;
	@Cacheable("calcValResponse")
	public static List<CalcValResponse> calcValResponse() {
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
