package com.kpmg.te.retail.supplierportal.returns.service;

import java.sql.SQLException;


import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kpmg.te.retail.supplierportal.returns.controller.RetailerReturnsController;
import com.kpmg.te.retail.supplierportal.returns.entity.RetailerReturnsMaster;

@RestController
@RequestMapping("/api/returns/service/rr")
public class RetailerReturnsService {
	
	@Autowired
	RetailerReturnsController retailerReturnsController;
	
	private static final Logger logger = Logger.getLogger(RetailerReturnsService.class.getName());
	
	/************************************************************************************************************************************************************************** */
	/*													Retailer Returns -  View Returns listing & Returns Summary                                                             */
	/**************************************************************************************************************************************************************************/
	@RequestMapping(path = "/getRetailerReturnsListing", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<RetailerReturnsMaster> getAllRRListing() throws ClassNotFoundException, SQLException {
		ArrayList<RetailerReturnsMaster> rrMasterList = new ArrayList<RetailerReturnsMaster>();
		rrMasterList = retailerReturnsController.getRRSummaryList();
		logger.info("The Retailer Return Summary List to display is: " + rrMasterList.toString());
		return rrMasterList;
	}

	@RequestMapping(path = "/rr/getRetailerReturnsDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public RetailerReturnsMaster getRRDetails(@RequestParam String retailerReturnID) throws ClassNotFoundException, SQLException {
		RetailerReturnsMaster rrMaster = new RetailerReturnsMaster();
		rrMaster = retailerReturnsController.getRetailerReturnDetails(retailerReturnID);
		logger.info("The Site List to display is: " + rrMaster.toString());
		return rrMaster;
	}
	
	/************************************************************************************************************************************************************************** */
	/*												      	Retailer Returns - Process Return                                                                                  */
	/**************************************************************************************************************************************************************************/
	@RequestMapping(path = "/processRetailerReturns", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String processReturn(@RequestParam String itemDetails,@RequestParam String returnId,@RequestParam String raiseConcernFlag) throws ClassNotFoundException, SQLException {
		return retailerReturnsController.updateProcessStatus(itemDetails,returnId,raiseConcernFlag);
	}
	
	@RequestMapping(path = "/createRetailerReturns", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createRetailerReturn(@RequestBody RetailerReturnsMaster rrMaster) throws ClassNotFoundException, SQLException {
		return retailerReturnsController.createRetailerReturn(rrMaster);
	}
	
	
	
	


	
}
