package com.kpmg.te.retail.supplierportal.returns.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kpmg.te.retail.supplierportal.returns.dao.CustomerReturnsDao;
import com.kpmg.te.retail.supplierportal.returns.entity.CustomerReturnsMaster;

@Component
public class CustomerReturnsController {
	
	@Autowired
	CustomerReturnsDao crDao;

	public ArrayList<CustomerReturnsMaster> getCRSummaryList() throws ClassNotFoundException, SQLException {
		return crDao.getcustReturnsList();
	}

	public CustomerReturnsMaster getCRDetails(String returnId) throws ClassNotFoundException, SQLException {
		 return crDao.getcustReturnsDetails(returnId);
	}

	public String updateProcessStatus(String returnId, String raiseConcernFlag, String concernMsg) throws ClassNotFoundException, SQLException {
		return crDao.UpdateProcessStatus(returnId,raiseConcernFlag,concernMsg);
	}

	public String createCustomerReturn(CustomerReturnsMaster crMaster) throws SQLException {
		return crDao.createCustomerReturn(crMaster);
	}

}
