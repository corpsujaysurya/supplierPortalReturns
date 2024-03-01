package com.kpmg.te.retail.supplierportal.returns.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import com.kpmg.te.retail.supplierportal.returns.constants.ReturnConstants;
import com.kpmg.te.retail.supplierportal.returns.entity.CustomerReturnsMaster;

@Component
public class CustomerReturnsDao {
	
private static final Logger logger = Logger.getLogger(CustomerReturnsDao.class.getName());
	
	public Connection getConnectioDetails() throws ClassNotFoundException, SQLException {
		String myDriver = ReturnConstants.myDriver;
		String myUrl = ReturnConstants.myUrl;
		Class.forName(myDriver);
		Connection conn = DriverManager.getConnection(myUrl, ReturnConstants.mySQL_ID, ReturnConstants.mySQL_pass);
		return conn;
	}

	public void closeConnection(Connection conn) throws SQLException {
		conn.close();
	}

	public ArrayList<CustomerReturnsMaster> getcustReturnsList() throws SQLException, ClassNotFoundException {
		CustomerReturnsMaster custRetMasterObj = null;
		ArrayList<CustomerReturnsMaster> custRetMasterList = new ArrayList<CustomerReturnsMaster>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  * from SUPPLIER_PORTAL.CUSTOMER_RETURNS_MASTER LIMIT 20";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			custRetMasterObj = new CustomerReturnsMaster();
			custRetMasterObj.setReturnId(rs.getString("return_id"));
			custRetMasterObj.setReturnDate(rs.getString("return_date"));
			custRetMasterObj.setProcessedStatusFlag(rs.getString("processed_status_flag"));
			custRetMasterObj.setConcernRaisedFlag(rs.getString("concern_raised_flag"));
			custRetMasterList.add(custRetMasterObj);
		}
		logger.info("[C]CustomerReturnsDao::[M]getCRSummaryList -> The Customer Returns List is: "
				+ custRetMasterList.toString());
		return custRetMasterList;
	}

	public CustomerReturnsMaster getcustReturnsDetails(String returnId) throws SQLException, ClassNotFoundException {
		CustomerReturnsMaster custRetMasterObj = null;
		Connection conn = getConnectioDetails();
		String query = "SELECT  * from SUPPLIER_PORTAL.CUSTOMER_RETURNS_MASTER WHERE RETURN_ID ='"+ returnId+ "'";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			custRetMasterObj = new CustomerReturnsMaster();
			custRetMasterObj.setReturnId(rs.getString("return_id"));
			custRetMasterObj.setReturnDate(rs.getString("return_date"));
			custRetMasterObj.setReturnSite(rs.getString("return_Site"));
			custRetMasterObj.setCustomerName(rs.getString("CUSTOMER_NAME"));
			custRetMasterObj.setCustomerMobileNumber(rs.getString("CUSTOMER_MOBILE_NUMBER"));
			custRetMasterObj.setCustomerAddr(rs.getString("CUSTOMER_ADDRESS"));
			custRetMasterObj.setAwbNo(rs.getString("AWB_NO"));
			custRetMasterObj.seteWayBill("EWAY_BILL");
			custRetMasterObj.setTplPartner("TPL_PARTNER");
			
			custRetMasterObj.setOrderedDate(rs.getString("ordered_date"));
			custRetMasterObj.setReturnStatus("RETURN_STATUS");
			custRetMasterObj.setTotalUniqRetItems("TOTAL_UNIQUE_ITEMS");
			custRetMasterObj.setTotalReturnItems("TOTAL_ITEM_QUANTIY");
			custRetMasterObj.setTotalCostReturns("TOTAL_COST");
			custRetMasterObj.setReturnSite("RETURN_SITE");
			custRetMasterObj.setCustomerComments("CONCERN_MSG");
			
			custRetMasterObj.setProcessedStatusFlag(rs.getString("processed_status_flag"));
			custRetMasterObj.setConcernRaisedFlag(rs.getString("concern_raised_flag"));
			custRetMasterObj.setItemDetails(rs.getString("item_details"));
		}
		logger.info("[C]CustomerReturnsDao::[M]getcustReturnsDetails -> The Customer Returns Details are: "
				+ custRetMasterObj.toString());
		return custRetMasterObj;
	}

	public String UpdateProcessStatus(String returnId, String raiseConcernFlag, String concernMsg) throws SQLException, ClassNotFoundException {
		Connection conn = getConnectioDetails();
		String updateStatus = "Invalid";
		try {
			conn = getConnectioDetails();
				String query = "UPDATE SUPPLIER_PORTAL.CUSTOMER_RETURNS_MASTER SET PROCESSED_STATUS_FLAG = ? , CONCERN_RAISED_FLAG = ?, CONCERN_MSG = ? WHERE RETURN_ID = ?  ";
				logger.info(query);
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "Y");
				pstmt.setString(2, raiseConcernFlag);
				pstmt.setString(3, concernMsg);
				pstmt.setString(4, returnId);
				int updateStatusCode = pstmt.executeUpdate();
				logger.info(Integer.toString(updateStatusCode));
				updateStatus = (updateStatusCode == 1) ? ("SUCCESS") : ("FAILURE");
				pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn);
		}
		System.out.println();
		return updateStatus;
	}

	public String createCustomerReturn(CustomerReturnsMaster crMaster) throws SQLException {
			Connection conn = null;
			String status = new String();
			try {
				conn = getConnectioDetails();
				PreparedStatement pstmt = conn.prepareStatement(
						"INSERT INTO "+ ReturnConstants.SCHEMA_NAME +".CUSTOMER_RETURNS_MASTER (RETURN_ID,RETURN_DATE,PROCESSED_STATUS_FLAG,CONCERN_RAISED_FLAG,CUSTOMER_NAME,CUSTOMER_MOBILE_NUMBER,CUSTOMER_ADDRESS,AWB_NO,TPL_PARTNER,EWAY_BILL,ORDERED_DATE,RETURN_STATUS,TOTAL_ITEM_QUANTIY,TOTAL_UNIQUE_ITEMS,TOTAL_COST,RETURN_SITE,CUSTOMER_COMMENTS,ITEM_DETAILS)"
								+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pstmt.setString(1, crMaster.getReturnId());
				pstmt.setString(2, crMaster.getReturnDate());
				pstmt.setString(3, crMaster.getProcessedStatusFlag());
				pstmt.setString(4, crMaster.getConcernRaisedFlag());
				pstmt.setString(5, crMaster.getCustomerName());
				pstmt.setString(6, crMaster.getCustomerMobileNumber());
				pstmt.setString(7, crMaster.getCustomerAddr());
				pstmt.setString(8, crMaster.getAwbNo());
				pstmt.setString(9, crMaster.getTplPartner());
				pstmt.setString(10, crMaster.geteWayBill());
				pstmt.setString(11, crMaster.getOrderedDate());
				pstmt.setString(12, crMaster.getReturnStatus());
				pstmt.setString(13, crMaster.getTotalReturnItems());
				pstmt.setString(14, crMaster.getTotalUniqRetItems());
				pstmt.setString(15, crMaster.getTotalCostReturns());
				pstmt.setString(16, crMaster.getReturnSite());
				pstmt.setString(17, crMaster.getCustomerComments());
				pstmt.setString(18, crMaster.getItemDetails());
				int updateStatusCode =pstmt.executeUpdate();
				status = (updateStatusCode==1 ? ("Customer Return Record inserted in DB Successfully")
						: ("Customer Return Record Insertion Failed"));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeConnection(conn);
			}
			return status;
		}
}
