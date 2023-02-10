package com.lazMalling.cart.service;

import com.lazMalling.cart.model.Cart;
import com.lazMalling.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {


    @Autowired
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public String postCart(long userId,long productId,long quantity){
        Cart cart=new Cart();
        cart.setUserId(userId);
        cart.setProductId(productId);
        cart.setQuantity(quantity);
        System.out.println(cartRepository.save(cart));
        return "saved";
    }

    public List<Cart>getAllCart(){
        return cartRepository.findAll();
    }

    public Optional<Cart> getCartById(long cartId){
        return cartRepository.findById(cartId);
    }

    public Cart updateCartById(long cartId,Cart cart){
        cart.setCartId(cartId);
        return cartRepository.save(cart);
    }
    public void deleteCartById(long cartId){
        cartRepository.deleteById(cartId);
    }






}
