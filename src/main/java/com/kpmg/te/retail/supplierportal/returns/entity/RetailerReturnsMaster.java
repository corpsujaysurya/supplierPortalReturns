package com.kpmg.te.retail.supplierportal.returns.entity;

public class RetailerReturnsMaster {

	private String returnId;
	private String returnDate;
	private String processedStatusFlag;
	private String concernRaisedFlag;

	private String orderedDate;
	private String returnStatus;
	private String poList;
	private String asnList;

	private Integer totalUniqRetItems;
	private Integer totalReturnItems;
	private Integer totalCostReturns;

	private String returnSite;
	private String truckNo;
	private String driverName;
	private String driverDLNo;
	private String logisticsPartner;

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

	public String getPoList() {
		return poList;
	}

	public void setPoList(String poList) {
		this.poList = poList;
	}

	public String getAsnList() {
		return asnList;
	}

	public void setAsnList(String asnList) {
		this.asnList = asnList;
	}

	public Integer getTotalUniqRetItems() {
		return totalUniqRetItems;
	}

	public void setTotalUniqRetItems(Integer totalUniqRetItems) {
		this.totalUniqRetItems = totalUniqRetItems;
	}

	public Integer getTotalReturnItems() {
		return totalReturnItems;
	}

	public void setTotalReturnItems(Integer totalReturnItems) {
		this.totalReturnItems = totalReturnItems;
	}

	public Integer getTotalCostReturns() {
		return totalCostReturns;
	}

	public void setTotalCostReturns(Integer totalCostReturns) {
		this.totalCostReturns = totalCostReturns;
	}

	public String getReturnSite() {
		return returnSite;
	}

	public void setReturnSite(String returnSite) {
		this.returnSite = returnSite;
	}

	public String getTruckNo() {
		return truckNo;
	}

	public void setTruckNo(String truckNo) {
		this.truckNo = truckNo;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverDLNo() {
		return driverDLNo;
	}

	public void setDriverDLNo(String driverDLNo) {
		this.driverDLNo = driverDLNo;
	}

	public String getLogisticsPartner() {
		return logisticsPartner;
	}

	public void setLogisticsPartner(String logisticsPartner) {
		this.logisticsPartner = logisticsPartner;
	}

	public String getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(String itemDetails) {
		this.itemDetails = itemDetails;
	}

	@Override
	public String toString() {
		return "RetailerReturnsMaster [returnId=" + returnId + ", returnDate=" + returnDate + ", processedStatusFlag="
				+ processedStatusFlag + ", concernRaisedFlag=" + concernRaisedFlag + ", orderedDate=" + orderedDate
				+ ", returnStatus=" + returnStatus + ", poList=" + poList + ", asnList=" + asnList
				+ ", totalUniqRetItems=" + totalUniqRetItems + ", totalReturnItems=" + totalReturnItems
				+ ", totalCostReturns=" + totalCostReturns + ", returnSite=" + returnSite + ", truckNo=" + truckNo
				+ ", driverName=" + driverName + ", driverDLNo=" + driverDLNo + ", logisticsPartner=" + logisticsPartner
				+ ", itemDetails=" + itemDetails + "]";
	}

}
