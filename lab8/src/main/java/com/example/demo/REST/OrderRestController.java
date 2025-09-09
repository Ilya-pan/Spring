package com.example.demo.REST;

import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderRestController {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OrderRestController(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    // Получить список всех заказов в формате JSON
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> orders = orderRepository.findAll();
        return ResponseEntity.ok(orders);
    }

    // Получить конкретный заказ по ID
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Создать новый заказ (принимает JSON, возвращает JSON)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        // Проверяем, существует ли продукт с указанным именем
        Optional<Product> product = productRepository.findById(order.getId());
        if (product.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // Сохраняем заказ в базу данных
        Order savedOrder = orderRepository.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }

    // Обновить существующий заказ
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
        if (!orderRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        // Устанавливаем ID для обновления
        updatedOrder.setId(id);

        // Сохраняем обновленный заказ
        Order savedOrder = orderRepository.save(updatedOrder);
        return ResponseEntity.ok(savedOrder);
    }

    // Удалить заказ
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        if (!orderRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        // Удаляем заказ
        orderRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}