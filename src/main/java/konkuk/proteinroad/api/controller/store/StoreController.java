package konkuk.proteinroad.api.controller.store;

import jakarta.validation.Valid;
import java.net.URI;
import konkuk.proteinroad.api.controller.store.request.StoreCreateRequest;
import konkuk.proteinroad.api.service.store.StoreService;
import konkuk.proteinroad.api.service.store.response.FindAllStoreWithMenuResponse;
import konkuk.proteinroad.api.service.store.response.StoreDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/{storeId}")
    public ResponseEntity<StoreDto> findStoreBy(@PathVariable("storeId") Long storeId) {

        return ResponseEntity.ok(storeService.findStoreBy(storeId));
    }

    @GetMapping("/all")
    public ResponseEntity<FindAllStoreWithMenuResponse> findAllStores() {

        return ResponseEntity.ok(storeService.findAllStoresWithMenus());
    }

    @PostMapping("/")
    public ResponseEntity<Long> createStore(@Valid @RequestBody StoreCreateRequest request) {
        Long savedId = storeService.createStore(request.toServiceRequest());
        URI location = URI.create("/api/stores/" + savedId);

        return ResponseEntity.created(location).build();
    }
}
