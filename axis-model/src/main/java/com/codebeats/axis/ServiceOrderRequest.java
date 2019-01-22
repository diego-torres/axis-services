package com.codebeats.axis;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="service_order_request")
public class ServiceOrderRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String customer;
    private String customerRef;
    private String vendorRef;
    private String description;
    private Date requested;
    private String shipper;
    private String consignee;
    private String carrier;
    private String service;
    private String status;
    private String hu;
    private String weightLbs;
    private String dimensions;
    private int classNumber;
    @Transient
    private boolean isValid;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
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

    public String getWeightLbs() {
        return this.weightLbs;
    }

    public void setWeightLbs(String weightLbs) {
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

    public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	

    @Override
	public String toString() {
		return "ServiceOrderRequest [id=" + id + ", customer=" + customer + ", customerRef=" + customerRef
				+ ", vendorRef=" + vendorRef + ", description=" + description + ", requested=" + requested
				+ ", shipper=" + shipper + ", consignee=" + consignee + ", carrier=" + carrier + ", service=" + service
				+ ", status=" + status + ", hu=" + hu + ", weightLbs=" + weightLbs + ", dimensions=" + dimensions
				+ ", classNumber=" + classNumber + ", isValid=" + isValid + "]";
	}

	@Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ServiceOrderRequest)) {
            return false;
        }
        ServiceOrderRequest serviceOrderRequest = (ServiceOrderRequest) o;
        return id == serviceOrderRequest.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

}