package com.vti;

import com.vti.entity.Order;
import com.vti.repository.OrderRepository;

public class Program {
	public static void main(String[] args) {
		OrderRepository repository = new OrderRepository();

		System.out.println("\n\n***********CREATE ORDER***********");

		Order order = new Order();
		order.setOrderId((short) 2);
		order.setProductId((short) 4);
		order.setTitle("Order 4");

		repository.createOrder(order);

	}
}