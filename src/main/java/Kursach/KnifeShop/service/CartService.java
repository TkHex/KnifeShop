package Kursach.KnifeShop.service;

import Kursach.KnifeShop.model.CartModel;

import java.util.List;

public interface CartService {

    void addToCart(CartModel cartModel);

    List<CartModel> getCartByUserId(Long id);

    void deleteCartById(Long id);
}
