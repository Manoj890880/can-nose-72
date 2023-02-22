package com.watchman.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.watchman.dto.Crime;
import com.watchman.dto.CrimeImpl;
import com.watchman.exception.NoRecordFoundException;
import com.watchman.exception.SomeThingWrongException;

public class CrimeDAOImpl implements CrimeDAO{

	@Override
	public void addCrime(Crime crime) throws SomeThingWrongException {
		Connection connection=null;
		
		try {
			connection=DBUtils.connectToDatabase();
			
			String INSERT_QUERY="INSERT INTO CRIME (date,place,crime_type,victims,details,suspected_names,status,ipc_section)"
					+ "VALUES (?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps=connection.prepareStatement(INSERT_QUERY);
			ps.setDate(1, Date.valueOf(crime.getDate()));
			ps.setString(2, crime.getPlace());
			ps.setString(3, crime.getCrimeType());
			ps.setString(4, crime.getVictims());
			ps.setString(5, crime.getDetails());
			ps.setString(6, crime.getSuspectedNames());
			ps.setString(7, crime.getStatus());
			ps.setInt(8, crime.getIpcSection());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new SomeThingWrongException();
		}finally {
			try {
				DBUtils.closeConnection(connection);
			} catch (SQLException e) {
				throw new SomeThingWrongException();
			}
		}
		
	}

	@Override
	public List<Crime> searchByCrime(String crime_type) throws SomeThingWrongException, NoRecordFoundException {
		Connection connection=null;
		List<Crime> crimeList=null;
		
		try {
			connection=DBUtils.connectToDatabase();
			
			String SELECT_QUERY="select * from crime where crime_type='"+crime_type+"' ";
			
			PreparedStatement ps=connection.prepareStatement(SELECT_QUERY);
			
			ResultSet rs=ps.executeQuery();
			
			if (isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No such crime found");
			}
			crimeList=getCrimeListFromResulSet(rs);
		} catch (SQLException e) {
			throw new SomeThingWrongException();
		}finally {
			try {
				DBUtils.closeConnection(connection);
			} catch (SQLException e) {
				throw new SomeThingWrongException();
			}
		}
		return crimeList;
	}

	private List<Crime> getCrimeListFromResulSet(ResultSet rs) throws SQLException {
		List<Crime> crimeList=new ArrayList<>();
		
		while (rs.next()) {
			Crime crime=new CrimeImpl();
			crime.setId(rs.getInt("id"));
			crime.setDate(rs.getDate("date").toLocalDate());
			crime.setPlace(rs.getString("place"));
			crime.setCrimeType(rs.getString("crime_type"));
			crime.setVictims(rs.getString("victims"));
			crime.setDetails(rs.getString("details"));
			crime.setSuspectedNames(rs.getString("suspected_names"));
			crime.setStatus(rs.getString("status"));
			crime.setIpcSection(rs.getInt("ipc_section"));
			
			crimeList.add(crime);
		}
		return crimeList;
	}

	private boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		return (!rs.isBeforeFirst() && rs.getRow() == 0)?true:false;
	}

	@Override
	public void solveCrimeById(Integer id) throws SomeThingWrongException {
		Connection connection=null;
		
		try {
			connection=DBUtils.connectToDatabase();
			
			String UPDATE_QUERY="update crime set status='solved' where id='"+id+"'";
			
			PreparedStatement ps=connection.prepareStatement(UPDATE_QUERY);
			
			
			ps.executeUpdate();
			System.out.println("Crime solved successfully");
		} catch (SQLException e) {
			throw new SomeThingWrongException();
		}finally {
			try {
				DBUtils.closeConnection(connection);
			} catch (SQLException e) {
				throw new SomeThingWrongException();
			}
		}
		
	}

	@Override
	public List<Crime> getCrimesByAreaWise() throws SomeThingWrongException, NoRecordFoundException {
		Connection connection=null;
		List<Crime> crimeList=null;
		
		try {
			connection=DBUtils.connectToDatabase();
			
			String SELECT_QUERY="SELECT * FROM crime C GROUP BY place, id ORDER BY place";
			
			PreparedStatement ps=connection.prepareStatement(SELECT_QUERY);
	
			
			ResultSet rs=ps.executeQuery();
			
			if(isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No crime Found");
			}
			
			crimeList=getCrimeListFromResulSet(rs);
			
		} catch (SQLException e) {
			throw new SomeThingWrongException();
		}finally {
			try {
				DBUtils.closeConnection(connection);
			} catch (SQLException e) {
				throw new SomeThingWrongException();
			}
		}
		
		return crimeList;	}

	@Override
	public List<Integer> getNumberOfSolvedAndUnsolvedCrime() throws SomeThingWrongException, NoRecordFoundException {
		Connection connection=null;
		List<Integer> crimeList=new ArrayList<>();
		

		try {
		    connection = DBUtils.connectToDatabase();
		
		    String SELECT_QUERY = "select count(id) from crime where status='solved';";
		
		    PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
		
		    ResultSet rs = ps.executeQuery();
		
		    if (!rs.next()) {
		        throw new NoRecordFoundException("No crime Found");
		    }
		
		    crimeList.add(rs.getInt(1));
		
		    SELECT_QUERY = "select count(id) from crime";
		
		    ps = connection.prepareStatement(SELECT_QUERY);
		    rs = ps.executeQuery();
		
		    if (!rs.next()) {
		        throw new NoRecordFoundException("No crime Found");
		    }
		
		    crimeList.add(rs.getInt(1));
		
		} catch (SQLException e) {
		    throw new SomeThingWrongException();
		} finally {
		    try {
		        DBUtils.closeConnection(connection);
		    } catch (SQLException e) {
		        throw new SomeThingWrongException();
		    }
		}
		
		return crimeList;	
		
	}

	@Override
	public Integer getNumberOfCrimesRecordedCurrentMonth() throws SomeThingWrongException, NoRecordFoundException {
		Connection connection=null;
		int count;
		

		try {
		    connection = DBUtils.connectToDatabase();
		
		    String SELECT_QUERY = "select count(date) from crime where month(date)=month(current_date());";
		
		    PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
		
		    ResultSet rs = ps.executeQuery();
		
		    if (!rs.next()) {
		        throw new NoRecordFoundException("No crime Found");
		    }
		
		    count=rs.getInt(1);
		
		    
		
		} catch (SQLException e) {
		    throw new SomeThingWrongException();
		} finally {
		    try {
		        DBUtils.closeConnection(connection);
		    } catch (SQLException e) {
		        throw new SomeThingWrongException();
		    }
		}
		
		return count;	
		
	}
	
}
