package Kursach.KnifeShop.controller;

import Kursach.KnifeShop.model.FirmsModel;
import Kursach.KnifeShop.model.KnifeModel;
import Kursach.KnifeShop.service.FirmsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/firms")
@RequiredArgsConstructor
@Slf4j
public class FirmController {

    private final FirmsService firmsService;

    @PostMapping
    public ResponseEntity<Void> addFirm(@RequestBody FirmsModel firmsModel){
        firmsService.addFirm(firmsModel);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteKnifeById(@PathVariable Long id) {
        firmsService.deleteFirmById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FirmsModel> getFirmById(@PathVariable Long id){
        return firmsService.getFirmById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
