package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.vti.entity.Order.OrderPK;

@Entity
@Table(name = "`Order`")
@IdClass(OrderPK.class)
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "order_id")
	@Id
	private short orderId;

	@Column(name = "product_id")
	@Id
	private short productId;

	@Column(name = "title", length = 50, nullable = false, unique = true)
	private String title;

	public Order() {
	}

	public short getOrderId() {
		return orderId;
	}

	public void setOrderId(short orderId) {
		this.orderId = orderId;
	}

	public short getProductId() {
		return productId;
	}

	public void setProductId(short productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productId=" + productId + ", title=" + title + "]";
	}

	@Embeddable
	public static class OrderPK implements Serializable {

		private static final long serialVersionUID = 1L;

		@Column(name = "order_id")
		private short orderId;

		@Column(name = "product_id")
		private short productId;

		public OrderPK() {
		}

		public short getOrderId() {
			return orderId;
		}

		public void setOrderId(short orderId) {
			this.orderId = orderId;
		}

		public short getProductId() {
			return productId;
		}

		public void setProductId(short productId) {
			this.productId = productId;
		}
	}

}
