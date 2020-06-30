package com.kbcss.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import com.kbcss.bean.LoginTo;
import com.kbcss.bean.RegisterTo;
import com.kbcss.daoI.SecurityDAOI;
import com.kbcss.dbutil.DBConnectionFactory;
import com.kbcss.dbutil.SqlConstants;
import com.kbcss.exception.ConnectionException;
import com.kbcss.util.DateWrapper;

public class SecurityDaoImpl implements SecurityDAOI {

	Connection con;
	PreparedStatement pstmt;
	Statement st;
	ResultSet rs;

	public void closeConnection() throws ConnectionException {
		try {

			if (pstmt != null)
				pstmt.close();

			if (con != null)
				con.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			throw new ConnectionException(
					"Some Problem Occured during the closing connections");
		}
	}

	/**
	 * This loginCheck(LoginTo lt) method used to verify the loginid,password
	 * match in the userdetails table. and return the logintype if match the
	 * loginid,password in the database.
	 * 
	 * @param lt
	 *            LoginTo bean object contain the values of loginid,password
	 *            details.
	 * 
	 * @return the LoginType in String formate .based on the loginid,password
	 *         match in the USERDETAILS TABLE.
	 * 
	 * 
	 */

	public String loginCheck(LoginTo lt) throws ConnectionException {
		String ltype = null;

		try {
			con = DBConnectionFactory.getConnection();

			pstmt = con.prepareStatement(SqlConstants._GET_LOGINTYPE);
			// pstmt = con
			// .prepareStatement("select logintype from userdetails where
			// loginid=? and password=?");
			pstmt.setString(1, lt.getLoginid());
			pstmt.setString(2, lt.getPassword());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				ltype = rs.getString(1);

			}

		} catch (SQLException e) {
			throw new ConnectionException("please provide proper Data");
		}

		finally {
			closeConnection();
		}

