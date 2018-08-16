/**
 * 
 */
package com.codebeats.axisconnect.web.serviceOrders;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dtorresf
 *
 */
public class ServiceOrder implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean hot;
	private String custRef;
	private String vendorRef;
	private Date requested;
	private Date shipping;
	private Date eta;
	private Date delivery;
	private String shipper;
	private String consignee;
	private String comments;
	private String carrier;
	private String service;
	private String status;
	private Integer hu;
	private String wt;
	private String quoteId;
	private String pickupId;
	private String proId;
	private Integer duration;

	
	public ServiceOrder(Integer id, Boolean hot, String custRef, String vendorRef, Date requested, Date shipping,
			Date eta, Date delivery, String shipper, String consignee, String comments, String carrier, String service,
			String status, Integer hu, String wt, String quoteId, String pickupId, String proId, Integer duration) {
		super();
		this.id = id;
		this.hot = hot;
		this.custRef = custRef;
		this.vendorRef = vendorRef;
		this.requested = requested;
		this.shipping = shipping;
		this.eta = eta;
		this.delivery = delivery;
		this.shipper = shipper;
		this.consignee = consignee;
		this.comments = comments;
		this.carrier = carrier;
		this.service = service;
		this.status = status;
		this.hu = hu;
		this.wt = wt;
		this.quoteId = quoteId;
		this.pickupId = pickupId;
		this.proId = proId;
		this.duration = duration;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getHot() {
		return hot;
	}

	public void setHot(Boolean hot) {
		this.hot = hot;
	}

	public String getCustRef() {
		return custRef;
	}

	public void setCustRef(String custRef) {
		this.custRef = custRef;
	}

	public String getVendorRef() {
		return vendorRef;
	}

	public void setVendorRef(String vendorRef) {
		this.vendorRef = vendorRef;
	}

	public Date getRequested() {
		return requested;
	}

	public void setRequested(Date requested) {
		this.requested = requested;
	}

	public Date getShipping() {
		return shipping;
	}

	public void setShipping(Date shipping) {
		this.shipping = shipping;
	}

	public Date getEta() {
		return eta;
	}

	public void setEta(Date eta) {
		this.eta = eta;
	}

	public Date getDelivery() {
		return delivery;
	}

	public void setDelivery(Date delivery) {
		this.delivery = delivery;
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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public Integer getHu() {
		return hu;
	}

	public void setHu(Integer hu) {
		this.hu = hu;
	}

	public String getWt() {
		return wt;
	}

	public void setWt(String wt) {
		this.wt = wt;
	}

	public String getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(String quoteId) {
		this.quoteId = quoteId;
	}

	public String getPickupId() {
		return pickupId;
	}

	public void setPickupId(String pickupId) {
		this.pickupId = pickupId;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
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
		ServiceOrder other = (ServiceOrder) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
