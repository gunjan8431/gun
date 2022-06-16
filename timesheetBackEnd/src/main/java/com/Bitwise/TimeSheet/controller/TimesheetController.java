package com.Bitwise.TimeSheet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Bitwise.TimeSheet.exception.ResourceNotFound;
import com.Bitwise.TimeSheet.model.Resource;
import com.Bitwise.TimeSheet.service.TimeSheetService;

@CrossOrigin("*")
@RestController
public class TimesheetController {
	@Autowired
	TimeSheetService timeSheetService;

	@GetMapping("/get")

	public ResponseEntity<List<Resource>> getdata() throws ResourceNotFound {
		if (!timeSheetService.findAll().isEmpty()) {
			return new ResponseEntity<List<Resource>>(timeSheetService.findAll(), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Resource>>(timeSheetService.findAll(), HttpStatus.NO_CONTENT);
		}

	}

	@PutMapping(value = "/update/{resourseId}")
	public ResponseEntity<Resource> update(@PathVariable int resourseId, @RequestBody Resource rs)
			throws ResourceNotFound {
		Resource res = null;
		try {
			res = timeSheetService.updatedata(resourseId, rs);
		} catch (Exception e) {
			throw new ResourceNotFound("Resource not available");
		}
		return new ResponseEntity<Resource>(res, HttpStatus.OK);
	}

	@GetMapping(value = "/getsumBymonth/{month}")
	public ResponseEntity<Integer> getsumbymonth(@PathVariable String month) {
		return new ResponseEntity<Integer>(timeSheetService.getsumbymonth(month), HttpStatus.OK);
	}

	@GetMapping(value = "/singeldata/{resourseId}")
	public ResponseEntity<Optional<Resource>> getsingleResource(@PathVariable int resourseId) throws ResourceNotFound 
	{
		if(timeSheetService.getsingleresource(resourseId).isPresent())
		{
		return new ResponseEntity<Optional<Resource>>(timeSheetService.getsingleresource(resourseId), HttpStatus.OK);
	}
		else
		{
			return new ResponseEntity<Optional<Resource>>(timeSheetService.getsingleresource(resourseId), HttpStatus.NO_CONTENT);
		}
	}
	@GetMapping(value = "/getByMonth/{Timesheet_Month}")
	public ResponseEntity<List<Resource>> getByMonth(@PathVariable("Timesheet_Month") String month)
			throws ResourceNotFound {
		if(!timeSheetService.getByTimeSheet_Month(month).isEmpty())
		{
		return new ResponseEntity<List<Resource>>(timeSheetService.getByTimeSheet_Month(month), HttpStatus.OK);
	}
		else
		{
			return new ResponseEntity<List<Resource>>(timeSheetService.getByTimeSheet_Month(month), HttpStatus.NO_CONTENT);
		}
	}
	// demo
	@PostMapping("/post")
	public ResponseEntity<Resource> postData(@RequestBody Resource rs) {
		return new ResponseEntity<Resource>(timeSheetService.saveData(rs), HttpStatus.CREATED);

	}

	// demo
	// @GetMapping(value="/getdata/{TimeSheetId}")
	// public Optional<TimeSheet> getdatademo(@PathVariable int TimeSheetId)
	// {
	// return timeSheetService.gettsdata(TimeSheetId);
	// }
	// @GetMapping(value="/getsum")
	// public int getsum()
	// {
	// return timeSheetService.getsum();
	// }

	//
}
