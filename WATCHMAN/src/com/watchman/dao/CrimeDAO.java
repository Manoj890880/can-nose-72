package com.watchman.dao;

import java.util.List;

import com.watchman.dto.Crime;
import com.watchman.exception.NoRecordFoundException;
import com.watchman.exception.SomeThingWrongException;

public interface CrimeDAO {
	
	public void addCrime(Crime crime) throws SomeThingWrongException;
	
	public List<Crime> searchByCrime(String crime_type) throws SomeThingWrongException, NoRecordFoundException;
	
	public void solveCrimeById(Integer id) throws SomeThingWrongException;
	
	public List<Crime> getCrimesByAreaWise() throws SomeThingWrongException, NoRecordFoundException;
	
	public List<Integer> getNumberOfSolvedAndUnsolvedCrime() throws SomeThingWrongException, NoRecordFoundException;
	
	public Integer getNumberOfCrimesRecordedCurrentMonth() throws SomeThingWrongException, NoRecordFoundException;
	
	
}
