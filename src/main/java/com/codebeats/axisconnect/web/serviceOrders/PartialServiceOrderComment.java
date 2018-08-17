/**
 * 
 */
package com.codebeats.axisconnect.web.serviceOrders;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author dtorresf
 *
 */
@Entity
@Table(name = "partial_service_order_comment")
public class PartialServiceOrderComment implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String comment;
	private String fromUser;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "partial_service_order_id")
	private PartialServiceOrder partialServiceOrder;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public PartialServiceOrder getPartialServiceOrder() {
		return partialServiceOrder;
	}

	public void setPartialServiceOrder(PartialServiceOrder partialServiceOrder) {
		this.partialServiceOrder = partialServiceOrder;
	}

	@Override
	public String toString() {
		return "PartialServiceOrderComment [id=" + id + ", comment=" + comment + ", fromUser=" + fromUser + "]";
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
		PartialServiceOrderComment other = (PartialServiceOrderComment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
