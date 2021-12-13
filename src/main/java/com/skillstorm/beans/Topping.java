package com.skillstorm.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "topping")
public class Topping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer toppingId;
	
	@Column(name = "pizza_id")
	private Integer pizzaId;
	
	@Column(name = "description")
	private String description;

	public Topping() {
		super();
	}
	
	public Topping(Integer toppingId, Integer pizzaId, String description) {
		super();
		this.toppingId = toppingId;
		this.pizzaId = pizzaId;
		this.description = description;
	}

	public Topping( Integer pizzaId, String description) {
		super();
		this.pizzaId = pizzaId;
		this.description = description;
	}

	public Integer getToppingId() {
		return toppingId;
	}

	public void setToppingId(Integer toppingId) {
		this.toppingId = toppingId;
	}

	public Integer getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(Integer pizzaId) {
		this.pizzaId = pizzaId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
