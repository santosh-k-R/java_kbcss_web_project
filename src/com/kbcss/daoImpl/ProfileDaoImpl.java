package com.kbcss.daoImpl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import com.kbcss.bean.RegisterTo;
import com.kbcss.daoI.ProfileDaoI;
import com.kbcss.dbutil.DBConnectionFactory;
import com.kbcss.exception.ConnectionException;

public class ProfileDaoImpl implements ProfileDaoI {

	Connection con;
	PreparedStatement pstmt, pstmt1;
	ResultSet rs, rs1;

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
	 * The viewStudentProfile(String path, String cname, String subname)method
	 * used to get the StudentProfile of all Students if(collegename==null and
	 * subjectname==null) or if(collegname==null and subjectname not equal null )
	 * then return Student Profile based on the value of subjectname . or
	 * if(collegname not equal null and subjectname == null ) then return
	 * Student Profile based on the value of collegename .
	 * 
	 * @param  path
	 *        the path contain the url of image of the Student.
	 * 
	 * @param cname
	 *         the   cname contain the information of collegename.
	 * @param subname
	 *         the   subname contain the information of subjectname.
	 * 
	 * @return vregisterTo  contain the information(profile) of
	 *         student based on the condition and avaiable in the
	 *         userdetails,college and subject table.
	 * 
	 */

	public Vector<RegisterTo> viewStudentProfile(String path, String cname,
			String subname) throws ConnectionException {
		Vector<RegisterTo> vregisterTo = new Vector<RegisterTo>();
		try {
			// pstmt= con.prepareStatement("select
			// USERID,LOGINTYPE,firstname,lastname,to_char(dob),emailid,photograph,qualification,courseid
			// from userdetails where logintype='student'");
			System.out.println(cname);

			con = DBConnectionFactory.getConnection();

			if (cname == null && subname == null)
				pstmt = con
						.prepareStatement("select u.USERID,u.LOGINTYPE,u.firstname,u.lastname,u.dob,u.emailid,u.photograph,s.subname,c.cname from userdetails u,college c,subject s where u.logintype='students'and s.subid=u.SUBJECTREFNO and u.COLLEGEREFNO=c.COLLEGEID");
			else if (subname == null && cname != null)
				pstmt = con
						.prepareStatement("select u.USERID,u.LOGINTYPE,u.firstname,u.lastname,u.dob,u.emailid,u.photograph,s.subname,c.cname from userdetails u,college c,subject s where u.logintype='students'and s.subid=u.SUBJECTREFNO and u.COLLEGEREFNO=c.COLLEGEID AND  c.CNAME='"
								+ cname + "'");
			else
				pstmt = con
						.prepareStatement("select u.USERID,u.LOGINTYPE,u.firstname,u.lastname,u.dob,u.emailid,u.photograph,s.subname,c.cname from userdetails u,college c,subject s where u.logintype='students'and s.subid=u.SUBJECTREFNO and u.COLLEGEREFNO=c.COLLEGEID AND   s.SUBNAME='"
								+ subname + "'");

			rs = pstmt.executeQuery();
			while (rs.next()) {
				RegisterTo registerTo = new RegisterTo();
				registerTo.setUserid(rs.getString(1));
				int userid = Integer.parseInt(registerTo.getUserid());
				registerTo.setLogintype(rs.getString(2));
				registerTo.setFirstname(rs.getString(3));
				registerTo.setLastname(rs.getString(4));
				registerTo.setBirthdate1(rs.getString(5));
				registerTo.setEmail(rs.getString(6));

				registerTo.setSubname(rs.getString(8));
				registerTo.setCollegename(rs.getString(9));

				Blob b = rs.getBlob(7);
				if (b != null) {

					byte b1[] = b.getBytes(1, (int) b.length());

					OutputStream fout = new FileOutputStream(path + "/"
							+ userid + ".jpg");
					fout.write(b1);

					registerTo.setPhoto(userid + ".jpg");
				}
				registerTo.setSubname(rs.getString(8));

				vregisterTo.add(registerTo);

			}

		} catch (SQLException e) {
			throw new ConnectionException("Please Provide Proper Data");
		} catch (FileNotFoundException e) {
			throw new ConnectionException("File is not Available");
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			closeConnection();
		}
		return vregisterTo;

	}

