package com.kbcss.daoImpl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import com.kbcss.bean.QuestionTo;
import com.kbcss.bean.RegisterTo;
import com.kbcss.bean.SolutionTo;
import com.kbcss.daoI.QuestionDaoI;
import com.kbcss.dbutil.DBConnectionFactory;
import com.kbcss.dbutil.SqlConstants;
import com.kbcss.exception.ConnectionException;

public class QuestionDaoImpl implements QuestionDaoI {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	Statement stmt;

	public void closeConnection() throws ConnectionException {
		try {

			if (pstmt != null)
				pstmt.close();

			if (con != null)
				con.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			throw new ConnectionException("++++");
		}
	}

	/**
	 * This (addNewSub(String subname)) method called by AddNewSubject servlet
	 * class Indirectly with parameter value subname. This method used to insert
	 * New Subject Details into SUBJECT table.
	 * 
	 * 
	 * @param subname
	 *            the name of the SubjectName
	 * 
	 * @return the boolean value based on the insertion of SubjectName in
	 *         Database.
	 * 
	 * 
	 * 
	 * 
	 */

	public boolean addNewSub(String subname) throws ConnectionException {

		boolean flag = false;
		try {
			con = DBConnectionFactory.getConnection();

			pstmt = con.prepareStatement(SqlConstants._ADDNEWSUBJECT);
			pstmt.setString(1, subname);
			int n = pstmt.executeUpdate();
			if (n > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Problem Occured During the Insertion of NewSubjectDetails.Please Try Later");
		} finally {
			closeConnection();
		}
		return flag;

	}

	/**
	 * The method viewSolution(String quesid, String path) used to get the
	 * information of
	 * SOLUTIONID,QUESTIONREFID,ANSWERS,SOLVEDBYUSERIDREF,POINTS,PHOTOGRAPH from
	 * the SOLUTION ,USERDETAILS table.
	 * 
	 * @param quesid  the
	 *            quesid contain the detail of questionidnumber.
	 * 
	 * @param path
	 *            path contain the details (url) of the image.
	 * @return vst
	 *  contain the information of the
	 *         solid,quesid,answers and some details.
	 * 
	 * 
	 * 
	 */

	public Vector<SolutionTo> viewSolution(String quesid, String path)
			throws ConnectionException {
		Vector<SolutionTo> vst = null;

		try {
			con = DBConnectionFactory.getConnection();
			pstmt = con.prepareStatement(SqlConstants._VIEWSOLUTION);
			pstmt.setString(1, quesid);
			rs = pstmt.executeQuery();
			vst = new Vector<SolutionTo>();
			while (rs.next()) {
				SolutionTo st = new SolutionTo();
				st.setSolid(rs.getString(1));
				st.setQuesref(rs.getString(2));
				st.setAnswers(rs.getString(3));
				st.setSolveduser(rs.getString(4));
				st.setPoints(rs.getString(5));
				int sol = Integer.parseInt(st.getSolid());
				Blob b = rs.getBlob(6);
				if (b != null) {
					byte b1[] = b.getBytes(1, (int) b.length());
					OutputStream fout = new FileOutputStream(path + "/" + sol
							+ ".jpg");
					fout.write(b1);
					st.setPhoto(sol + ".jpg");
				}
				vst.add(st);
			}

		} catch (SQLException e) {
			throw new ConnectionException(
					"The solution details are not available now Please Try later.");
		} catch (FileNotFoundException e) {
			throw new ConnectionException("the image is not available now");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return vst;
	}

	/**
	 * This (viewSubname()) method called by viewSubjectMaterialAction class
	 * Indirectly. This method used to Retrive the SubjectName Details from
	 * subject Table.
	 * 
	 * @return vqt 
	 *         contain the information of subjectid,subjectname information of subject table in the Database.
	 *
	 */

	public Vector<QuestionTo> viewSubname() throws ConnectionException {
		Vector<QuestionTo> vqt = new Vector<QuestionTo>();
		try {
			con = DBConnectionFactory.getConnection();
			pstmt = con.prepareStatement(SqlConstants._VIEWSUBJECT_NAMES);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				QuestionTo qt = new QuestionTo();
				qt.setSubid(rs.getString(1));
				qt.setSubname(rs.getString(2));
				vqt.add(qt);
			}

		} catch (SQLException e) {
			throw new ConnectionException(
					"Currently The Subject details Are Unavailable Please Try Later");
		} finally {
			closeConnection();
		}
		return vqt;
	}

	public boolean insertQuestion(QuestionTo qt) throws ConnectionException {
		boolean flag = false;
		try {
			con = DBConnectionFactory.getConnection();
			pstmt = con.prepareStatement(SqlConstants._INSERTQUESTION);
			pstmt.setString(1, qt.getQdetails());
			pstmt.setString(2, qt.getUsername());
			pstmt.setString(3, qt.getQuestiontype());
			pstmt.setString(4, qt.getTitle());

			int n = pstmt.executeUpdate();
			if (n > 0) {
				flag = true;
				con.commit();
			} else {
				flag = false;
				con.rollback();
			}
		} catch (SQLException e) {
		} finally {
			closeConnection();
		}
		return flag;
	}

	public Vector<QuestionTo> viewAns(String loginTo)
			throws ConnectionException {
		Vector<QuestionTo> vqt = null;

		try {
			con = DBConnectionFactory.getConnection();
			pstmt = con
					.prepareStatement(SqlConstants._VIEWQUESTION_ASKED_BYOWN);
			pstmt.setString(1, loginTo);

			rs = pstmt.executeQuery();
			vqt = new Vector<QuestionTo>();
			while (rs.next()) {
				QuestionTo qt1 = new QuestionTo();
				qt1.setQdetails(rs.getString(1));
				qt1.setStatus(rs.getString(2));
				qt1.setQuestiontype(rs.getString(3));
				qt1.setTitle(rs.getString(4));
				qt1.setUserid(rs.getString(5));
				qt1.setQuesid(rs.getString(6));
				qt1.setUsername(loginTo);
				vqt.add(qt1);

			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

		finally {
			closeConnection();
		}
		return vqt;

	}

	/**
	 * 
	 * 
	 */

	public Vector<QuestionTo> viewQuestion(String loginid, String quesid)
			throws ConnectionException {
		Vector<QuestionTo> vqt = null;

		try {

			con = DBConnectionFactory.getConnection();
			pstmt = con.prepareStatement(SqlConstants._VIEWQUESTION);
			pstmt.setString(1, loginid);
			pstmt.setString(2, quesid);
			rs = pstmt.executeQuery();
			vqt = new Vector<QuestionTo>();
			while (rs.next()) {
				QuestionTo qt1 = new QuestionTo();
				qt1.setQdetails(rs.getString(1));
				qt1.setStatus(rs.getString(2));
				qt1.setQuestiontype(rs.getString(3));
				qt1.setTitle(rs.getString(4));
				qt1.setUserid(rs.getString(5));
				qt1.setQuesid(rs.getString(6));
				qt1.setUsername(loginid);
				vqt.add(qt1);
			}

		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			closeConnection();
		}
		return vqt;

	}

	/**
	 * This viewAnswers(String path, String userid,String quesid) method used to
	 * get the details of userid,photograph,FIRSTNAME,LASTNAME from userdetails
	 * table (who login the our site details).
	 * 
	 * @param path
	 *            path contain the url (information) of the image location.
	 * 
	 * @param userid
	 *            userid contain the details of loginid(userid) details (who
	 *            login our site loginid details).
	 * 
	 * @param quesid
	 *            quesid contain the questionid information.
	 * 
	 * @return vqt
	 *  contain the information of the
	 *         userid,photograph,FIRSTNAME,LASTNAME from userdetails.
	 * 
	 * 
	 */
	public Vector<RegisterTo> viewAnswers(String path, String userid,
			String quesid) throws ConnectionException {
		Vector<RegisterTo> vqt = null;

		try {
			con = DBConnectionFactory.getConnection();
			pstmt = con.prepareStatement(SqlConstants._VIEWANSWERS);
			pstmt.setInt(1, Integer.parseInt(userid));
			rs = pstmt.executeQuery();
			vqt = new Vector<RegisterTo>();
			if (rs.next()) {
				RegisterTo qt = new RegisterTo();
				int userid1 = rs.getInt(1);
				qt.setFirstname(rs.getString(3));
				qt.setLastname(rs.getString(4));
				qt.setCity(Integer.toString(userid1));
				qt.setQuesid(quesid);
				Blob b = rs.getBlob(2);
				if (b != null) {
					byte b1[] = b.getBytes(1, (int) b.length());
					OutputStream fout = new FileOutputStream(path + "/"
							+ userid1 + ".jpg");
					fout.write(b1);
					qt.setPhoto(userid1 + ".jpg");
				}
				vqt.add(qt);
			}

		} catch (SQLException e) {
			throw new ConnectionException(
					"The User Details Not available now please Try later.");
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return vqt;

	}

	public Vector<QuestionTo> viewquestionByCategory(String questiontype)
			throws ConnectionException {
		Vector<QuestionTo> vqt = null;
		try {
			con = DBConnectionFactory.getConnection();
			pstmt = con
					.prepareStatement(SqlConstants._VIEW_QUESTION_BYCATEGORY);
			pstmt.setString(1, questiontype);
			rs = pstmt.executeQuery();
			vqt = new Vector<QuestionTo>();
			while (rs.next()) {
				QuestionTo qt1 = new QuestionTo();
				qt1.setQdetails(rs.getString(1));
				qt1.setStatus(rs.getString(2));
				qt1.setQuestiontype(rs.getString(3));
				qt1.setTitle(rs.getString(4));
				qt1.setUserid(rs.getString(5));
				qt1.setQuesid(rs.getString(6));
				vqt.add(qt1);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return vqt;
	}

	/*
	 * This method
	 * 
	 * 
	 */
	public Vector<QuestionTo> viewMaterialname(String subname)
			throws ConnectionException {
		Vector<QuestionTo> vquestionto = new Vector<QuestionTo>();

		try {
			con = DBConnectionFactory.getConnection();
			if (subname == null)
				pstmt = con
						.prepareStatement(SqlConstants._VIEW_ALL_MATERIALNAME);
			else
				pstmt = con
						.prepareStatement("select  MATERIALNAME , NOTESID  from notes where nname=(select subid from subject where subname='"
								+ subname + "')");

			rs = pstmt.executeQuery();
			while (rs.next()) {
				QuestionTo questionTo = new QuestionTo();
				questionTo.setMname(rs.getString(1));
				questionTo.setNotesid(rs.getString(2));
				vquestionto.add(questionTo);

			}

		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			closeConnection();
		}
		return vquestionto;

	}

}
