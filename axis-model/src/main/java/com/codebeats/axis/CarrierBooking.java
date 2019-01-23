package com.codebeats.axis;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "carrier_booking")
public class CarrierBooking implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String bookingNumbers;
	private String carrier;
	private String bolUrl;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_order_id")
	@JsonIgnore
	private ServiceOrder serviceOrder;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookingNumbers() {
		return bookingNumbers;
	}

	public void setBookingNumbers(String bookingNumbers) {
		this.bookingNumbers = bookingNumbers;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getBolUrl() {
		return bolUrl;
	}

	public void setBolUrl(String bolUrl) {
		this.bolUrl = bolUrl;
	}

	public ServiceOrder getServiceOrder() {
		return serviceOrder;
	}

	public void setServiceOrder(ServiceOrder serviceOrder) {
		this.serviceOrder = serviceOrder;
	}

	@Override
	public String toString() {
		return "CarrierBooking [id=" + id + ", bookingNumbers=" + bookingNumbers + ", carrier=" + carrier + "]";
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
		CarrierBooking other = (CarrierBooking) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
