package com.Bitwise.TimeSheet.service;

import java.util.List;
import java.util.Optional;

import com.Bitwise.TimeSheet.exception.ResourceNotFound;
import com.Bitwise.TimeSheet.model.Resource;
import com.Bitwise.TimeSheet.model.TimeSheet;
import com.Bitwise.TimeSheet.model.TotalSum;

public interface TimeSheetService {

	public Resource saveData(Resource rs);
	public List<Resource> findAll() throws ResourceNotFound;
	public Resource updatedata(int resourseId, Resource rs) throws ResourceNotFound;
	public Optional<Resource> getsingleresource(int resourseId);
	public List<Resource> getByTimeSheet_Month(String month) throws ResourceNotFound;
	public Integer getsumbymonth(String month);

	
	//public int getsum();
	//public Optional<TimeSheet> gettsdata(int TimeSheetId);

}