		return ltype;

	}

	/**
	 * This checkAvailable(LoginTo lt) method used to Check the loginid
	 * available in the USERDETAILS table are not.
	 * 
	 * @param lt
	 *            LoginTo bean object contain the value loginid details.
	 * 
	 * 
	 * @return the boolean value based on the loginid available in the
	 *         USERDETAILS TABLE.
	 * 
	 * 
	 */

	public boolean checkAvailable(LoginTo lt) throws ConnectionException {
		boolean flag = false;

		try {

			con = DBConnectionFactory.getConnection();

			pstmt = con
					.prepareStatement(SqlConstants._CHECKAVAILABLE_LOGINNAME);
			pstmt.setString(1, lt.getLoginid());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
			}

		} catch (SQLException e) {
			throw new ConnectionException(
					"Login Id available are  Not Details  not available now .please Try Later  ");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return flag;
	}

	/**
	 * This insertNewUser(RegisterTo rt) method used to insert the NewUser
	 * details in the database.
	 * 
	 * @param rt
	 *            bean object contain the information of
	 * 
	 * username,Password,Logintype,securityquestion,securityanswer,Firstname,Lastname,Birthdate,
	 * Email,Houseno,Street,City,State,Country,Phoneno,Subname,Collegeid.
	 * 
	 * @return the boolean value based on the insertion of NewUser deatails in
	 *         the database USERDETAILS table
	 * 
	 * 
	 */
	public boolean insertNewUser(RegisterTo rt) throws ConnectionException {
		boolean flag = false;

		System.out.println("birthdate-"
				+ DateWrapper.parseDate(rt.getBirthdate()));
		if (rt.getSquest() == null) {
			rt.setSquest(rt.getOwnquest());
			System.out.println("squest" + rt.getSquest());
		}

		System.out.println("sqansw :" + rt.getSans());
		System.out.println("email-" + rt.getEmail());
		System.out.println("gender-" + rt.getGender());
		System.out.println("houseno:" + rt.getHouseno());
		System.out.println("street-" + rt.getStreet());
		System.out.println("city-" + rt.getCity());
		System.out.println("state-" + rt.getState());
		System.out.println("country-" + rt.getCountry());
		System.out.println("phoneno-" + rt.getPhoneno());
		System.out.println("subname" + rt.getSubname());
		System.out.println("logintype-" + rt.getLogintype());
		System.out.println("username-" + rt.getUsername());
		System.out.println("password-" + rt.getPassword());
		System.out.println("collegeid=" + rt.getCollegeid());

		try {
			con = DBConnectionFactory.getConnection();

			/*System.out.println("photo=" + rt.getPhoto());
			File f = new File(rt.getPhoto());
			FileInputStream fis = new FileInputStream(f);
			System.out.println("fole=" + f.length());
*/
			/*CallableStatement cstmt = con.prepareCall("{call insertprocedure"
					+ "(?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?)}");

			cstmt.setBinaryStream(1, fis, (int) f.length());
			cstmt.setString(2, rt.getUsername());
			cstmt.setString(3, rt.getPassword());
			cstmt.setString(4, rt.getLogintype());
			cstmt.setString(5, rt.getSquest());
			cstmt.setString(6, rt.getSans());
			cstmt.setString(7, rt.getFirstname());
			cstmt.setString(8, rt.getLastname());

			cstmt.setString(9, DateWrapper.parseDate(rt.getBirthdate()));
			cstmt.setString(10, rt.getEmail());
			cstmt.setString(11, rt.getHouseno());
			cstmt.setString(12, rt.getStreet());
			cstmt.setString(13, rt.getCity());
			cstmt.setString(14, rt.getState());
			cstmt.setString(15, rt.getCountry());

			cstmt.setString(16, rt.getPhoneno());
			cstmt.setString(17, rt.getSubname());
			cstmt.setString(18, rt.getCollegeid());
*/
			pstmt = con.prepareStatement("insert into USERDETAILS values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			
			
			
			pstmt.setInt(1,(int)Math.random());
			pstmt.setString(2, rt.getFirstname());
			pstmt.setString(3, rt.getLastname());
			pstmt.setString(4, DateWrapper.parseDate(rt.getBirthdate()));
			pstmt.setString(5, DateWrapper.parseDate(rt.getBirthdate()));

			pstmt.setString(6, rt.getUsername());
			pstmt.setString(7, rt.getPassword());
			pstmt.setString(8, rt.getLogintype());
			pstmt.setString(9, rt.getSquest());
			pstmt.setString(10, rt.getSans());
			pstmt.setString(11, null);
			pstmt.setString(12, rt.getEmail());
			pstmt.setInt(13, 100);
			pstmt.setInt(14, 106);
			
			
			/*cstmt.setString(11, rt.getHouseno());
			cstmt.setString(12, rt.getStreet());
			cstmt.setString(13, rt.getCity());
			cstmt.setString(14, rt.getState());
			cstmt.setString(15, rt.getCountry())	*/		

			
			int i = pstmt.executeUpdate();
			if (i == 1) {
				flag = true;
			} else {
				flag = false;

			}
			con.close();

		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Problem occured during the creation of New User details Please Try Later");
		} /*catch (FileNotFoundException e) {
			throw new ConnectionException("Image is Not available now");
		}*/ finally {
			closeConnection();
		}
		return flag;
	}

	/**
	 * This getPersonalDetails(String path, String loginid) method used to
	 * retrive the Personal Details from userdetails ,college and subject
	 * tables.
	 * 
	 * @param path the
	 *            path contain the (information ) giving the base location of
	 *            the image
	 * 
	 * @param loginid the
	 *            loginid contain the loginid information of who login the site.
	 * 
	 * @return vregisterTo  contain informaion
	 * 
	 */

	public Vector<RegisterTo> getPersonalDetails(String path, String loginid)
			throws ConnectionException {
		Vector<RegisterTo> vregisterTo = new Vector<RegisterTo>();
		try {
			con = DBConnectionFactory.getConnection();

			pstmt = con.prepareStatement(SqlConstants._GETPERSONALDETAILS);
			pstmt.setString(1, loginid);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				RegisterTo registerTo = new RegisterTo();
				registerTo.setUserid(rs.getString(1));
				int userid = Integer.parseInt(registerTo.getUserid());
				registerTo.setLogintype(rs.getString(2));
				registerTo.setFirstname(rs.getString(3));
				registerTo.setLastname(rs.getString(4));
				registerTo
						.setBirthdate1(DateWrapper.parseDate(rs.getString(5)));
				registerTo.setEmail(rs.getString(6));
				registerTo.setSubname(rs.getString(8));
				registerTo.setCollegename(rs.getString(9));

				Blob b = rs.getBlob(7);

				System.out.println(b.length());
				if (b != null) {

					byte b1[] = b.getBytes(1, (int) b.length());

					OutputStream fout = new FileOutputStream(path + "/"
							+ userid + ".jpg");
					fout.write(b1);

					registerTo.setPhoto(userid + ".jpg");
				}

				vregisterTo.add(registerTo);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Problem Occured During get the Personal Detail. Please Try Later.");
		} catch (FileNotFoundException e) {
			throw new ConnectionException("Image is not available Now");
		} catch (NullPointerException e) {
			throw new ConnectionException("Data is Null");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return vregisterTo;
	}

	/**
	 * This (changePassword(RegisterTo registerTo)) method used to Update the
	 * password in the userdetails table .
	 * 
	 * @param registerTo the
	 *            registerTo bean object contain the value details of
	 *            newpassword,username and oldpassword
	 * 
	 * @return the boolean value based on the password Update in the userdetails
	 *         table
	 * 
	 */

	public boolean changePassword(RegisterTo registerTo)
			throws ConnectionException {
		boolean flag = false;

		try {
			con = DBConnectionFactory.getConnection();

			pstmt = con.prepareStatement(SqlConstants._CHANGEPASSWORD);
			pstmt.setString(1, registerTo.getNewpassword());
			pstmt.setString(2, registerTo.getUsername());
			pstmt.setString(3, registerTo.getOldpassword());
			int n = pstmt.executeUpdate();
			if (n > 0) {
				flag = true;
				con.commit();

			} else {
				flag = false;
				con.rollback();

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			throw new ConnectionException(
					"Problem Occured during the change the password. Please Try Later");

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();

			}

		} finally {
			closeConnection();
		}

		return flag;

	}

	/**
	 * This (ChangeQuestion(RegisterTo registerTo)) method used to Update the
	 * Security question in the userdetails table.
	 * 
	 * @param  registerTo the
	 *            registerTo bean object contain the value details of
	 *            squest,sans,username,password.
	 * 
	 * @return the boolean value based on the FORGOTPWQUESTION,FORGOTPWANSWER
	 *         Update in the Userdetails table
	 * 
	 * 
	 * 
	 */

	public boolean changeQuestion(RegisterTo registerTo)
			throws ConnectionException {
		boolean flag = false;

		try {
			con = DBConnectionFactory.getConnection();

			pstmt = con.prepareStatement(SqlConstants._CHANGEQUESTION);
			pstmt.setString(1, registerTo.getSquest());
			pstmt.setString(2, registerTo.getSans());
			pstmt.setString(3, registerTo.getUsername());
			pstmt.setString(4, registerTo.getPassword());

			int n = pstmt.executeUpdate();
			if (n > 0) {
				flag = true;
				con.commit();
			} else {
				flag = false;
				con.rollback();
			}

		} catch (SQLException ex) {
			throw new ConnectionException(
					"Some Technical Problem Occured during the ChangQuestion.Please Try Later");

		} finally {
			closeConnection();
		}
		return flag;
	}
}
