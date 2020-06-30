package com.kbcss.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import com.kbcss.bean.SolutionTo;
import com.kbcss.daoI.SolutionDAOI;
import com.kbcss.dbutil.DBConnectionFactory;
import com.kbcss.dbutil.SqlConstants;
import com.kbcss.exception.ConnectionException;

public class SolutionDaoImpl implements SolutionDAOI {
	Connection con;
	PreparedStatement pstmt, pstmt1;
	ResultSet rs;
	Statement stmt;

	public void closeConnection() throws ConnectionException {
		try {

			if (pstmt != null)
				pstmt.close();
			if (pstmt1 != null)
				pstmt1.close();

			if (con != null)
				con.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			throw new ConnectionException(
					"some problem occured during the closing the connection");
		}
	}

	/**
	 * The insertAnswer(SolutionTo soutionTo) method used to insert solutions to
	 * question.
	 * 
	 * @param solutionTo
	 *            bean object contain questionid,answers,solveduser details.
	 * 
	 * @return the boolean value based on the insertion of solution to question
	 *         in the solution table.
	 * 
	 */
	public boolean insertAnswer(SolutionTo solutionTo)
			throws ConnectionException {
		boolean flag = false;

		try {

			con = DBConnectionFactory.getConnection();

			pstmt = con.prepareStatement(SqlConstants._INSERTANSWER);
			pstmt.setString(1, solutionTo.getQuesid());
			pstmt.setString(2, solutionTo.getAnswers());
			pstmt.setString(3, solutionTo.getSolveduser());

			int no = pstmt.executeUpdate();
			if (no > 0) {
				flag = true;
				con.commit();

			} else {
				flag = false;

			}
		}

		catch (SQLException e) {
			throw new ConnectionException(
					"Some Problem Occured  giving the solutions. please Try Later");
		} catch (Exception e) {
			throw new ConnectionException("please Provide proper Data");
		}

		finally {
			closeConnection();
		}
		return flag;
	}

