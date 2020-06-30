package com.kbcss.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.Blob;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import com.kbcss.util.ConvertTime;
import com.kbcss.bean.InsertforumTo;
import com.kbcss.bean.QuestionTo;
import com.kbcss.daoI.ForumkbcssDaoI;
import com.kbcss.dbutil.DBConnectionFactory;
import com.kbcss.dbutil.SqlConstants;
import com.kbcss.exception.ConnectionException;
import com.kbcss.exception.DataNotFoundException;
import com.kbcss.util.DateWrapper;

public class ForumDetailsDaoImpl implements ForumkbcssDaoI {

	Connection con;
	PreparedStatement pstmt, pstmt1, pstmt2, pstmt3;
	ResultSet rs, rs1, rs5;
	Statement st;

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
	 * 
	 * This method called by InsertForumDetails servlet class
	 * 
	 * 
	 */

	public boolean insertForum(InsertforumTo ift) throws DataNotFoundException,
			ConnectionException {
		boolean flag = false;

		try {
			con = DBConnectionFactory.getConnection();
			String date1 = DateWrapper.parseDate(ift.getForumdate());

			date1.trim();
			System.out.println("date1" + date1.trim() + "date1");

			String str_date = date1.trim();
			DateFormat formatter;
			java.util.Date date;
			formatter = new SimpleDateFormat("dd-MMM-yyyy");
			date = (java.util.Date) formatter.parse(str_date);

			pstmt = con.prepareStatement(SqlConstants._INSERT_NEW_FORUM);

			java.sql.Date sqlDate = new java.sql.Date(date.getTime());

			pstmt.setString(1, ift.getSubjectref());
			pstmt.setString(2, ift.getTopicdescription());
			pstmt.setDate(3, sqlDate);
			pstmt.setString(4, ift.getFtime());
			int count = pstmt.executeUpdate();

			if (count > 0) {

				flag = true;
			}

		}

		catch (SQLException e) {
			throw new ConnectionException("Server Busy Please Try Later");
		}

		catch (ParseException e) {
			System.out.println("Exception :" + e);
		}

		catch (Exception e) {
			throw new ConnectionException(
					"================Server Busy Please Try Later++++++++++++++");

		}

		finally {

			closeConnection();
		}
		return flag;

	}

	public boolean updateForum(InsertforumTo ift) throws ConnectionException {
		boolean flag = false;
		try {
			con = DBConnectionFactory.getConnection();
			String date1 = DateWrapper.parseDate(ift.getForumdate());

			date1.trim();
			System.out.println("date1" + date1.trim() + "date1");

			String str_date = date1.trim();
			DateFormat formatter;
			java.util.Date date;
			formatter = new SimpleDateFormat("dd-MMM-yyyy");
			date = (java.util.Date) formatter.parse(str_date);

			System.out.println(ift.getSubjectref());
			System.out.println(ift.getTopicdescription());
			System.out.println(ift.getForumdate());
			System.out.println(ift.getFtime());
			System.out.println(ift.getForumid());

			pstmt = con
					.prepareStatement("update  FORUMS set SUBJECTREF=(select SUBID from SUBJECT where SUBNAME=?),TOPICDESCRIPTION=?,FORUMDATE=?,TIME=? where FORUMID=?");
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());

			pstmt.setString(1, ift.getSubjectref());
			pstmt.setString(2, ift.getTopicdescription());
			pstmt.setDate(3, sqlDate);

			// pstmt.setDate(3, ift.getForumdate());
			pstmt.setString(4, ift.getFtime());
			pstmt.setString(5, ift.getForumid());
			int i = pstmt.executeUpdate();

			pstmt.close();
			if (i > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			// TODO: handle exception
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			closeConnection();
		}

		return flag;

	}

