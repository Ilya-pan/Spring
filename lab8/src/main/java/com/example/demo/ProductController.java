package com.example.demo;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    // Подключаем JPA репозиторий для работы с базой данных
    @Autowired
    private ProductRepository productRepository;

    // Подключаем репозиторий для работы с заказами
    @Autowired
    private OrderRepository orderRepository;

    // Отображение страницы с продукцией, данные подгружаются из базы данных
    @GetMapping("/products")
    public String products(Model model) {
        // Получаем все продукты из базы данных
        model.addAttribute("products", productRepository.findAll());
        return "products"; // Отображаем страницу с продуктами
    }

    // Отображение страницы заказа
    @GetMapping("/order")
    public String order(Model model) {
        return "order"; // Возвращаем страницу заказа
    }

    // Обработка данных, введённых пользователем в форму заказа
    @PostMapping("/order")
    public String processOrder(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String product,
            @RequestParam int quantity,
            Model model) {

        // Создаем новый заказ
        Order newOrder = new Order(name, email, product, quantity);

        // Сохраняем заказ в базу данных
        orderRepository.save(newOrder);

        // Добавляем информацию о заказе в модель, чтобы отобразить её на странице подтверждения
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("product", product);
        model.addAttribute("quantity", quantity);

        return "orderConfirmation"; // Возвращаем страницу подтверждения заказа
    }
}