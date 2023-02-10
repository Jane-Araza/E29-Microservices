package com.lazMalling.product.controller;

import com.lazMalling.product.dto.ResponseDTO;
import com.lazMalling.product.model.Product;
import com.lazMalling.product.repository.ProductRepository;
import com.lazMalling.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/api"})
public class ProductController {
    @Autowired
    private ProductService productService;


    @PostMapping({"/addProducts"})
    public String addProducts(@RequestParam Long userId, @RequestBody Product product) {
        return this.productService.addProducts(userId, product);
    }

    @PutMapping({"/updateProducts"})
    public Product updateProduct(@RequestBody Product product) {
        return this.productService.updateProduct(product);
    }

    @DeleteMapping({"/deleteProducts/{id}"})
    public ResponseEntity deleteProducts(@PathVariable Long id) {
        return productService.deleteById(id);
    }

    @GetMapping({"/getProductById/{id}"})
    public ResponseEntity<ResponseDTO> getUserById(@PathVariable("id") Long productId) {
        ResponseDTO responseDTO = this.productService.getProductsById(productId);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping({"/getAllProducts"})
    @ResponseBody
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }
}


//@RestController
//@RequestMapping("/api")
//public class ProductController {
//
//    @Autowired
//    private final ProductService productService;
//
//    public ProductController (ProductService productService){
//        this.productService=productService;
//    }
//
//    @PostMapping("/products")
//    public @ResponseBody String postProduct(@RequestParam String productName,
//                                            @RequestParam String productDescription,
//                                            @RequestParam long productPrice,
//                                            @RequestParam String productCategory,
//                                            @RequestParam long userId){
//        return productService.postProduct(productName,productDescription,productPrice,productCategory,userId);
//    }
//    @GetMapping("/products")
//    public List<Product> getAllProduct(){
//        return  productService.getAllProduct();
//    }
//    @GetMapping("/products/{productId}")
//    public Optional<Product> getProductById(@PathVariable long productId){
//        return productService.getProductById(productId);
//    }
//    @PutMapping("/product/{productId}")
//    public  Product updateProductById(@PathVariable long productId,Product product){
//        return  productService.updateProductById(productId,product);
//    }
//
//    @DeleteMapping("/product/{productId}")
//    public void deleteUserById(@PathVariable long productId){
//        productService.deleteProductById(productId);
//    }
//
//
//
//
//}