	public Vector<InsertforumTo> viewForums(String forumid)
			throws ConnectionException {
		Vector<InsertforumTo> vift = new Vector<InsertforumTo>();

		try {
			con = DBConnectionFactory.getConnection();

			if (forumid == null)

				pstmt = con.prepareStatement(SqlConstants._VIEWALLFORUMS);

			else

				pstmt = con
						.prepareStatement("select f.FORUMID,s.SUBNAME,f.TOPICDESCRIPTION,f.FORUMDATE,f.TIME,s.SUBNAME from FORUMS f,SUBJECT s where f.SUBJECTREF=s.SUBID AND  f. FORUMID='"
								+ forumid + "'          ");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				InsertforumTo ift = new InsertforumTo();
				ift.setForumid(rs.getString(1));
				ift.setSubjectref(rs.getString(2));
				ift.setTopicdescription(rs.getString(3));
				// ift.setForumdate

				Date date = rs.getDate(4);

				// this is the conversion
				java.util.Date utilDate = new java.util.Date(date.getTime());

				ift.setForumdate(DateWrapper.parseDate1(utilDate));

				String time = rs.getString(5);
				int inttime = Integer.parseInt(time.substring(0, 2));
				System.out.println(inttime
						+ "Inttime=============================");
				time = new ConvertTime().ChangeTimeFormat(inttime);

				ift.setFtime(time);
				System.out.println(ift.getFtime());

				ift.setSubname(rs.getString(6));

				vift.add(ift);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			closeConnection();
		}
		return vift;
	}

