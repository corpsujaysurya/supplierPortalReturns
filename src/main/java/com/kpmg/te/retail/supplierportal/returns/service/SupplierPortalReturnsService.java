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

import com.kpmg.te.retail.supplierportal.returns.controller.CustomerReturnsController;
import com.kpmg.te.retail.supplierportal.returns.controller.RetailerReturnsController;
import com.kpmg.te.retail.supplierportal.returns.entity.RetailerReturnsMaster;
import com.kpmg.te.retail.supplierportal.returns.manager.CustomerReturnsManager;
import com.kpmg.te.retail.supplierportal.returns.manager.RetailerReturnsManager;

@RestController
@RequestMapping("/api/returns/service/")
public class SupplierPortalReturnsService {
	
	@Autowired
	RetailerReturnsController retailerReturnsController;
	
	@Autowired
	CustomerReturnsController customerReturnsController;
	
	@Autowired
	RetailerReturnsManager retailerReturnsManager;
	
	@Autowired
	CustomerReturnsManager customerReturnsManager;
	
	
	private static final Logger logger = Logger.getLogger(SupplierPortalReturnsService.class.getName());
	
	/************************************************************************************************************************************************************************** */
	/*													Retailer Returns -  View Returns listing & Returns Summary                                                             */
	/**************************************************************************************************************************************************************************/
	@RequestMapping(path = "/rr/getRetailerReturnsListing", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
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
	@RequestMapping(path = "/rr/processRetailerReturns", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String crProcessStatus(@RequestParam String returnId) throws ClassNotFoundException, SQLException {
		return supplierPortalcrcontroller.updateProcessStatus(returnId);
	}
	
	/************************************************************************************************************************************************************************** */
	/*													Customer Returns -  View Returns listing & Returns Summary                                                             */
	/**************************************************************************************************************************************************************************/
	@RequestMapping(path = "/cr/getRetailerReturnsListing", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<CustomerReturnSummary> getAllCRListing(@RequestParam String summary_return_id) throws ClassNotFoundException, SQLException {
		ArrayList<CustomerReturnSummary> crList = new ArrayList<CustomerReturnSummary>();
		crList = supplierPortalcrcontroller.getCRSummaryList(summary_return_id);
		logger.info("The Site List to display is: " + crList.toString());
		return crList;
	}

	@RequestMapping(path = "/cr/getRetailerReturnsDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<CustomerReturnSummary> getAllCRListing() throws ClassNotFoundException, SQLException {
		ArrayList<CustomerReturnSummary> crList = new ArrayList<CustomerReturnSummary>();
		crList = supplierPortalcrcontroller.getCRListing();
		logger.info("The Site List to display is: " + crList.toString());
		return crList;
	}
	
	
	/************************************************************************************************************************************************************************** */
	/*													Customer Returns -  View Returns listing & Returns Summary                                                             */
	/**************************************************************************************************************************************************************************/
	@RequestMapping(path = "/cr/processRetailerReturns", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String crProcessStatus(@RequestParam String returnId) throws ClassNotFoundException, SQLException {
		return supplierPortalcrcontroller.updateProcessStatus(returnId);
	}
	


	
}
