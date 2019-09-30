package com.globalcapital.pack.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.globalcapital.pack.database.dao.TaskHistory;

/**
 * @author michael.akinyade Remember to close the resultset object after calling
 *         the method.
 */
public class H2DatabaseLuncher {

	private static final Logger LOGGER = Logger.getLogger(H2DatabaseLuncher.class.getName());

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:./camunda-h2-dbs/process-engine;MVCC=TRUE;TRACE_LEVEL_FILE=0";
	/*
	 * static final String DB_URL =
	 * "jdbc:h2:file:/C:/database/test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;FILE_LOCK=NO";
	 */
	// Database credentials
	static final String USER = "sa";
	static final String PASS = "sa";

	public static TaskHistory getTaskHistoryByID(String id) {
		ResultSet rs = null;
		Connection con = null;
		Statement stmt = null;
		TaskHistory taskHistory = new TaskHistory();
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			String sql = "select * from ACT_HI_TASKINST where ID_ = " + "\'" + id + "'";
			stmt = con.createStatement();
			stmt.executeQuery(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				taskHistory.setId(rs.getString("ID_"));
				taskHistory.setAccountInstanceId(rs.getString("ACT_INST_ID_"));
				taskHistory.setDescription(rs.getString("DESCRIPTION_"));
				taskHistory.setDueDate(rs.getTimestamp("DUE_DATE_"));
				taskHistory.setDuration(rs.getLong("DURATION_"));
				taskHistory.setEndTime(rs.getTimestamp("END_TIME_"));
				taskHistory.setExecutionId(rs.getString("EXECUTION_ID_"));
				taskHistory.setFollowUpDate(rs.getDate("FOLLOW_UP_DATE_"));
				taskHistory.setProcessDefinitionkey(rs.getString("PROC_DEF_KEY_"));
				taskHistory.setRemovalTime(rs.getDate("REMOVAL_TIME_"));
				taskHistory.setStartTime(rs.getTimestamp("START_TIME_"));
			}

			stmt.close();
			con.close();
			rs.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				LOGGER.info(se2.getMessage());
			} // nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				LOGGER.log(Level.INFO, "Error occur", se);
				se.printStackTrace();
			} // end finally try
		} // end try

		return taskHistory;
	}

	public static void InsertUpdateAndTruncate(String sql) {

		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				LOGGER.log(Level.INFO, "Error occur", se2);

			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				LOGGER.log(Level.INFO, "Error occur", se);
			} // end finally try
		} // end try

	}

}
