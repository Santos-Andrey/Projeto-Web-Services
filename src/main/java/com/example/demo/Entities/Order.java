package com.example.demo.Entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.Entities.enums.OrderStatus;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private Instant moment;
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment paymnet;
	
	@ManyToOne
	@JoinColumn(name = "Client_Id")
	private User client;
	
	//Sintaxe de uma Coleção 
	@OneToMany(mappedBy = "id.order")
	private Set <OrderItem> itemns = new HashSet<>();
	
	public Order() {
	}

	private Integer orderStatus;
	
	public Order(long id, Instant moment, OrderStatus orderStatus, User client) {
		Id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.client = client;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null) {
		this.orderStatus = orderStatus.getCode();
		}
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Set<OrderItem> getItemns(){
		return itemns;
	}
	
	public Payment getPaymnet() {
		return paymnet;
	}

	public void setPaymnet(Payment paymnet) {
		this.paymnet = paymnet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (Id ^ (Id >>> 32));
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
		Order other = (Order) obj;
		if (Id != other.Id)
			return false;
		return true;
	}
	
	
	
}
