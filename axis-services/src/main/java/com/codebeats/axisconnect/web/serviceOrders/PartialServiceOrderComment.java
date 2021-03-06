/**
 * 
 */
package com.codebeats.axisconnect.web.serviceOrders;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Column;
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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false, updatable = false)
	private Date created = new Date();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "partial_service_order_id")
	@JsonIgnore
	private PartialServiceOrder partialServiceOrder;

	@Transient
	private String duration;

	public String getDuration() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime commentDate = created.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

		Duration duration = Duration.between(commentDate, now);

		long minutes = Math.abs(duration.toMinutes());
		if (minutes < 5)
			return "just now";
		if (minutes < 60)
			return minutes + " minutes ago";

		long hours = Math.abs(duration.toHours());
		if (hours < 24)
			return hours + " hours ago";

		long days = Math.abs(duration.toDays());
		if (days < 90)
			return days + " days ago";

		long months = days / 30;
		return months + " months ago";

	}

	public void setDuration(String duration) {
		// empty implementation
	}

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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public PartialServiceOrder getPartialServiceOrder() {
		return partialServiceOrder;
	}

	public void setPartialServiceOrder(PartialServiceOrder partialServiceOrder) {
		this.partialServiceOrder = partialServiceOrder;
	}

	@Override
	public String toString() {
		return "PartialServiceOrderComment [id=" + id + ", comment=" + comment + ", fromUser=" + fromUser + ", created="
				+ created + ", partialServiceOrder=" + partialServiceOrder + "]";
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
