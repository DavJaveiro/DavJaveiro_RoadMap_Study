package org.example.main.product.controllers;

import org.example.main.product.ProductService.ProductService;
import org.example.main.product.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        var products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "product.html";
    }

    @PostMapping("/products")
    public String addProduct(@RequestParam String name, @RequestParam double price, Model model)
    {
        Product p = new Product(name, price);
        productService.addProduct(p);

        var products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "product.html";
    }

  /*  Directly using the model as a parameter of the controller's action
  @PostMapping("/products")
    public String addProduct2(Product p, Model model) {
        productService.addProduct(p);

        var products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "products.html";
    }*/








}
