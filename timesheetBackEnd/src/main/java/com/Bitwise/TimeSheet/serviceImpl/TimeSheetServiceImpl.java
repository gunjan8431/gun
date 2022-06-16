package com.Bitwise.TimeSheet.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.Bitwise.TimeSheet.exception.ResourceNotFound;
import com.Bitwise.TimeSheet.model.Resource;
import com.Bitwise.TimeSheet.model.TimeSheet;
import com.Bitwise.TimeSheet.model.TotalSum;

import com.Bitwise.TimeSheet.repository.ResourceRepository;
import com.Bitwise.TimeSheet.repository.TimeSheetRepository;

import com.Bitwise.TimeSheet.service.TimeSheetService;

@Service
public class TimeSheetServiceImpl implements TimeSheetService {

	@Autowired 
	ResourceRepository tr;



	@Autowired
	TimeSheetRepository hr;

	@Override
	public Resource saveData(Resource rs) 
	{
		String f=	rs.getTimesheet().getMonth().toLowerCase();
		rs.getTimesheet().setMonth(f);
		return tr.save(rs);
	}

	@Override
	public List<Resource> findAll() throws ResourceNotFound {

		List<Resource>rs=	tr.findAll();
		for (Resource res : rs) {
			if(!rs.isEmpty())
			{
				int sum=res.getTimesheet().getWeek1()+res.getTimesheet().getWeek2()+
						res.getTimesheet().getWeek3()+res.getTimesheet().getWeek4()+
						res.getTimesheet().getWeek5();
				res.getTimesheet().setTotal(sum);
				System.out.println(res.getTimesheet().getTotal());
				tr.save(res);
			}
			else {
				throw new ResourceNotFound("data not avaialble");
			}
		}
		return tr.findAll();
	}

	@Override
	public Resource updatedata(int resourseId, Resource rs) throws ResourceNotFound {
		rs.setResourseId(resourseId);
		Optional<Resource> rt=tr.findByresourseId(resourseId);
		rs.getTimesheet().setTimeSheetId(rt.get().getTimesheet().getTimeSheetId());
		return tr.save(rs);
	}

	@Override
	public Optional<Resource> getsingleresource(int resourseId) {

		return tr.findByresourseId(resourseId);
	}

	@Override
	public List<Resource> getByTimeSheet_Month(String month) throws ResourceNotFound {

		List<Resource>rs=	tr.findAll();
		for (Resource res : rs) {
			if(!rs.isEmpty())
			{
				int sum=res.getTimesheet().getWeek1()+res.getTimesheet().getWeek2()+
						res.getTimesheet().getWeek3()+res.getTimesheet().getWeek4()+
						res.getTimesheet().getWeek5();
				res.getTimesheet().setTotal(sum);
				System.out.println(res.getTimesheet().getTotal());
				tr.save(res);
			}
			else {
				throw new ResourceNotFound("data not avaialble");
			}
		}

		String h=month.toLowerCase();
		return tr.getByTimesheet_Month(h);
	}

	@Override
	public Integer getsumbymonth(String month) {

		return hr.totalSum(month);
	}
	
	

//	@Override
	//	public List<TotalSum> findtoatal() {
	//		
	//		return tsr.findAll();
	//	}

	//@Override
		//public int getsum() {
		//	int xx=tr.totalSum();
		//	return xx ;
		//}
	//@Override
		//public Optional<TimeSheet> gettsdata(int TimeSheetId) {
		//	Optional<TimeSheet> n=hr.findById(TimeSheetId);
		//	
		//	return n;
		//}



}
