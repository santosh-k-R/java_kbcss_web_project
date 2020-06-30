package com.kbcss.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import com.kbcss.bean.College;
import com.kbcss.daoI.CollegeDaoI;
import com.kbcss.dbutil.DBConnectionFactory;
import com.kbcss.dbutil.SqlConstants;
import com.kbcss.exception.ConnectionException;

public class CollegeDaoImple implements CollegeDaoI {

	PreparedStatement pstmt;
	Connection con;
	ResultSet rs;

	public void closeConnection() {
		try {
			if (pstmt != null)
				pstmt.close();

			if (con != null)
				con.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * This method called by AddCollege Servlet indirectly with parameter (
	 * College pojo class object), The object contain values
	 * cname,district,palce,region values this values used to insert new college
	 * details into the COLLEGE table.
	 * 
	 * @param college
	 *            pojo object contain's the values
	 *            collegename,District,palce,region.
	 * 
	 * @return the boolean value based on the insertion of new college details
	 *         in COLLEGE table in database.
	 * 
	 * 
	 */
	public boolean insertCollege(College college) throws ConnectionException {
		boolean flag = false;

		try {
			con = DBConnectionFactory.getConnection();
			pstmt = con.prepareStatement(SqlConstants._INSERTNEW_COLLEGE);
			pstmt.setString(1, college.getCname());
			pstmt.setString(2, college.getDistrict());
			pstmt.setString(3, college.getPalce());
			pstmt.setString(4, college.getRegion());

			int n = pstmt.executeUpdate();

			if (n > 0) {
				flag = true;

			} else
				flag = false;

		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical problem occured During the Insert New College");

		} finally {
			closeConnection();
		}

		return flag;

	}

	/**
	 * This (viewCollege()) method called by ViewCollege servlet class
	 * Indirectly. This method used to Retrive the College Details from COLLEGE
	 * table.
	 * 
	 * 
	 * @return  vcollege contain the details of
	 *         collegeid,collegename,palce,district,region. This details return
	 *         in the vector format.
	 * 
	 * 
	 * 
	 */

	public Vector<College> viewCollege() throws ConnectionException {
		Vector<College> vcollege = new Vector<College>();
		try {
			con = DBConnectionFactory.getConnection();
			pstmt = con.prepareStatement(SqlConstants._VIEWCOLLEGE);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				College college = new College();
				college.setCollegeid(rs.getString(1));
				college.setCname(rs.getString(2));
				college.setPalce(rs.getString(3));
				college.setDistrict(rs.getString(4));
				college.setRegion(rs.getString(5));
				vcollege.add(college);

			}

		} catch (SQLException e) {
			throw new ConnectionException(
					"Currently College Details are Not available Please Try Later.");

		} finally {
			closeConnection();
		}
		return vcollege;
	}

	/**
	 * This updateCollege(College college) method used to Update the existing
	 * details of College.
	 * 
	 * @param college
	 *            bean object contain the details of
	 *            collegename,palce,district,region,collegeid.
	 * 
	 * @return the boolean value based on the Updation College details in the
	 *         COLLEGE table.
	 * 
	 */

	public boolean updateCollege(College college) throws ConnectionException {
		boolean flag = false;
		try {
			con = DBConnectionFactory.getConnection();

			pstmt = con.prepareStatement(SqlConstants._UPDATECOLLEGE_DETAILS);
			pstmt.setString(1, college.getCname());
			pstmt.setString(2, college.getPalce());
			pstmt.setString(3, college.getDistrict());
			pstmt.setString(4, college.getRegion());
			pstmt.setString(5, college.getCollegeid());
			int n = pstmt.executeUpdate();

			pstmt.close();
			if (n > 0) {
				flag = true;
				con.close();
			} else {
				flag = false;
			}

		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical Problem Occured during Update the college Details.Please Try Later");
		} finally {
			closeConnection();
		}

		return flag;

	}

	/**
	 * The ViewCollegeById(String collegeid) method used to View the College
	 * details based on the Collegeid.
	 * 
	 * @param collegeid
	 *            contain the details of collegeid information.
	 * 
	 * @return vcollege contains the details of
	 *         collegid,collegename,palce,district,region based on the collegeid
	 *         available in the COLLEGE table.
	 * 
	 * 
	 * 
	 */

	/* (non-Javadoc)
	 * @see com.kbcss.daoI.CollegeDaoI#ViewCollegeById(java.lang.String)
	 */
	public Vector<College> ViewCollegeById(String collegeid)
			throws ConnectionException {

		Vector<College> vcollege = new Vector<College>();

		try {
			con = DBConnectionFactory.getConnection();
			pstmt = con
					.prepareStatement(SqlConstants._VIEWCOLLEGE_DETAILS_BYID);
			pstmt.setString(1, collegeid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				College college = new College();
				college.setCollegeid(rs.getString(1));
				college.setCname(rs.getString(2));
				college.setPalce(rs.getString(3));
				college.setDistrict(rs.getString(4));
				college.setRegion(rs.getString(5));

				vcollege.add(college);
			}
			pstmt.close();
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Problem occured During get the College Details. Please Try Later");
		} finally {
			closeConnection();
		}
		return vcollege;
	}

}
