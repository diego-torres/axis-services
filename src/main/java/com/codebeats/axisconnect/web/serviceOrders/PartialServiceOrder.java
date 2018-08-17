/**
 * 
 */
package com.codebeats.axisconnect.web.serviceOrders;

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
import javax.persistence.Transient;

/**
 * @author dtorresf
 *
 */
@Entity
@Table(name = "partial_service_order")
public class PartialServiceOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String customerRef;
	private String vendorRef;
	private Date deliveryDate;
	private String weight;
	private String dimensions;
	private String instructions;
	private String fromStreet;
	private String fromStreet2;
	private String fromCity;
	private String fromState;
	private String fromZip;
	private String fromCountry;
	private String fromLocation;
	private String toStreet;
	private String toStreet2;
	private String toCity;
	private String toState;
	private String toZip;
	private String toCountry;
	private String toLocation;
	@Transient
	private boolean startProcessInstance = false;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "partialServiceOrder", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<PartialServiceOrderComment> comments = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getFromStreet() {
		return fromStreet;
	}

	public void setFromStreet(String fromStreet) {
		this.fromStreet = fromStreet;
	}

	public String getFromStreet2() {
		return fromStreet2;
	}

	public void setFromStreet2(String fromStreet2) {
		this.fromStreet2 = fromStreet2;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getFromState() {
		return fromState;
	}

	public void setFromState(String fromState) {
		this.fromState = fromState;
	}

	public String getFromZip() {
		return fromZip;
	}

	public void setFromZip(String fromZip) {
		this.fromZip = fromZip;
	}

	public String getFromCountry() {
		return fromCountry;
	}

	public void setFromCountry(String fromCountry) {
		this.fromCountry = fromCountry;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToStreet() {
		return toStreet;
	}

	public void setToStreet(String toStreet) {
		this.toStreet = toStreet;
	}

	public String getToStreet2() {
		return toStreet2;
	}

	public void setToStreet2(String toStreet2) {
		this.toStreet2 = toStreet2;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public String getToState() {
		return toState;
	}

	public void setToState(String toState) {
		this.toState = toState;
	}

	public String getToZip() {
		return toZip;
	}

	public void setToZip(String toZip) {
		this.toZip = toZip;
	}

	public String getToCountry() {
		return toCountry;
	}

	public void setToCountry(String toCountry) {
		this.toCountry = toCountry;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public List<PartialServiceOrderComment> getComments() {
		return comments;
	}

	public void setComments(List<PartialServiceOrderComment> comments) {
		this.comments = comments;
	}

	public void addComment(PartialServiceOrderComment comment) {
		comments.add(comment);
		comment.setPartialServiceOrder(this);
	}

	public void removeComment(PartialServiceOrderComment comment) {
		comments.remove(comment);
		comment.setPartialServiceOrder(null);
	}

	public boolean isStartProcessInstance() {
		return startProcessInstance;
	}

	public void setStartProcessInstance(boolean startProcessInstance) {
		this.startProcessInstance = startProcessInstance;
	}

	@Override
	public String toString() {
		return "PartialServiceOrder [id=" + id + ", customerRef=" + customerRef + ", vendorRef=" + vendorRef
				+ ", deliveryDate=" + deliveryDate + ", weight=" + weight + ", dimensions=" + dimensions
				+ ", instructions=" + instructions + ", fromStreet=" + fromStreet + ", fromStreet2=" + fromStreet2
				+ ", fromCity=" + fromCity + ", fromState=" + fromState + ", fromZip=" + fromZip + ", fromCountry="
				+ fromCountry + ", fromLocation=" + fromLocation + ", toStreet=" + toStreet + ", toStreet2=" + toStreet2
				+ ", toCity=" + toCity + ", toState=" + toState + ", toZip=" + toZip + ", toCountry=" + toCountry
				+ ", toLocation=" + toLocation + ", comments=" + comments + "]";
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
		PartialServiceOrder other = (PartialServiceOrder) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
