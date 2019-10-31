package com.novomatic.keycloak.examples.rest.controller;

import com.novomatic.keycloak.examples.rest.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

import static com.novomatic.keycloak.examples.rest.Utils.getAccessTokenPayload;

@RestController
public class ProductController {

    private static Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/api/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> handleCustomersRequest(Principal principal) {
        log.info("Accessing products with the following access token:\n{}", getAccessTokenPayload(principal));
        return productService.getProducts();
    }

    @GetMapping(value = "/api/nosecure", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> noSecure(Principal principal) {
        return productService.getProducts();
    }
}
