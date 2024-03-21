package com.jeanpierre.javapi.controller;

import com.jeanpierre.javapi.model.ApiResponse;
import com.jeanpierre.javapi.model.Employe;
import com.jeanpierre.javapi.service.EmployeService;
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
@RequestMapping("/api/v1/employes")
public class EmployeController {

    EmployeService em = new EmployeService();

    @GetMapping()
    public ResponseEntity<ApiResponse> employes() {
        try {
            List<Employe> employeList = em.getAllEmployes();
            ApiResponse response = new ApiResponse(true, "ok", employeList);
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
    public ResponseEntity EmployeById(@PathVariable int id) {
        try {
            List<Employe> employeList = em.getEmployeById(id);
            ApiResponse response = new ApiResponse(true, "ok", employeList);
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
    public ResponseEntity EmployeByIdRequest(@RequestParam int id) {
        try {
            List<Employe> employeList = em.getEmployeById(id);
            ApiResponse response = new ApiResponse(true, "ok", employeList);
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
    public ResponseEntity saveEmploye(@RequestBody Employe data) {
        try {
            em.addEmploye(data.getName(), data.getLastname(), data.getRole(), data.getAge(), data.getSalary());
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
    public ResponseEntity delEmploye(@PathVariable int id) {
        try {
            em.deleteById(id);
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
