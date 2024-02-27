package com.kpmg.te.retail.supplierportal.returns.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kpmg.te.retail.supplierportal.returns.dao.RetailerReturnsDao;
import com.kpmg.te.retail.supplierportal.returns.entity.RetailerReturnsMaster;

@Component
public class RetailerReturnsController {
	
	@Autowired
	RetailerReturnsDao rrDao;

	public ArrayList<RetailerReturnsMaster> getRRSummaryList() {
		return rrDao.getRRSummaryList();
	}

	public RetailerReturnsMaster getRetailerReturnDetails(String retailerReturnID) {
		 return rrDao.getRRSummaryDetails(retailerReturnID);
	}

}
