package com.kpmg.te.retail.supplierportal.returns.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.kpmg.te.retail.supplierportal.returns.constants.ReturnConstants;
import com.kpmg.te.retail.supplierportal.returns.entity.RetailerReturnsMaster;

@Component
public class RetailerReturnsDao {
	
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

	public ArrayList<RetailerReturnsMaster> getRRSummaryList() {
		RetailerReturnsMaster retailerRetMasterObj;
		ArrayList<RetailerReturnsMaster> retailerRetMastersList = new ArrayList<RetailerReturnsMaster>();
		Connection conn = getConnectioDetails();
		String query = "SELECT  * from SUPPLIER_PORTAL.ITEM_LISTING_MASTER ORDER BY CREATED_DATETIME DESC LIMIT 20";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			itemMasterObj = new ItemMaster();
			itemMasterObj.setItemId(rs.getString("item_id"));
			itemMasterObj.setItemName(rs.getString("item_name"));
			itemMasterObj.setSku(rs.getString("sku"));
			itemMasterObj.setPrice(rs.getString("price"));
			itemMasterObj.setStatus(rs.getString("status"));
			itemMasterList.add(itemMasterObj);
		}
		logger.info("[C]ListingDao::[M]getAllItemListingData -> The Item list is: " + itemMasterList.toString());
		return itemMasterList;
		
	}

	public RetailerReturnsMaster getRRSummaryDetails(String retailerReturnID) {
		// TODO Auto-generated method stub
		return null;
	}

}
