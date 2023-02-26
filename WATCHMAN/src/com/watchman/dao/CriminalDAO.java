package com.watchman.dao;

import java.util.List;

import com.watchman.dto.Criminal;
import com.watchman.exception.NoRecordFoundException;
import com.watchman.exception.SomeThingWrongException;

public interface CriminalDAO {
	public List<Criminal> getCriminalByName(String name) throws SomeThingWrongException, NoRecordFoundException;
	
	public List<Criminal> getCriminalByArea() throws SomeThingWrongException, NoRecordFoundException;
	
	
}
