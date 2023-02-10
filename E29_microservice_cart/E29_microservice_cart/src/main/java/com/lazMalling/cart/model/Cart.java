package com.lazMalling.cart.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "product_id")
    private long productId;

    @Column(name = "product_quantity")
    private long quantity;

}
