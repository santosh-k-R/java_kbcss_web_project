package com.kbcss.serviceImpl;

import java.util.Vector;

import com.kbcss.bean.College;
import com.kbcss.daoI.CollegeDaoI;
import com.kbcss.daoImpl.CollegeDaoImple;
import com.kbcss.exception.ConnectionException;
import com.kbcss.serviceI.CollegeServiceI;

public class CollegeServiceImpl implements CollegeServiceI {
	CollegeDaoI collegeDaoI = new CollegeDaoImple();
	Vector<College> vcollege = null;

	public boolean insertCollege(College college) throws ConnectionException {
		return collegeDaoI.insertCollege(college);
	}

	public Vector<College> viewCollege() throws ConnectionException {
		return collegeDaoI.viewCollege();
	}

	public boolean updateCollege(College college) throws ConnectionException {
		return collegeDaoI.updateCollege(college);
	}

	public Vector<College> ViewCollegeById(String collegeid)
			throws ConnectionException {

		return collegeDaoI.ViewCollegeById(collegeid);
	}

}
