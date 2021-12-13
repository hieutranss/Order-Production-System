package com.skillstorm.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pizza")
public class Pizza {
	
	@Id
	@Column(name = "pizza_id")
	private Integer id;
	
	@Column(name = "crust")
	private String crust;
	
	@Column(name = "size")
	private String size;
	
	@Column(name = "order_id")
	private Integer orderId;
	
	@Column(name = "is_completed")
	private boolean isCompleted;
	
	public Pizza() {
		super();
	}

	public Pizza(Integer id, String crust, String size, Integer orderId, boolean isCompleted) {
		super();
		this.id = id;
		this.crust = crust;
		this.size = size;
		this.orderId = orderId;
		this.isCompleted = isCompleted;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCrust() {
		return crust;
	}

	public void setCrust(String crust) {
		this.crust = crust;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	public boolean IsCompleted() {
		return isCompleted;
	}
	
	public void setIsCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	
	
	

}
