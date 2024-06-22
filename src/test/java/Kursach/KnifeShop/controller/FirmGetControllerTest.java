package Kursach.KnifeShop.controller;

import Kursach.KnifeShop.model.*;
import Kursach.KnifeShop.service.FirmsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FirmGetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FirmsService firmService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetFirmById() throws Exception {
        Long id = 1L;
        FirmsModel firmsModel = new FirmsModel();
        firmsModel.setId(id);
        firmsModel.setFirm_name("ООО 'Резаки и К'");
        firmsModel.setPhone("+7 495 123-45-67");
        firmsModel.setEmail("info@rezaki.ru");
        firmsModel.setAddress("г. Москва, ул. Резальная, д. 3, стр. 2");
        firmsModel.setDescription("Компания 'Резаки и К' специализируется на производстве и продаже кухонных ножей высокого качества.");

        Mockito.when(firmService.getFirmById(id)).thenReturn(Optional.of(firmsModel));

        mockMvc.perform(get("/firm/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(firmsModel)));
    }
}

