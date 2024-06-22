package Kursach.KnifeShop.service;

import Kursach.KnifeShop.exceptions.UsernameNotFoundException;
import Kursach.KnifeShop.model.CartModel;
import Kursach.KnifeShop.model.User;
import Kursach.KnifeShop.repository.CartRepository;
import Kursach.KnifeShop.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CartServiceImplTest {

    @Mock
    private CartRepository cartRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CartServiceImpl cartService;

    @Test
    void addToCart() {
        CartModel cartModel = new CartModel();
        cartService.addToCart(cartModel);
        verify(cartRepository, times(1)).save(cartModel);
    }

    @Test
    void getCartByUserId_Successful() {
        Long userId = 1L;
        List<CartModel> carts = new ArrayList<>();
        CartModel cart1 = new CartModel();
        CartModel cart2 = new CartModel();
        carts.add(cart1);
        carts.add(cart2);
        when(userRepository.findById(userId)).thenReturn(Optional.of(new User()));
        when(cartRepository.findByUserId(userId)).thenReturn(carts);
        List<CartModel> result = cartService.getCartByUserId(userId);
        assertEquals(2, result.size());
    }

    @Test
    void getCartByUserId_Failure_UserNotFound() {
        Long userId = 1L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());
        assertThrows(UsernameNotFoundException.class, () -> cartService.getCartByUserId(userId));
    }

    @Test
    void deleteCartById() {
        Long cartId = 1L;
        doNothing().when(cartRepository).deleteById(cartId);
        cartService.deleteCartById(cartId);
        verify(cartRepository, times(1)).deleteById(cartId);
    }
}

