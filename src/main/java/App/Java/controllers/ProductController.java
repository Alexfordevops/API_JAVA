package App.Java.controllers;

import App.Java.dtos.ProductRecordDto;
import App.Java.models.ProductModel;
import App.Java.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<ProductModel> createProductController(@Valid @RequestBody ProductRecordDto productRecordDto){
        return productService.createProductService(productRecordDto);
    }
    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getProductController(){
        return productService.getProductService();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getProductByIdController(@PathVariable(value="id") UUID id){
        return productService.getProductByIdService(id);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProductByIdController(@PathVariable(value="id") UUID id, @RequestBody @Valid ProductRecordDto productRecordDto){
        return productService.updateProductByIdService(id, productRecordDto);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProductByIdController(@PathVariable(value="id") UUID id){
        return productService.deleteProductByIdService(id);

    }
}
