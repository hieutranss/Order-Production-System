package com.skillstorm.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "orders")
public class Order {
	
	
	@Id
	@Column(name = "order_id")
	private Integer orderId;
	
	@Column(name = "customer_id")
	private String customerId;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "stage")
	private String stage;
	
	@Column(name = "created")
	private String created;
	
	public Order() {
		super();
	}
	

	public Order(Integer orderId, String customerId, String type, String stage, String created) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.type = type;
		this.stage = stage;
		this.created = created;
	}


	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", type=" + type + ", stage=" + stage
				+ ", created=" + created +  "]";
	}



	
	
	
	
}