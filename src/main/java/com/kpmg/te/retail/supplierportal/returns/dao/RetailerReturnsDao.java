package com.kpmg.te.retail.supplierportal.returns.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import com.kpmg.te.retail.supplierportal.returns.constants.ReturnConstants;
import com.kpmg.te.retail.supplierportal.returns.entity.RetailerReturnsMaster;

@Component
public class RetailerReturnsDao {
	
	private static final Logger logger = Logger.getLogger(RetailerReturnsDao.class.getName());
	
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

	public ArrayList<RetailerReturnsMaster> getRRSummaryList() throws SQLException, ClassNotFoundException {
		RetailerReturnsMaster retailerRetMasterObj;
		ArrayList<RetailerReturnsMaster> retailerRetMastersList = new ArrayList<RetailerReturnsMaster>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  * from SUPPLIER_PORTAL.RETAILER_RETURNS_MASTER LIMIT 20";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			retailerRetMasterObj = new RetailerReturnsMaster();
			retailerRetMasterObj.setReturnId(rs.getString("return_id"));
			retailerRetMasterObj.setReturnDate(rs.getString("return_date"));
			retailerRetMasterObj.setProcessedStatusFlag(rs.getString("processed_status_flag"));
			retailerRetMasterObj.setConcernRaisedFlag(rs.getString("concern_raised_flag"));
			retailerRetMastersList.add(retailerRetMasterObj);
		}
		logger.info("[C]RetailerReturnsDao::[M]getRRSummaryList -> The Retailer Returns List is: "
				+ retailerRetMastersList.toString());
		return retailerRetMastersList;
	}

	public RetailerReturnsMaster getRRSummaryDetails(String retailerReturnID) throws SQLException, ClassNotFoundException {
		RetailerReturnsMaster retailerRetMasterObj = null;
		Connection conn = getConnectioDetails();
		String query = "SELECT  * from SUPPLIER_PORTAL.RETAILER_RETURNS_MASTER WHERE RETURN_ID = '"+retailerReturnID + "'";
		Statement st = conn.createStatement();
		logger.info(query);
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			retailerRetMasterObj = new RetailerReturnsMaster();
			retailerRetMasterObj.setReturnId(rs.getString("return_id"));
			retailerRetMasterObj.setReturnDate(rs.getString("return_date"));
			retailerRetMasterObj.setProcessedStatusFlag(rs.getString("processed_status_flag"));
			retailerRetMasterObj.setConcernRaisedFlag(rs.getString("concern_raised_flag"));
			retailerRetMasterObj.setOrderedDate(rs.getString("ordered_date"));
			retailerRetMasterObj.setPoList(rs.getString("po_list"));
			retailerRetMasterObj.setAsnList(rs.getString("asn_list"));
			retailerRetMasterObj.setConcernMsg(rs.getString("concern_msg"));
			retailerRetMasterObj.setReturnStatus(rs.getString("return_status"));
			retailerRetMasterObj.setTotalReturnItems(rs.getString("total_item_quantiy"));
			retailerRetMasterObj.setTotalUniqRetItems(rs.getString("total_unique_items"));
			retailerRetMasterObj.setTotalCostReturns(rs.getString("total_cost"));
			retailerRetMasterObj.setReturnSite(rs.getString("return_Site"));
			retailerRetMasterObj.setTruckNo(rs.getString("truck_No"));
			retailerRetMasterObj.setDriverName(rs.getString("driver_Name"));
			retailerRetMasterObj.setDriverDLNo(rs.getString("driver_DL_No"));
			retailerRetMasterObj.setLogisticsPartner(rs.getString("logistics_Partner"));
			retailerRetMasterObj.setItemDetails(rs.getString("item_details"));
		}
		logger.info("[C]RetailerReturnsDao::[M]getRRSummaryDetails -> The Retailer Returns List is: "
				+ retailerRetMasterObj.toString());
		return retailerRetMasterObj;
	}

	public String UpdateProcessStatus(String itemDetails, String returnId,String concernRaisedFlag) throws ClassNotFoundException, SQLException {
		Connection conn = getConnectioDetails();
		String updateStatus = "Invalid";
		try {
			conn = getConnectioDetails();
				String query = "UPDATE SUPPLIER_PORTAL.RETAILER_RETURNS_MASTER SET PROCESSED_STATUS_FLAG = ? , CONCERN_RAISED_FLAG = ?, ITEM_DETAILS = ? WHERE RETURN_ID = ?  ";
				logger.info(query);
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1,"Y");
				pstmt.setString(2,concernRaisedFlag);
				pstmt.setString(3,itemDetails);
				pstmt.setString(4,returnId);
				int updateStatusCode = pstmt.executeUpdate();
				logger.info(Integer.toString(updateStatusCode));
				updateStatus = (updateStatusCode == 1) ? ("SUCCESS") : ("FAILURE");
				pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn);
		}
		return updateStatus;
	}

	public String createRetailerReturn(RetailerReturnsMaster rrMaster) throws SQLException {
		Connection conn = null;
		String status = new String();
		try {
			conn = getConnectioDetails();
			PreparedStatement pstmt = conn.prepareStatement(
					"INSERT INTO "+ ReturnConstants.SCHEMA_NAME +".RETAILER_RETURNS_MASTER (RETURN_ID,RETURN_DATE,PROCESSED_STATUS_FLAG,CONCERN_RAISED_FLAG,PO_LIST,ASN_LIST,ORDERED_DATE,RETURN_STATUS,TOTAL_ITEM_QUANTIY,TOTAL_UNIQUE_ITEMS,TOTAL_COST,RETURN_SITE,TRUCK_NO,DRIVER_NAME,DRIVER_DL_NO,LOGISTICS_PARTNER,ITEM_DETAILS,CUSTOMER_COMMENT)"
							+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, rrMaster.getReturnId());
			pstmt.setString(2, rrMaster.getReturnDate());
			pstmt.setString(3, rrMaster.getProcessedStatusFlag());
			pstmt.setString(4, rrMaster.getConcernRaisedFlag());
			pstmt.setString(5, rrMaster.getPoList());
			pstmt.setString(6, rrMaster.getAsnList());
			pstmt.setString(7, rrMaster.getOrderedDate());
			pstmt.setString(8, rrMaster.getReturnStatus());
			pstmt.setString(9, rrMaster.getTotalReturnItems());
			pstmt.setString(10, rrMaster.getTotalUniqRetItems());
			pstmt.setString(11, rrMaster.getTotalCostReturns());
			pstmt.setString(12, rrMaster.getReturnSite());
			pstmt.setString(13, rrMaster.getTruckNo());
			pstmt.setString(14, rrMaster.getDriverName());
			pstmt.setString(15, rrMaster.getDriverDLNo());
			pstmt.setString(16, rrMaster.getLogisticsPartner());
			pstmt.setString(17, rrMaster.getItemDetails());
			pstmt.setString(18,rrMaster.getConcernMsg());
			int updateStatusCode =pstmt.executeUpdate();
			status = (updateStatusCode==1 ? ("Retailer Return Record inserted in DB Successfully")
					: ("Retailer Return Record Insertion Failed"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn);
		}
		return status;
	}

}
