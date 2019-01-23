package com.codebeats.axis;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "carrier_quote")
public class CarrierQuote implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String reference;
	private String carrier;
	private String description;
	private String url;
	private BigDecimal totalPrice = new BigDecimal(0);
	@Temporal(TemporalType.DATE)
	private Date eta;
	private Boolean selected;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "axis_quote_id")
	@JsonIgnore
	private AxisQuote axisQuote;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getEta() {
		return eta;
	}

	public void setEta(Date eta) {
		this.eta = eta;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public AxisQuote getAxisQuote() {
		return axisQuote;
	}

	public void setAxisQuote(AxisQuote axisQuote) {
		this.axisQuote = axisQuote;
	}

	@Override
	public String toString() {
		return "CarrierQuote [id=" + id + ", reference=" + reference + ", carrier=" + carrier + ", description="
				+ description + ", url=" + url + ", totalPrice=" + totalPrice + ", eta=" + eta + ", selected="
				+ selected + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carrier == null) ? 0 : carrier.hashCode());
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
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
		CarrierQuote other = (CarrierQuote) obj;
		if (carrier == null) {
			if (other.carrier != null)
				return false;
		} else if (!carrier.equals(other.carrier))
			return false;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		return true;
	}

	

}
