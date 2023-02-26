package com.watchman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.watchman.dto.Crime;
import com.watchman.dto.CrimeImpl;
import com.watchman.dto.Criminal;
import com.watchman.dto.CriminalImpl;
import com.watchman.exception.NoRecordFoundException;
import com.watchman.exception.SomeThingWrongException;

public class CriminalDAOImpl implements CriminalDAO{

	@Override
	public List<Criminal> getCriminalByName(String name) throws SomeThingWrongException, NoRecordFoundException {
		Connection connection=null;
		List<Criminal> criminalList=null;
		
		try {
			connection=DBUtils.connectToDatabase();
			
			String SELECT_QUERY = "SELECT * FROM criminals WHERE name = ?";
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			
			if (isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No such crime found");
			}
			
			
			criminalList=getCrimeListFromResulSet(rs);
		} catch (SQLException e) {
			throw new SomeThingWrongException();
		}finally {
			try {
				DBUtils.closeConnection(connection);
			} catch (SQLException e) {
				throw new SomeThingWrongException();
			}
		}
		return criminalList;
	}
	
	private List<Criminal> getCrimeListFromResulSet(ResultSet rs) throws SQLException {
		List<Criminal> criminalList=new ArrayList<>();
		
		while (rs.next()) {
			Criminal criminal=new CriminalImpl();
			criminal.setId(rs.getInt("criminal_id"));
			criminal.setName(rs.getString("name"));
			criminal.setAge(rs.getInt("age"));
			
			criminal.setGender(rs.getString("gender"));
			
			criminal.setAddress(rs.getString("address"));
			
			criminal.setIdentifyingMark(rs.getString("identifying_mark"));
			criminal.setArrestArea(rs.getString("arrest_area"));
			
			criminal.setAttachedCrime(rs.getString("attached_crime"));
			
			
			criminalList.add(criminal);
		}
		return criminalList;
	}

	private boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		return (!rs.isBeforeFirst() && rs.getRow() == 0)?true:false;
	}
//;

	@Override
	public List<Criminal> getCriminalByArea() throws SomeThingWrongException, NoRecordFoundException {
		Connection connection=null;
		List<Criminal> criminalList=null;
		
		try {
			connection=DBUtils.connectToDatabase();
			
			String SELECT_QUERY = "SELECT * FROM criminals GROUP BY address, criminal_id ORDER BY address ASC";
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			
			ResultSet rs = ps.executeQuery();
			
			if (isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No such crime found");
			}
			criminalList=getCrimeListFromResulSet(rs);
		} catch (SQLException e) {
			throw new SomeThingWrongException();
		}finally {
			try {
				DBUtils.closeConnection(connection);
			} catch (SQLException e) {
				throw new SomeThingWrongException();
			}
		}
		return criminalList;
		
	}
	
}
