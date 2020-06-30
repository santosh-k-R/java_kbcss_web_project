package com.kbcss.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import com.kbcss.bean.QueryTo;
import com.kbcss.daoI.QueryDAOI;
import com.kbcss.dbutil.DBConnectionFactory;
import com.kbcss.dbutil.SqlConstants;
import com.kbcss.exception.ConnectionException;

public class QueryDaoImpl implements QueryDAOI {

	PreparedStatement pstmt;
	Statement stmt, stmt1;
	ResultSet rs, rs1;
	Connection con;

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

	public boolean insertQuery(QueryTo qfb) throws ConnectionException {
		boolean flag = true;
		int uid = 0;
		int to = 0;

		try {

			con = DBConnectionFactory.getConnection();
			pstmt = con.prepareStatement(SqlConstants._INSERT_QUERY);
			String query = qfb.getQuery();
			String status = "inactive";
			String qdate = qfb.getDate();
			String from = qfb.getFrom();
			String toid = qfb.getTo();

			stmt = con.createStatement();
			rs = stmt
					.executeQuery("select userid from userdetails where loginid="
							+ "'" + from + "'");
			stmt1 = con.createStatement();
			rs1 = stmt1
					.executeQuery("select userid from userdetails where loginid="
							+ "'" + toid + "'");
			if (rs.next() && (rs1.next()))

				uid = rs.getInt(1);
			to = rs1.getInt(1);

			pstmt.setInt(1, uid);
			pstmt.setString(2, query);
			pstmt.setString(3, status);
			pstmt.setString(4, qdate);
			pstmt.setInt(5, to);
			int insert = pstmt.executeUpdate();

			if (insert > 0) {
				con.commit();
			} else {
				flag = false;
				con.rollback();
			}

		}

		catch (SQLException e) {

		}

		finally {
			closeConnection();
		}
		return flag;
	}

	public Vector<QueryTo> getQueries(String username)
			throws ConnectionException {
		Vector<QueryTo> vqb = null;
		String fname = "";
		String lname = "";

		try {

			con = DBConnectionFactory.getConnection();
			pstmt = con.prepareStatement(SqlConstants._GET_QUERY);
			pstmt.setString(1, username);

			rs = pstmt.executeQuery();

			vqb = new Vector<QueryTo>();
			while (rs.next()) {
				int qid = rs.getInt(1);
				@SuppressWarnings("unused")
				int uid = rs.getInt(2);
				String query = rs.getString(3);
				String status = rs.getString(4);
				String date = rs.getString(5);
				int sendto = rs.getInt(6);

				stmt = con.createStatement();
				// rs1=stmt.executeQuery("select firstname,lastname from
				// userdetails where userid="+uid);
				rs1 = stmt
						.executeQuery("select firstname,lastname from userdetails where userid="
								+ sendto);

				if (rs1.next())
					fname = rs1.getString(1);
				lname = rs1.getString(2);

				QueryTo qf = new QueryTo();

				qf.setDate(date);
				qf.setQid(qid);
				qf.setFname(fname);
				qf.setLname(lname);
				qf.setQuery(query);
				qf.setDate(date);
				qf.setQstatus(status);

						vqb.add(qf);

				}
		} catch (SQLException e) {
			throw new ConnectionException("Please Provide Proper Data");

		}

		finally {
			closeConnection();
		}
		return vqb;

	}

	public Vector<QueryTo> getQueriesAt(int qid1) throws ConnectionException {
		Vector<QueryTo> vqb = null;
		String fname = "";
		String lname = "";

		try {

			con = DBConnectionFactory.getConnection();
			pstmt = con.prepareStatement(SqlConstants._GET_QUERY_AT);

			pstmt.setInt(1, qid1);
			rs = pstmt.executeQuery();

			vqb = new Vector<QueryTo>();
			while (rs.next()) {
				int qid = rs.getInt(1);
				int uid = rs.getInt(2);
				String query = rs.getString(3);
				String status = rs.getString(4);
				String date = rs.getString(5);

				stmt = con.createStatement();
				rs1 = stmt
						.executeQuery("select firstname,lastname from userdetails where userid="
								+ uid);
				if (rs1.next())
					fname = rs1.getString(1);
				lname = rs1.getString(2);

				QueryTo qf = new QueryTo();

				qf.setDate(date);
				qf.setQid(qid);
				qf.setFname(fname);
				qf.setLname(lname);
				qf.setQuery(query);
				qf.setDate(date);
				qf.setQstatus(status);

		
				vqb.add(qf);
			}
		} catch (SQLException e) {

			System.out.println("Exception raised." + e);
			throw new ConnectionException("Please Provide Proper Data");

		}

		finally {
			closeConnection();
		}
		return vqb;
	}

}
