package com.kpmg.te.retail.supplierportal.returns.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kpmg.te.retail.supplierportal.returns.dao.RetailerReturnsDao;
import com.kpmg.te.retail.supplierportal.returns.entity.RetailerReturnsMaster;

@Component
public class RetailerReturnsController {
	
	@Autowired
	RetailerReturnsDao rrDao;

	public ArrayList<RetailerReturnsMaster> getRRSummaryList() throws ClassNotFoundException, SQLException {
		return rrDao.getRRSummaryList();
	}

	public RetailerReturnsMaster getRetailerReturnDetails(String retailerReturnID)
			throws ClassNotFoundException, SQLException {
		return rrDao.getRRSummaryDetails(retailerReturnID);
	}

	public String updateProcessStatus(String itemDetails,String returnId, String concernRaisedFlag) throws ClassNotFoundException, SQLException {
		return rrDao.UpdateProcessStatus(itemDetails,returnId,concernRaisedFlag);
	}

	public String createRetailerReturn(RetailerReturnsMaster rrMaster) throws SQLException {
		return rrDao.createRetailerReturn(rrMaster);
	}
}
