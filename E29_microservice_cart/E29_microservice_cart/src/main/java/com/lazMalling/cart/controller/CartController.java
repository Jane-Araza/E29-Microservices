package com.lazMalling.cart.controller;


import com.lazMalling.cart.model.Cart;
import com.lazMalling.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CartController {


    @Autowired
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/cart")
    public @ResponseBody String postCart(@RequestParam long userId,
                                         @RequestParam long productId,
                                         @RequestParam long quantity){
        return cartService.postCart(userId,productId,quantity);
    }
    @GetMapping("/cart")
    public List<Cart> getAllCart(){
        return cartService.getAllCart();
    }

    @GetMapping("/cart/{cartId}")
    public Optional<Cart> getCartById(@PathVariable long cartId){
        return cartService.getCartById(cartId);
    }
    @PutMapping("/cart/{cartId}")
    public Cart updateCartById(@PathVariable long cartId , @RequestBody Cart cart){
        return cartService.updateCartById(cartId,cart);
    }
    @DeleteMapping("/cart/{cartId}")
    public void deleteCartById(@PathVariable long cartId){
        cartService.deleteCartById(cartId);
    }
}
