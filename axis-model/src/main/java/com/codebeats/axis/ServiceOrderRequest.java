package com.codebeats.axis;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "service_order_request")
public class ServiceOrderRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer processInstanceId;
	private String customer;
	private String customerRef;
	private String vendorRef;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date requestedShippingDate;
	private String shipper;
	private String consignee;
	private String service;
	private String status;
	private String hu;
	private int weightLbs = 0;
	private String dimensions;
	private int classNumber;
	private Boolean requiresCustomerApproval;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomer() {
		return this.customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCustomerRef() {
		return this.customerRef;
	}

	public void setCustomerRef(String customerRef) {
		this.customerRef = customerRef;
	}

	public String getVendorRef() {
		return this.vendorRef;
	}

	public void setVendorRef(String vendorRef) {
		this.vendorRef = vendorRef;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShipper() {
		return this.shipper;
	}

	public void setShipper(String shipper) {
		this.shipper = shipper;
	}

	public String getConsignee() {
		return this.consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getService() {
		return this.service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHu() {
		return this.hu;
	}

	public void setHu(String hu) {
		this.hu = hu;
	}

	public int getWeightLbs() {
		return this.weightLbs;
	}

	public void setWeightLbs(int weightLbs) {
		this.weightLbs = weightLbs;
	}

	public String getDimensions() {
		return this.dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public int getClassNumber() {
		return this.classNumber;
	}

	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}

	public Boolean getRequiresCustomerApproval() {
		return requiresCustomerApproval;
	}

	public void setRequiresCustomerApproval(Boolean requiresCustomerApproval) {
		this.requiresCustomerApproval = requiresCustomerApproval;
	}
	
	public Integer getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(Integer processInstanceId) {
		this.processInstanceId = processInstanceId;
	}


	public Date getRequestedShippingDate() {
		return requestedShippingDate;
	}

	public void setRequestedShippingDate(Date requestedShippingDate) {
		this.requestedShippingDate = requestedShippingDate;
	}

	

	@Override
	public String toString() {
		return "{\"" + (id != null ? "id\":\"" + id + "\", " : "")
				+ (processInstanceId != null ? "processInstanceId\":\"" + processInstanceId + "\", " : "")
				+ (customer != null ? "customer\":\"" + customer + "\", " : "")
				+ (customerRef != null ? "customerRef\":\"" + customerRef + "\", " : "")
				+ (vendorRef != null ? "vendorRef\":\"" + vendorRef + "\", " : "")
				+ (description != null ? "description\":\"" + description + "\", " : "")
				+ (requestedShippingDate != null ? "requestedShippingDate\":\"" + requestedShippingDate + "\", " : "")
				+ (shipper != null ? "shipper\":\"" + shipper + "\", " : "")
				+ (consignee != null ? "consignee\":\"" + consignee + "\", " : "")
				+ (service != null ? "service\":\"" + service + "\", " : "")
				+ (status != null ? "status\":\"" + status + "\", " : "") + (hu != null ? "hu\":\"" + hu + "\", " : "")
				+ "weightLbs\":\"" + weightLbs + "\", "
				+ (dimensions != null ? "dimensions\":\"" + dimensions + "\", " : "") + "classNumber\":\"" + classNumber
				+ "\", "
				+ (requiresCustomerApproval != null ? "requiresCustomerApproval\":\"" + requiresCustomerApproval : "")
				+ "}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceOrderRequest other = (ServiceOrderRequest) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}