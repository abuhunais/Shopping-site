package com.edison.service;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.DoubleStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edison.entity.Order;
import com.edison.entity.Product;
import com.edison.model.InventoryReport;
import com.edison.model.OrderModel;
import com.edison.model.SalesReport;
import com.edison.repo.OrderRepository;
import com.edison.repo.ProductRepository;

@Service
public class ReportService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderRepository;

	public SalesReport generateSalesReport(String startDate, String endDate) {
		LocalDate startdate = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate enddate = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		List<Order> orders = orderRepository.findByOrderDateBetween(startdate, enddate);
		double totalSales = orders.stream().mapToDouble(order -> order.getTotalPrice()).sum();
		return new SalesReport(startDate, endDate, totalSales);
	}
//}

//
//	public SalesReport generateSalesReport(Date startDate, Date endDate) {
//
//		List<Product> products = productRepository.findAll();
//		double totalSales = 0;
//		for (Product product : products) {
//			totalSales += product.getPrice() * product.getStock();
//		}
//		return new SalesReport(startDate, endDate, totalSales);
//	}
//
	public InventoryReport generateInventoryReport() {
		List<Product> products = productRepository.findAll();
		int totalProducts = products.size();
		int totalStock = 0;
		for (Product product : products) {
			totalStock += product.getStock();
		}
		return new InventoryReport(totalProducts, totalStock, products);
	}

}
