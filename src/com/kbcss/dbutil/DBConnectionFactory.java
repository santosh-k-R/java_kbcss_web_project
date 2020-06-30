package com.kbcss.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.kbcss.exception.ConnectionException;



public class DBConnectionFactory
{
	private static Connection mCon;
	private static Properties mProps;

	/**
	 * @return the props
	 */
	public static Properties getProperties()
	{
		return mProps;
	}

	/**
	 * @param aProps
	 *            application properties object
	 */
	public void setProperties(Properties aProps)
	{
		mProps = aProps;
	}

	public static Connection getConnection()throws ConnectionException
	{
		try
		{
			System.out.println("in  the connection block");
			Properties aProps = getProperties();
			Class.forName(aProps.getProperty("driver"));
			mCon = DriverManager.getConnection(aProps.getProperty("url"), aProps.getProperty("duser"), aProps.getProperty("dpass"));
		     System.out.println("mCon===="+mCon+"====mCon");
		}
		catch (ClassNotFoundException cnfe)
		{
			throw new ConnectionException("Technical Problem Please Try Later");
		}
		catch (SQLException se)
		{ 
		throw new ConnectionException("Server busy please Try Later");
		}
		return mCon;
	}

	public int getSequenceID(String tableName, String pkid)
	{
		int id = 0;
		try
		{
			mCon = getConnection();
			Statement st = mCon.createStatement();
			ResultSet rs = st.executeQuery("select max("+pkid+") from "+tableName); 
			if(rs.next())
				id=rs.getInt(1);
			id++;
		}
		catch(SQLException se)
		{se.printStackTrace();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				mCon.close();
			}
			catch(SQLException se)
			{
			    se.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return id;
	}
}
