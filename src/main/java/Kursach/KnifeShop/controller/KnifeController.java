package Kursach.KnifeShop.controller;

import Kursach.KnifeShop.model.KnifeModel;
import Kursach.KnifeShop.service.KnifeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/knifes")
@RequiredArgsConstructor
@Slf4j
public class KnifeController {

    private final KnifeService knifeService;

    @PostMapping
    public ResponseEntity<Void> addKnife(@RequestBody KnifeModel knifeModel){
        knifeService.addKnife(knifeModel);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteKnifeById(@PathVariable Long id) {
        knifeService.deleteKnifeById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<KnifeModel> getknifeById(@PathVariable Long id){
        return knifeService.getKnifeById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<KnifeModel>> getKnifeByType(@PathVariable String type) {
        List<KnifeModel> knifeModels = knifeService.getKnifeByType(type);
        return ResponseEntity.ok(knifeModels);
    }

    @GetMapping("/model/{model}")
    public ResponseEntity<List<KnifeModel>> getKnifeByModel(@PathVariable String model) {
        List<KnifeModel> knifeModels = knifeService.getKnifeByType(model);
        return ResponseEntity.ok(knifeModels);
    }

    @GetMapping("/all")
    public ResponseEntity<List<KnifeModel>> getAllKnifes(){
        return ResponseEntity.ok(knifeService.getAllKnifes());
    }
}
