package Kursach.KnifeShop.controller;

import Kursach.KnifeShop.model.CartModel;
import Kursach.KnifeShop.model.ReviewModel;
import Kursach.KnifeShop.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
@Slf4j
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<Void> addFirm(@RequestBody CartModel cartModel){
        cartService.addToCart(cartModel);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteKnifeById(@PathVariable Long id) {
        cartService.deleteCartById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<CartModel>> getCartByUserId(@PathVariable Long userId){
        List<CartModel> cartModels = cartService.getCartByUserId(userId);
        return ResponseEntity.ok(cartModels);
    }
}
