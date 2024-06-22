package Kursach.KnifeShop.service;

import Kursach.KnifeShop.exceptions.UsernameNotFoundException;
import Kursach.KnifeShop.model.CartModel;
import Kursach.KnifeShop.model.User;
import Kursach.KnifeShop.repository.CartRepository;
import Kursach.KnifeShop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    @Override
    public void addToCart(CartModel cartModel) {
        cartRepository.save(cartModel);
    }

    @Override
    public List<CartModel> getCartByUserId(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return cartRepository.findByUserId(userId);
        } else {
            throw new UsernameNotFoundException(userId);
        }
    }

    @Override
    public void deleteCartById(Long id) {
        cartRepository.deleteById(id);
    }
}
