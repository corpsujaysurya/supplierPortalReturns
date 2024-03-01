package com.kpmg.te.retail.supplierportal.returns.entity;

public class CustomerReturnsMaster {

	private String returnId;
	private String returnDate;
	private String processedStatusFlag;
	private String concernRaisedFlag;
	private String customerName;
	private String customerMobileNumber;
	private String customerAddr;
	private String awbNo;
	private String tplPartner;
	private String eWayBill;
	private String orderedDate;
	private String returnStatus;
	private String totalUniqRetItems;
	private String totalReturnItems;
	private String totalCostReturns;
	private String returnSite;
	private String customerComments;
	private String itemDetails;

	public String getReturnId() {
		return returnId;
	}

	public void setReturnId(String returnId) {
		this.returnId = returnId;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getProcessedStatusFlag() {
		return processedStatusFlag;
	}

	public void setProcessedStatusFlag(String processedStatusFlag) {
		this.processedStatusFlag = processedStatusFlag;
	}

	public String getConcernRaisedFlag() {
		return concernRaisedFlag;
	}

	public void setConcernRaisedFlag(String concernRaisedFlag) {
		this.concernRaisedFlag = concernRaisedFlag;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerMobileNumber() {
		return customerMobileNumber;
	}

	public void setCustomerMobileNumber(String customerMobileNumber) {
		this.customerMobileNumber = customerMobileNumber;
	}

	public String getCustomerAddr() {
		return customerAddr;
	}

	public void setCustomerAddr(String customerAddr) {
		this.customerAddr = customerAddr;
	}

	public String getAwbNo() {
		return awbNo;
	}

	public void setAwbNo(String awbNo) {
		this.awbNo = awbNo;
	}

	public String getTplPartner() {
		return tplPartner;
	}

	public void setTplPartner(String tplPartner) {
		this.tplPartner = tplPartner;
	}

	public String geteWayBill() {
		return eWayBill;
	}

	public void seteWayBill(String eWayBill) {
		this.eWayBill = eWayBill;
	}

	public String getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(String orderedDate) {
		this.orderedDate = orderedDate;
	}

	public String getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}

	public String getTotalUniqRetItems() {
		return totalUniqRetItems;
	}

	public void setTotalUniqRetItems(String totalUniqRetItems) {
		this.totalUniqRetItems = totalUniqRetItems;
	}

	public String getTotalReturnItems() {
		return totalReturnItems;
	}

	public void setTotalReturnItems(String totalReturnItems) {
		this.totalReturnItems = totalReturnItems;
	}

	public String getTotalCostReturns() {
		return totalCostReturns;
	}

	public void setTotalCostReturns(String totalCostReturns) {
		this.totalCostReturns = totalCostReturns;
	}

	public String getReturnSite() {
		return returnSite;
	}

	public void setReturnSite(String returnSite) {
		this.returnSite = returnSite;
	}

	public String getCustomerComments() {
		return customerComments;
	}

	public void setCustomerComments(String customerComments) {
		this.customerComments = customerComments;
	}

	public String getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(String itemDetails) {
		this.itemDetails = itemDetails;
	}

	@Override
	public String toString() {
		return "CustomerReturnsMaster [returnId=" + returnId + ", returnDate=" + returnDate + ", processedStatusFlag="
				+ processedStatusFlag + ", concernRaisedFlag=" + concernRaisedFlag + ", customerName=" + customerName
				+ ", customerMobileNumber=" + customerMobileNumber + ", customerAddr=" + customerAddr + ", awbNo="
				+ awbNo + ", tplPartner=" + tplPartner + ", eWayBill=" + eWayBill + ", orderedDate=" + orderedDate
				+ ", returnStatus=" + returnStatus + ", totalUniqRetItems=" + totalUniqRetItems + ", totalReturnItems="
				+ totalReturnItems + ", totalCostReturns=" + totalCostReturns + ", returnSite=" + returnSite
				+ ", customerComments=" + customerComments + ", itemDetails=" + itemDetails + "]";
	}

}
