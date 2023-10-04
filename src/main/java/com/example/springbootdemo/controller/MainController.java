package com.example.springbootdemo.controller;

import com.example.springbootdemo.Product;
import com.example.springbootdemo.exceptions.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {


    Map<Long, Product> available = new HashMap<>();


    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        if(available.containsKey(id)) {
            return ResponseEntity.ok(available.get(id));
        } else {
         //   return ResponseEntity.notFound().build();
           // throw new ItemNotFoundException("Item with id : " + id + " was not found");
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "Item with id : " + id + " was not found");
        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@RequestBody @Valid Product product) {
            available.put(Math.incrementExact(1L), product);
            return ResponseEntity.ok("Saved successfully");
    }

    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNoSuchElementFoundException(ItemNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

}
