package com.nttdata.apirestproducts.controller;

import com.nttdata.apirestproducts.dto.FilterDto;
import com.nttdata.apirestproducts.service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductoService service;

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @PostMapping("/reporting")
    public Mono<ResponseEntity<Map<String, Object>>> getProductsByCustomer(@RequestBody FilterDto filter) {
        return service.reporting(filter)
                .map(r -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(r)
                );
    }
}
