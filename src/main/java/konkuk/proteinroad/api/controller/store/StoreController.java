package konkuk.proteinroad.api.controller.store;

import konkuk.proteinroad.api.service.store.StoreService;
import konkuk.proteinroad.api.service.store.dto.StoreDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/{storeId}")
    public ResponseEntity<StoreDto> findStoreBy(@PathVariable("storeId") Long storeId) {

        return ResponseEntity.ok(storeService.findStoreBy(storeId));
    }
}
