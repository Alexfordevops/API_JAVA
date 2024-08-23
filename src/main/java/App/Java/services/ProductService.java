package App.Java.services;

import App.Java.dtos.ProductRecordDto;
import App.Java.models.ProductModel;
import App.Java.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ResponseEntity<ProductModel> createProductService(ProductRecordDto productRecordDto){
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        productRepository.saveAndFlush(productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productModel);
    }

    public ResponseEntity<List<ProductModel>> getProductService(){
        List<ProductModel> dataList = productRepository.findAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(dataList);
    }

    public ResponseEntity<Object> getProductByIdService(UUID id){
        Optional<ProductModel> product0 = productRepository.findById(id);
        if(product0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(product0.get());
        }

    public ResponseEntity<Object> updateProductByIdService(UUID id, ProductRecordDto productRecordDto ){
        Optional<ProductModel> productO = productRepository.findById(id);
        if(productO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        var productModel = productO.get();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }

    public ResponseEntity<Object> deleteProductByIdService(UUID id){
        Optional<ProductModel> productO = productRepository.findById(id);
        if(productO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        productRepository.delete(productO.get());
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfuly");
    }

}
