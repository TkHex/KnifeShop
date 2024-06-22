package Kursach.KnifeShop.controller;

import Kursach.KnifeShop.model.*;
import Kursach.KnifeShop.service.KnifeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class KnifeGetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KnifeService knifeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetKnifeById() throws Exception {
        Long id = 1L;
        KnifeModel knifeModel = new KnifeModel();
        knifeModel.setId(id);

        FirmsModel firmsModel = new FirmsModel();
        firmsModel.setId(1L);
        firmsModel.setFirm_name("ООО 'Резаки и К'");
        firmsModel.setPhone("+7 495 123-45-67");
        firmsModel.setEmail("info@rezaki.ru");
        firmsModel.setAddress("г. Москва, ул. Резальная, д. 3, стр. 2");
        firmsModel.setDescription("Компания 'Резаки и К' специализируется на производстве и продаже кухонных ножей высокого качества.");

        knifeModel.setFirmsModel(firmsModel);

        CartModel cartModel = new CartModel();
        cartModel.setId(1L);
        cartModel.setCartName("Покупочки");

        User user = new User();
        user.setId(1L);
        user.setUsername("IvanIvanov");
        user.setPassword("verySecurePassword123");
        user.setExpired(false);
        user.setLocked(false);
        user.setEnabled(true);

        cartModel.setUser(user);

        knifeModel.setModel("ChefKnife");
        knifeModel.setType("Kitchen");
        knifeModel.setMetal("Stainless Steel");
        knifeModel.setLenght("20 cm");
        knifeModel.setRating(4.5);


        Mockito.when(knifeService.getKnifeById(id)).thenReturn(Optional.of(knifeModel));

        mockMvc.perform(get("/knife/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(knifeModel)));
    }
}

