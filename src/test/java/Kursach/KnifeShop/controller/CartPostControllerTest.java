package Kursach.KnifeShop.controller;

import Kursach.KnifeShop.model.CartModel;
import Kursach.KnifeShop.model.User;
import Kursach.KnifeShop.service.CartService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CartPostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartService cartService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateCart() throws Exception {
        Long id = 1L;
        CartModel cartModel = new CartModel();
        cartModel.setId(id);
        cartModel.setCartName("Мои Покупки");

        User user = new User();
        user.setId(1L);
        user.setUsername("IvanIvanov");
        user.setPassword("verySecurePassword123");
        user.setExpired(false);
        user.setLocked(false);
        user.setEnabled(true);

        cartModel.setUser(user);

        Mockito.doNothing().when(cartService).addToCart(Mockito.any(CartModel.class));

        mockMvc.perform(post("/carts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cartModel)))
                .andExpect(status().isCreated());
    }
}
