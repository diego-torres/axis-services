package com.codebeats.axis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "request_for_tender")
public class RequestForTender implements Serializable {
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
	@Temporal(TemporalType.DATE)
	private Date eta;
	private String pro;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "requestForTender", cascade = CascadeType.ALL)
	private List<CarrierSelection> carrierSelection = new ArrayList<CarrierSelection>();

	public RequestForTender(ServiceOrderRequest sor) {
		this.customer = sor.getCustomer();
		this.customerRef = sor.getCustomerRef();
		this.vendorRef = sor.getVendorRef();
		this.description = sor.getDescription();
		this.requested = sor.getRequested();
		this.shipper = sor.getShipper();
		this.consignee = sor.getConsignee();
		this.carrier = sor.getCarrier();
		this.service = sor.getService();
		this.hu = sor.getHu();
		this.weightLbs = sor.getWeightLbs();
		this.dimensions = sor.getDimensions();
		this.classNumber = sor.getClassNumber();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCustomerRef() {
		return customerRef;
	}

	public void setCustomerRef(String customerRef) {
		this.customerRef = customerRef;
	}

	public String getVendorRef() {
		return vendorRef;
	}

	public void setVendorRef(String vendorRef) {
		this.vendorRef = vendorRef;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRequested() {
		return requested;
	}

	public void setRequested(Date requested) {
		this.requested = requested;
	}

	public String getShipper() {
		return shipper;
	}

	public void setShipper(String shipper) {
		this.shipper = shipper;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHu() {
		return hu;
	}

	public void setHu(String hu) {
		this.hu = hu;
	}

	public int getWeightLbs() {
		return weightLbs;
	}

	public void setWeightLbs(int weightLbs) {
		this.weightLbs = weightLbs;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public int getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}

	public Date getEta() {
		return eta;
	}

	public void setEta(Date eta) {
		this.eta = eta;
	}

	public String getPro() {
		return pro;
	}

	public void setPro(String pro) {
		this.pro = pro;
	}

	public List<CarrierSelection> getCarrierSelection() {
		return carrierSelection;
	}

	public void setCarrierSelection(List<CarrierSelection> carrierSelection) {
		this.carrierSelection = carrierSelection;
	}

	public void addCarrier(CarrierSelection carrier) {
		carrierSelection.add(carrier);
		carrier.setRequestForTender(this);
	}

	public void removeCarrier(CarrierSelection carrier) {
		carrierSelection.remove(carrier);
		carrier.setRequestForTender(null);
	}

	@Override
	public String toString() {
		return "RequestForTender [id=" + id + ", customer=" + customer + ", customerRef=" + customerRef + ", vendorRef="
				+ vendorRef + ", description=" + description + ", requested=" + requested + ", shipper=" + shipper
				+ ", consignee=" + consignee + ", carrier=" + carrier + ", service=" + service + ", status=" + status
				+ ", hu=" + hu + ", weightLbs=" + weightLbs + ", dimensions=" + dimensions + ", classNumber="
				+ classNumber + ", eta=" + eta + ", pro=" + pro + ", carrierSelection=" + carrierSelection + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		RequestForTender other = (RequestForTender) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
