package org.example.main.product.controllers;

import org.example.main.product.ProductService.ProductService;
import org.example.main.product.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public String getAllProducts(Model model) {
        var products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "products.html";
    }

    @RequestMapping(path = "/products", method = RequestMethod.POST)
    public String addProduct(@RequestParam String name, @RequestParam double price, Model model)
    {
        Product product = new Product(name, price);
        productService.addProduct(product);

        var products1 = productService.findAllProducts();
        model.addAttribute("products", products1);
        return "products.html";
    }






}
