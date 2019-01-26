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
	private String customer;
	private String customerRef;
	private String vendorRef;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date requested;
	private String shipper;
	private String consignee;
	private String carrier;
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

	public Date getRequested() {
		return this.requested;
	}

	public void setRequested(Date requested) {
		this.requested = requested;
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

	public String getCarrier() {
		return this.carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
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

	

	@Override
	public String toString() {
		return "ServiceOrderRequest [id=" + id + ", customer=" + customer + ", customerRef=" + customerRef
				+ ", vendorRef=" + vendorRef + ", description=" + description + ", requested=" + requested
				+ ", shipper=" + shipper + ", consignee=" + consignee + ", carrier=" + carrier + ", service=" + service
				+ ", status=" + status + ", hu=" + hu + ", weightLbs=" + weightLbs + ", dimensions=" + dimensions
				+ ", classNumber=" + classNumber + ", requiresCustomerApproval=" + requiresCustomerApproval + "]";
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