	/**
	 * The viewStudentReport(String path, String loginid) method used get the
	 * student statical report.
	 * 
	 * @param path
	 *         the   path contain's the information (URL) of image of the student.
	 * @param loginid
	 *         the   loginid contain the details of who login the site.
	 * 
	 * @return map 
	 *         (Name,value) pair used to get the
	 *         Statical report of subject Marks.
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Integer> viewStudentReport(String path, String loginid)
			throws ConnectionException {
		Vector<RegisterTo> vregisterTo = new Vector<RegisterTo>();

		Map<String, Integer> map = new TreeMap<String, Integer>();
		map = new TreeMap();

		try {

			con = DBConnectionFactory.getConnection();
			int i = 0;
			pstmt = con
					.prepareStatement("select solid from solution where SOLVEDBYUSERIDREF=(select USERID from USERDETAILS where  LOGINID='"
							+ loginid + "')");
			// pstmt.setString(1, cname);

			rs = pstmt.executeQuery();

			while (rs.next())

			{
				RegisterTo registerTo = null;
				String solid = rs.getString(1);
				System.out.println("solution id=====" + solid);
				pstmt1 = con
						.prepareStatement("select sum(MARKS),SOLUTIONIDREF,QUESTIONTYPE from FORUMPOINTS Group BY SOLUTIONIDREF,QUESTIONTYPE   HAVING SOLUTIONIDREF=? ORDER BY SOLUTIONIDREF");
				pstmt1.setString(1, solid);
				rs1 = pstmt1.executeQuery();
				while (rs1.next()) {
					registerTo = new RegisterTo();
					i++;
					registerTo.setPoints(rs1.getInt(1));
					registerTo.setQuestiontype(rs1.getString(3));
					System.out.println(" q type" + rs1.getString(3));
					String questiontype = registerTo.getQuestiontype();

					if (!map.containsKey(questiontype))
						map.put(questiontype, new Integer(rs1.getInt(1)));

					else
						map.put(questiontype, new Integer(map.get(questiontype)
								+ rs1.getInt(1)));

					System.out.println(questiontype + "===Tehvalue==="
							+ map.get(questiontype));

					vregisterTo.add(registerTo);
					System.out.println("The Ve==size====" + vregisterTo.size()
							+ "The i value" + i);
				}

			}

			Iterator it = vregisterTo.iterator();

			while (it.hasNext()) {

				RegisterTo b3 = (RegisterTo) it.next();

				System.out.println("The vector points====" + b3.getPoints());
				System.out.println("The vector points===="
						+ b3.getQuestiontype());

				System.out.println("hai");

			}

		} catch (SQLException e) {
			throw new ConnectionException("Please Provide Proper Data");

		} finally {
			closeConnection();
		}

		return map;
	}

	/**
	 * The viewStudentLoginname(String cname,String subname, String FACULTY)
	 * 
	 */
	
	
	
	
	public Vector<RegisterTo> viewStudentLoginname(String cname,
			String subname, String FACULTY) throws ConnectionException {

		if (!"FACULTY".equalsIgnoreCase(FACULTY))
			FACULTY = null;

		Vector<RegisterTo> vregisterTo = new Vector<RegisterTo>();
		try {

			con = DBConnectionFactory.getConnection();
			if (cname == null && subname == null && FACULTY == null)
				pstmt = con
						.prepareStatement("select LOGINID from userdetails where logintype='students'");
			else if (cname == null && subname == null && FACULTY != null)
				pstmt = con
						.prepareStatement("select LOGINID from userdetails where logintype='faculty'");
			else if (cname == null && subname != null && FACULTY == null)
				pstmt = con
						.prepareStatement("select LOGINID from userdetails where logintype='students' and SUBJECTREFNO=(select SUBID from SUBJECT where SUBNAME='"
								+ subname + "' )");
			else if (cname == null && subname != null && FACULTY != null)
				pstmt = con
						.prepareStatement("select LOGINID from userdetails where logintype='faculty' and SUBJECTREFNO=(select SUBID from SUBJECT where SUBNAME='"
								+ subname + "' )");

			else if (cname != null && subname == null && FACULTY == null)
				pstmt = con
						.prepareStatement("select LOGINID from userdetails where logintype='students' and COLLEGEREFNO=(select COLLEGEID from COLLEGE  where CNAME='"
								+ cname + "' )");

			else if (cname != null && subname == null && FACULTY != null)
				pstmt = con
						.prepareStatement("select LOGINID from userdetails where logintype='faculty' and COLLEGEREFNO=(select COLLEGEID from COLLEGE  where CNAME='"
								+ cname + "' )");

			rs = pstmt.executeQuery();
			if (!(rs.next())) {
				RegisterTo registerTo = new RegisterTo();
				registerTo.setFaculty(FACULTY);
				// registerTo.setLastname(rs.getString(1));
				vregisterTo.add(registerTo);

			}
			while (rs.next()) {
				RegisterTo registerTo = new RegisterTo();
				registerTo.setUsername(rs.getString(1));
				registerTo.setFaculty(FACULTY);
				// registerTo.setLastname(rs.getString(1));
				vregisterTo.add(registerTo);

			}
		} catch (SQLException e) {
			throw new ConnectionException("Please Provide Proper DAta");
		}

		finally {
			closeConnection();
		}
		return vregisterTo;

	}

}
