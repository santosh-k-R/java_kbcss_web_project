package com.kbcss.delegate;

import java.util.Vector;

import com.kbcss.bean.College;
import com.kbcss.exception.ConnectionException;
import com.kbcss.serviceI.CollegeServiceI;
import com.kbcss.serviceImpl.CollegeServiceImpl;

public class CollegeDelegate {
	CollegeServiceI collegeServiceI=new CollegeServiceImpl();
	
	public boolean insertCollege(College college) throws ConnectionException
	{
		return collegeServiceI.insertCollege(college);
	}

	public Vector<College> viewCollege() throws ConnectionException {
		return collegeServiceI.viewCollege();
	}

	public boolean updateCollege(College college) throws ConnectionException
	{
		return collegeServiceI.updateCollege(college);
	}

	public Vector<College> ViewCollegeById(String collegeid)
			throws ConnectionException
			{
		return collegeServiceI.ViewCollegeById(collegeid);
			}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