	public String startForum() throws ConnectionException {
		InsertforumTo ift = null;
		String forumid = null;
		try {
			con = DBConnectionFactory.getConnection();
			pstmt1 = con
					.prepareStatement("SELECT TO_DATE (TO_CHAR (SYSTIMESTAMP, 'MON-DD-YYYY HH24:MI:SS'), 'MON-DD-YYYY HH24:MI:SS' ) AS my_date FROM DUAL");
			rs = pstmt1.executeQuery();
			if (rs.next()) {
				java.sql.Date date = rs.getDate(1);
				System.out.println("dbSqlTimestamp" + date + "dbSqlTimestamp");

				pstmt2 = con
						.prepareStatement("select FORUMID,TIME from FORUMS where FORUMDATE=?");
				pstmt2.setDate(1, date);
				rs1 = pstmt2.executeQuery();
			}
			while (rs1.next()) {
				ift = new InsertforumTo();

				ift.setForumid(rs1.getString(1));
				ift.setFtime(rs1.getString(2));

				System.out.println("IN the Foruid Forumdate ===============>"
						+ ift.getForumid() + "=====forumid");
				forumid = ift.getForumid();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return forumid;
	}

	public Vector<InsertforumTo> viewTime(String forumid)
			throws ConnectionException {

		Vector<InsertforumTo> viftime = null;

		int subfirsttime = 0;
		int subsecondtime = 0;
		try {
			con = DBConnectionFactory.getConnection();
			pstmt1 = con
					.prepareStatement("SELECT TO_DATE (TO_CHAR (SYSTIMESTAMP, 'YYYY-MON-DD HH24:MI'), 'YYYY-MON-DD HH24:MI' ) AS my_date FROM DUAL");

			rs = pstmt1.executeQuery();

			if (rs.next()) {

				java.sql.Time dbSqlTimestamp = rs.getTime(1);

				String s = dbSqlTimestamp.toString();
				System.out.println(s);
				System.out.println(s + "jklfdsjfkl");

				String systime = s.substring(0, 2);

				subfirsttime = Integer.parseInt(systime);
				System.out.println("==========systime=========>" + subfirsttime
						+ "+++++++systime++++++");

				/*
				 * Time t = Time.valueOf(s);
				 * 
				 * System.out.println("Time=" + t.toLocaleString()); String
				 * newpmam = t.toLocaleString();
				 * 
				 * subfirsttime = newpmam.substring(12, 17); String first =
				 * newpmam.substring(21);
				 * 
				 * subfirsttime = subfirsttime.concat(first);
				 * System.out.println("firstdate=======" + subfirsttime +
				 * "===firsttime");
				 */}

			pstmt2 = con.prepareStatement("select  sysdate+1/12   from dual");
			rs1 = pstmt2.executeQuery();

			if (rs1.next()) {

				java.sql.Time dbSqlTimestamp1 = rs1.getTime(1);
				System.out.println(dbSqlTimestamp1);
				String s1 = dbSqlTimestamp1.toString();
				System.out.println(s1);
				System.out.println(s1 + "fkkds");

				String systimetwo = s1.substring(0, 2);
				subsecondtime = Integer.parseInt(systimetwo);

				System.out.println("==========systime=========>"
						+ subsecondtime + "+++++++systime++++++");

				/*
				 * 
				 * 
				 * 
				 * 
				 * Time t1 = Time.valueOf(s1); System.out.println("Time1" +
				 * t1.toLocaleString()); String newpmam1 = t1.toLocaleString();
				 * subsecondtime = newpmam1.substring(12, 17); String second =
				 * newpmam1.substring(21); subsecondtime =
				 * subsecondtime.concat(second);
				 * System.out.println("secondString==" + subsecondtime +
				 * "secondString"); System.out.println("secondString==" +
				 * subsecondtime + "secondString");
				 */}

			// select * from FORUMS where TIME>='4:09:00 PM' and Time<'6:09:31
			// PM';
			// pstmt3 = con.prepareStatement(" select * from FORUMS where
			// TIME>=? and Time<? ");

			pstmt3 = con
					.prepareStatement(" select  *  from FORUMS where  FORUMID=? ");

			pstmt3.setString(1, forumid);

			rs5 = pstmt3.executeQuery();
			viftime = new Vector<InsertforumTo>();
			if (rs5.next()) {
				InsertforumTo iftbean = new InsertforumTo();
				iftbean.setForumid(forumid);
				System.out.println("FORUMID==>" + rs5.getString(1));
				iftbean.setForumid(rs5.getString(1));
				System.out.println("SUBJECTREF==>" + rs5.getInt(2));
				iftbean.setTopicdescription(rs5.getString(3));
				System.out.println("FORUMDATE====>" + rs5.getDate(4));
				System.out.println("=========================timedescti>"
						+ iftbean.getTopicdescription() + iftbean.getForumid());

				String s = rs5.getString(5);
				iftbean.setFtime(rs5.getString(5));

				String forumtime = s.substring(0, 2);

				int correcttime = Integer.parseInt(forumtime);
				System.out.print(subfirsttime + "<=");
				System.out.print(correcttime + "||");
				System.out.print(correcttime + 2);
				System.out.print(">");
				System.out.print(subfirsttime);

				if (subfirsttime <= correcttime
						|| correcttime + 2 > subfirsttime)
					viftime.add(iftbean);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return viftime;

	}

	public boolean InsertChatDetails(String loginid, String textarea,
			String forumid, String topicdescription) throws ConnectionException {
		System.out.println("loginid==" + loginid + "textarea======>" + textarea
				+ "forumid=====>" + forumid + "topicdescription====>"
				+ topicdescription);
		boolean flag = false;
		try {
			con = DBConnectionFactory.getConnection();
			pstmt = con
					.prepareStatement("insert into FORUMDETAILS values ((select USERID from userdetails where LOGINID=?),?,'"
							+ forumid + "','" + topicdescription + "'        )");
			pstmt.setString(1, loginid);
			pstmt.setString(2, textarea);

			int n = pstmt.executeUpdate();
			if (n > 0) {
				flag = true;

				System.out.println("insertion forum details sucessfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		finally {
			closeConnection();
		}

		return flag;
	}

	/**
	 * This (insertMaterial(QuestionTo questionTo)) method indirectly called by
	 * AddMaterial servlet class with parameter (QuestionTo pojo object)This
	 * object contain variable(login,file,subname,mname) values.This values used
	 * to insert New Material into NOTES table..
	 * 
	 * @param questionTo
	 *            bean object contain's the values of
	 *            loginname,material,subjectname,materialname.
	 * @return the boolean value based on the insertion of new Material in the
	 *         NOTES table.
	 * 
	 */

	public boolean insertMaterial(QuestionTo questionTo)
			throws ConnectionException {
		boolean flag = false;

		try {
			con = DBConnectionFactory.getConnection();
			String material = questionTo.getMaterial();
			pstmt = con.prepareStatement(SqlConstants._INSERT_NEW_MATERIAL);

			pstmt.setString(1, questionTo.getLogin());
			File file = new File(material);
			FileInputStream fis = new FileInputStream(file);
			pstmt.setBinaryStream(2, fis, (int) file.length());
			pstmt.setString(3, questionTo.getSubname());
			pstmt.setString(4, questionTo.getMname());
			int n = pstmt.executeUpdate();
			if (n > 0) {
				flag = true;
			} else {
				flag = false;
			}

		}

		catch (SQLException e) {
			throw new ConnectionException(
					"some Technical problem occured during the Insertion of new Material");
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return flag;
	}

	public Vector<QuestionTo> viewMaterial(String path, int cid)
			throws ConnectionException {

		Vector<QuestionTo> vcb = null;

		try {
			con = DBConnectionFactory.getConnection();
			pstmt = con.prepareStatement(SqlConstants._VIEW_MATERIAL);

			pstmt.setInt(1, cid);

			rs = pstmt.executeQuery();

			vcb = new Vector<QuestionTo>();

			while (rs.next()) {

				int id = rs.getInt(1);

				Blob b = rs.getBlob(2);
				byte b1[] = b.getBytes(1, (int) b.length());

				OutputStream fout = new FileOutputStream(path + "/" + id
						+ ".doc");
				// System.out.println(fout+"*********************");
				fout.write(b1);

				QuestionTo cb = new QuestionTo();
				cb.setCid(id);
				cb.setMaterial(".doc");
				vcb.add(cb);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return vcb;
	}

	public Vector<InsertforumTo> viewForumsBYDate(String date, String subname)
			throws ConnectionException {

		Vector<InsertforumTo> vinsertforumTo = new Vector<InsertforumTo>();

		try {

			con = DBConnectionFactory.getConnection();
			if (subname == null) {
				pstmt = con
						.prepareStatement(SqlConstants._VIEW_FORUMDETAILS_BYDATE);
				pstmt.setString(1, date);
			} else {
				pstmt = con
						.prepareStatement(SqlConstants._VIEW_FORUMDETAILS_BYSUBJECT);
				pstmt.setString(1, subname);
			}

			rs = pstmt.executeQuery();
			while (rs.next()) {
				InsertforumTo insertforumTo = new InsertforumTo();
				System.out.println("IN the success page");
				insertforumTo.setForumid(rs.getString(1));
				insertforumTo.setSubjectref(rs.getString(2));
				insertforumTo.setTopicdescription(rs.getString(3));
				java.sql.Date sqldate = rs.getDate(4);

				java.util.Date utildate = new java.util.Date(sqldate.getTime());

				String stringdate = DateWrapper.parseDate1(utildate);

				insertforumTo.setForumdate(stringdate);
				insertforumTo.setFtime(rs.getString(5));
				insertforumTo.setSubname(rs.getString(6));

				vinsertforumTo.add(insertforumTo);
				System.out.println(vinsertforumTo.size());

			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

		finally {
			closeConnection();
		}
		return vinsertforumTo;
	}

	/*
	 * public Vector<InsertforumTo> viewForumsBYSubName(String subname) {
	 * Vector<InsertforumTo> vinsertforumTo = new Vector<InsertforumTo>(); try {
	 * //pstmt = con.prepareStatement("select * from FORUMS where
	 * SUBJECTREF=(select SUBID from SUBJECT where SUBNAME=?)"); pstmt =
	 * con.prepareStatement("select
	 * f.FORUMID,f.SUBJECTREF,f.TOPICDESCRIPTION,f.FORUMDATE,f.TIME,s.SUBNAME
	 * from FORUMS f,SUBJECT s where f.SUBJECTREF=s.SUBID AND
	 * f.SUBJECTREF=(select SUBID from SUBJECT where SUBNAME=?)");
	 * 
	 * 
	 * 
	 * 
	 * //select f. //
	 * FORUMID,f.SUBJECTREF,f.TOPICDESCRIPTION,f.FORUMDATE,f.TIME,s.SUBNAME //
	 * from FORUMS f,SUBJECT s where f.SUBJECTREF=s.SUBID
	 * 
	 * 
	 * 
	 * 
	 * pstmt.setString(1, subname); rs = pstmt.executeQuery(); while (rs.next()) {
	 * InsertforumTo insertforumTo = new InsertforumTo(); System.out.println("IN
	 * the success page"); insertforumTo.setForumid(rs.getString(1));
	 * insertforumTo.setSubjectref(rs.getString(2));
	 * insertforumTo.setTopicdescription(rs.getString(3)); java.sql.Date sqldate =
	 * rs.getDate(4); String stringdate = DateWrapper.parseDate(sqldate);
	 * 
	 * insertforumTo.setForumdate(stringdate);
	 * insertforumTo.setFtime(rs.getString(5));
	 * insertforumTo.setSubname(rs.getString(6));
	 * 
	 * vinsertforumTo.add(insertforumTo);
	 * System.out.println(vinsertforumTo.size()); } } catch (Exception e) { //
	 * TODO: handle exception }
	 * 
	 * return vinsertforumTo; }
	 */
	public Vector<InsertforumTo> viewpreviousForumID(String forumrefid,
			String questiontype) throws ConnectionException {
		Vector<InsertforumTo> vinsertforumTo = new Vector<InsertforumTo>();

		try {

			con = DBConnectionFactory.getConnection();
			System.out.println("questiontype===" + questiontype
					+ "==questiontype");
			System.out.println(forumrefid);
			if ((forumrefid != null && questiontype == null)
					|| (forumrefid == null && questiontype == null))
				pstmt2 = con
						.prepareStatement(" select  Distinct f.Topicdescription,fd.FORUMREFID  from FORUMS f,FORUMDETAILS fd where f.FORUMID=fd.FORUMREFID ");
			else if (forumrefid == null && questiontype != null)
				pstmt2 = con
						.prepareStatement(" select  Distinct f.Topicdescription,fd.FORUMREFID  from FORUMS f,FORUMDETAILS fd where f.FORUMID=fd.FORUMREFID AND f.SUBJECTREF=(select SUBID from SUBJECT where SUBNAME='"
								+ questiontype + "') ");

			rs = pstmt2.executeQuery();
			while (rs.next()) {
				InsertforumTo insertforumTo = new InsertforumTo();
				insertforumTo.setTopicdescription(rs.getString(1));
				insertforumTo.setForumid(rs.getString(2));
				vinsertforumTo.add(insertforumTo);

			}

		} catch (SQLException e) {
			throw new ConnectionException(
					"View Forum Details Not Possible Please Try Later");
		}

		System.out.println(vinsertforumTo.size());

		return vinsertforumTo;
	}

	public Vector<InsertforumTo> viewpreviousForumData(String forumrefid)
			throws ConnectionException {
		Vector<InsertforumTo> vinsertforumTo = new Vector<InsertforumTo>();

		try {

			con = DBConnectionFactory.getConnection();
			pstmt = con
					.prepareStatement(" select u.loginid,f.forumdata from  FORUMDETAILS f,userdetails u where f.USERID=u.USERID and f.FORUMREFID='"
							+ forumrefid + "' ");

			rs = pstmt.executeQuery();
			while (rs.next()) {
				InsertforumTo insertforumTo = new InsertforumTo();
				insertforumTo.setTopicdescription(rs.getString(1));
				insertforumTo.setForumid(rs.getString(2));
				vinsertforumTo.add(insertforumTo);

			}

		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			closeConnection();
		}

		return vinsertforumTo;

	}

}
