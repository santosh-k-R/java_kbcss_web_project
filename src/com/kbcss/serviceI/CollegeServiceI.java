package com.kbcss.serviceI;


import java.util.Vector;

import com.kbcss.bean.College;
import com.kbcss.exception.ConnectionException;

public interface CollegeServiceI {
	
	
	public boolean insertCollege(College college) throws ConnectionException;

	public Vector<College> viewCollege() throws ConnectionException;

	public boolean updateCollege(College college) throws ConnectionException;

	public Vector<College> ViewCollegeById(String collegeid)
			throws ConnectionException;

	
	
	
}