	/**
	 * The addNewSub(String subname) method used to admin insert New Subject
	 * details in the SUBJECT table.
	 * 
	 * @param subname
	 *            bean object contain the details of subjectname.
	 * 
	 * @return the boolean value based on the insertion of New Subject details
	 *         in the Subject table.
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
					"Some Problem occured during the add new subject details.please Try later");
		}

		finally {
			closeConnection();
		}
		return flag;

	}

	/**
	 * The giveMarks(SolutionTo solutionTo) method used to give the marks to
	 * solutions of questions.in this method only one time marks given is
	 * possible.when user Try to give more than one time This method return the
	 * boolean value false.
	 * 
	 * @param solutionTo
	 *            bean object contain the details of solutionid,loginid and
	 *            points,questionid.
	 * 
	 * 
	 * @return the boolean value based on the FORUMPOINTS table already given
	 *         user or new user to give the marks.
	 * 
	 */
	public boolean giveMarks(SolutionTo solutionTo) throws ConnectionException {
		boolean flag = false;
		try {

			con = DBConnectionFactory.getConnection();

			pstmt1 = con
					.prepareStatement(SqlConstants._ALREADY_GIVENMARKSUSERORNOT);
			pstmt1.setString(1, solutionTo.getSolid());
			pstmt1.setString(2, solutionTo.getLoginid());
			rs = pstmt1.executeQuery();
			if ((rs.next())) {
				flag = false;

			} else {

				pstmt = con
						.prepareStatement(SqlConstants._IF_NOTALREADY_GIVENMARKSUSER);

				System.out.println(solutionTo.getPoints());

				pstmt.setString(1, solutionTo.getSolid());
				pstmt.setString(2, solutionTo.getLoginid());
				pstmt.setString(3, solutionTo.getPoints());
				pstmt.setString(4, solutionTo.getQuesid());

				int n = pstmt.executeUpdate();

				if (n > 0) {
					flag = true;
					con.commit();

				} else {
					flag = false;

				}
			}

		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical problem occured giving the Marks. Please Try Later.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return flag;
	}

	/**
	 * The insertSolution(SolutionTo sf) method used to when admin give the
	 * solution to the queries.
	 * 
	 * @param solutionTo
	 *            bean object contain's the details of queryid,solution
	 *            givendate and solution .
	 * 
	 * @return the boolean value based on the insert solution details in the
	 *         database.
	 * 
	 * 
	 * 
	 */

	public boolean insertSolution(SolutionTo solutionTo)
			throws ConnectionException {

		boolean flag = true;

		int update = 0;
		try {

			con = DBConnectionFactory.getConnection();

			pstmt = con.prepareStatement(SqlConstants._INSERT_SOLUTION);

			int qid = solutionTo.getQid();

			pstmt.setInt(1, qid);
			pstmt.setString(2, solutionTo.getRdate());
			pstmt.setString(3, solutionTo.getSolution());

			int insert = pstmt.executeUpdate();

			if (insert > 0) {
				stmt = con.createStatement();
				update = stmt
						.executeUpdate("update query set qstatus='solved' where queryid="
								+ qid);

			}

			if (update > 0) {

				con.commit();
			} else {
				flag = false;

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			throw new ConnectionException(
					"some Technical problem occured please Try Later");
		}

		finally {
			closeConnection();
		}

		return flag;

	}

	/**
	 * The getQueryStatus(String login) method used to get the Query status is
	 * inactive or solved.
	 * 
	 * @param login the
	 *            login contain the details of loginid details of userdetails
	 *            table.
	 * 
	 * @return vsb  contains the details of Query details
	 *         based on the loginid in the query table.
	 * 
	 * 
	 */

	public Vector<SolutionTo> getQueryStatus(String login)
			throws ConnectionException {

		Vector<SolutionTo> vsb = null;

		try {
			con = DBConnectionFactory.getConnection();

			pstmt1 = con
					.prepareStatement("select userid from userdetails where loginid=?");
			pstmt1.setString(1, login);
			rs = pstmt1.executeQuery();
			if (rs.next()) {
				int userid1 = rs.getInt(1);

				pstmt = con.prepareStatement(SqlConstants._GET_QUERY_STATUS);
				pstmt.setInt(1, userid1);
				pstmt.setInt(2, userid1);

				rs = pstmt.executeQuery();

				vsb = new Vector<SolutionTo>();
				while (rs.next()) {

					int qid = rs.getInt(1);
					int quid = rs.getInt(2);
					String description = rs.getString(3);
					String qdate = rs.getString(4);
					String sdate = rs.getString(5);
					String solution = rs.getString(6);
					int userid = rs.getInt(7);
					String status = rs.getString(8);

					SolutionTo sb = new SolutionTo();

					sb.setQid(qid);
					sb.setRdate(sdate);
					sb.setSolution(solution);
					sb.setQuery(description);
					sb.setRdate(sdate);
					sb.setRdate(qdate);
					sb.setUserid(userid);
					sb.setQuid(quid);
					sb.setStatus(status);

					vsb.add(sb);

				}
			}

		} catch (SQLException e) {
			throw new ConnectionException(
					"some Technical problem occured.Please Try Later");
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			closeConnection();
		}

		return vsb;

	}

	/**
	 * This getSolution(int qid,String login)method used to get the solution
	 * based on the Queryid .
	 * 
	 * @param qid the
	 *            qid contain the queryid details.
	 * 
	 * @param login  the
	 *            login contain the loginid details of userdetails Table.
	 * 
	 * @return vsb  contain the solution details based on the
	 *         queryid, and loginid.
	 * 
	 * 
	 */

	public Vector<SolutionTo> getSolution(int qid, String login)
			throws ConnectionException {

		Vector<SolutionTo> vsb = null;

		try {

			con = DBConnectionFactory.getConnection();

			// pstmt=con.prepareStatement(SqlConstants._GET_SOLUTION);

			pstmt = con
					.prepareStatement("select q.queryid,q.userid,q.qdescription,TO_CHAR(q.qdate,'DD-MM-YYYY'),TO_CHAR(s.soldate,'DD-MM-YYYY'),s.solution ,u.userid,q.qstatus from query q , FEEDBACKSOLU s ,userdetails u where q.queryid=s.queryid and s.queryid=? and u.loginid=?");
			pstmt.setInt(1, qid);
			pstmt.setString(2, login);

			rs = pstmt.executeQuery();

			vsb = new Vector<SolutionTo>();

			while (rs.next()) {

				int qid1 = rs.getInt(1);
				int quid = rs.getInt(2);
				String description = rs.getString(3);
				String qdate = rs.getString(4);
				String sdate = rs.getString(5);
				String solution = rs.getString(6);
				int userid = rs.getInt(7);
				String status = rs.getString(8);

				SolutionTo sb = new SolutionTo();

				sb.setQid(qid1);
				sb.setRdate(sdate);
				sb.setSolution(solution);
				sb.setQuery(description);

				sb.setSdate(qdate);
				sb.setUserid(userid);
				sb.setQuid(quid);
				sb.setStatus(status);

				vsb.add(sb);

			}

		} catch (SQLException e) {
			throw new ConnectionException("please provide proper Data");
		}

		finally {

			closeConnection();
		}

		return vsb;

	}

}
