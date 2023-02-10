package com.lazMalling.product.service;


import com.lazMalling.product.dto.ProductDTO;
import com.lazMalling.product.dto.ResponseDTO;
import com.lazMalling.product.dto.UserDTO;
import com.lazMalling.product.model.Product;
import com.lazMalling.product.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private RestTemplate restTemplate;

    public ProductService() {
    }

    public Product updateProduct(Product product) {
        return (Product) this.productRepository.save(product);
    }

    public ResponseEntity deleteById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            this.productRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseDTO getProductsById(Long productId) {
        ResponseDTO responseDTO = new ResponseDTO();
        Optional<Product> product = this.productRepository.findById(productId);
        ProductDTO productDTO = this.mapToUser((Product) product.get());
        ResponseEntity<UserDTO> responseEntity = this.restTemplate.getForEntity("http://localhost:8080/api/getUser/" + ((Product) product.get()).getUserId(), UserDTO.class, new Object[0]);
        UserDTO userDTO = (UserDTO) responseEntity.getBody();
        System.out.println(responseEntity.getStatusCode());
        responseDTO.setProductDto(productDTO);
        responseDTO.setUserDto(userDTO);
        return responseDTO;
    }

    private ProductDTO mapToUser(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());
        productDTO.setImageName(product.getImageName());
        return productDTO;
    }

    public String getUserRole(Long userId) {
        UserDTO user = (UserDTO) this.restTemplate.getForObject("http://localhost:8080/api/getUser/" + userId, UserDTO.class, new Object[0]);
        return user == null ? null : user.getRole();
    }

    public String addProducts(Long userId, Product product) {
        if (this.getUserRole(userId) == null) {
            return HttpStatus.NOT_FOUND.toString();
        } else if (this.getUserRole(userId).equals("buyer")) {
            return HttpStatus.UNAUTHORIZED.toString();
        } else {
            product.setUserId(userId);
            this.productRepository.save(product);
            return HttpStatus.OK.toString();
        }
    }

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }
}


//import com.lazMalling.product.model.Product;
//import com.lazMalling.product.repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ProductService {
//
//    @Autowired
//    private final ProductRepository productRepository;
//
//    public ProductService(ProductRepository productRepository){
//        this.productRepository=productRepository;
//    }
//    public String postProduct(String productName,String productDescription,long productPrice,String productCategory,long userId){
//        Product product=new Product();
//        product.setProductName(productName);
//        product.setProductDescription(productDescription);
//        product.setProductPrice(productPrice);
//        product.setProductCategory(productCategory);
//        product.setUserId(userId);
//
//        System.out.println(productRepository.save(product));
//        return "saved";
//    }
//    public List<Product> getAllProduct(){
//        return productRepository.findAll();
//    }
//    public Optional<Product> getProductById(long productId){
//        return productRepository.findById(productId);
//    }
//    public Product updateProductById(long productId,Product product){
//        product.setProductId(productId);
//        return productRepository.save(product);
//    }
//    public void deleteProductById(long productId){
//        productRepository.deleteById(productId);
//    }
//}
