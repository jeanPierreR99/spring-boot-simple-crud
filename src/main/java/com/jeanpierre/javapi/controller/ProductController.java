package com.jeanpierre.javapi.controller;

import com.jeanpierre.javapi.model.ApiResponse;
import com.jeanpierre.javapi.model.Product;
import com.jeanpierre.javapi.service.ProductService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    ProductService ps = new ProductService();

    @GetMapping()
    public ResponseEntity<ApiResponse> products() {
        try {
            List<Product> productList = ps.getAllProducts();
            ApiResponse response = new ApiResponse(true, "ok", productList);
            System.out.println("succes---------");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println("error---------");
            ApiResponse response = new ApiResponse(false, "Error al obtener los productos: " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @SuppressWarnings("rawtypes")
    @GetMapping("/find/{id}")
    public ResponseEntity ProductById(@PathVariable int id) {
        try {
            List<Product> productList = ps.getProductsById(id);
            ApiResponse response = new ApiResponse(true, "ok", productList);
            System.out.println("succes---------");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println("error---------");
            ApiResponse response = new ApiResponse(false, "Error al obtener los productos: " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @SuppressWarnings("rawtypes")
    @GetMapping("/find")
    public ResponseEntity ProductByIdRequest(@RequestParam int id) {
        try {
            List<Product> productList = ps.getProductsById(id);
            ApiResponse response = new ApiResponse(true, "ok", productList);
            System.out.println("succes---------");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println("error---------");
            ApiResponse response = new ApiResponse(false, "Error al obtener los productos: " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @SuppressWarnings("rawtypes")
    @PostMapping()
    public ResponseEntity guardarDatos(@RequestBody Product data) {
        try {
            ps.addProducts(data.getName(), data.getDescription(), data.getPrice(), data.getDateAt());
            ApiResponse response = new ApiResponse(true, "ok", data);
            System.out.println("succes---------");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println("error---------");
            ApiResponse response = new ApiResponse(false, "Error al obtener los productos: " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delProduct(@PathVariable int id) {
        try {
            ps.deleteById(id);
            ApiResponse response = new ApiResponse(true, "ok", null);
            System.out.println("succes---------");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println("error---------");
            ApiResponse response = new ApiResponse(false, "Error al obtener los productos: " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
