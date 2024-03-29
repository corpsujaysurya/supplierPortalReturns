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
import com.kpmg.te.retail.supplierportal.returns.entity.CustomerReturnsMaster;

@RestController
@RequestMapping("/api/returns/service/cr")
public class CustomerReturnsService {
	
	@Autowired
	CustomerReturnsController customerReturnsController;
	
	private static final Logger logger = Logger.getLogger(CustomerReturnsService.class.getName());
	
	/************************************************************************************************************************************************************************** */
	/*													Customer Returns -  View Returns listing & Returns Summary                                                             */
	/**************************************************************************************************************************************************************************/
	@RequestMapping(path = "/getCustomerReturnsList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<CustomerReturnsMaster> getAllCRListing() throws ClassNotFoundException, SQLException {
		ArrayList<CustomerReturnsMaster> crList = new ArrayList<CustomerReturnsMaster>();
		crList = customerReturnsController.getCRSummaryList();
		logger.info("The Site List to display is: " + crList.toString());
		return crList;
	}

	@RequestMapping(path = "/getCustomerReturnDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerReturnsMaster getCRDetails(@RequestParam String returnId) throws ClassNotFoundException, SQLException {
		CustomerReturnsMaster crDetails = customerReturnsController.getCRDetails(returnId);
		logger.info("The Site List to display is: " + crDetails.toString());
		return crDetails;
	}
	
	
	/************************************************************************************************************************************************************************** */
	/*													Customer Returns -  View Returns listing & Returns Summary                                                             */
	/**************************************************************************************************************************************************************************/
	@RequestMapping(path = "/processCustomerReturns", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String crProcessStatus(@RequestParam String returnId,@RequestParam String raiseConcernFlag,@RequestParam String concernMsg,@RequestParam String itemDetails) throws ClassNotFoundException, SQLException {
		return customerReturnsController.updateProcessStatus(returnId,raiseConcernFlag,concernMsg,itemDetails);
	}
	
	@RequestMapping(path = "/createCustomerReturns", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createCustomerReturn(@RequestBody CustomerReturnsMaster crMaster) throws ClassNotFoundException, SQLException {
		return customerReturnsController.createCustomerReturn(crMaster);
	}
	
	

}
