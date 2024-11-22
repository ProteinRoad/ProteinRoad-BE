package konkuk.proteinroad.api.controller.brand;

import jakarta.validation.Valid;
import java.net.URI;
import konkuk.proteinroad.api.controller.brand.request.BrandCreateRequest;
import konkuk.proteinroad.api.service.brand.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/brands")
public class BrandController {

    private final BrandService brandService;

    @PostMapping("")
    public ResponseEntity<Long> createBrand(
            @RequestPart(value = "file", required = false) MultipartFile multipartFile,
            @Valid @RequestPart(value = "request") BrandCreateRequest brandCreateRequest
    ) {
        Long savedId = brandService.createBrand(brandCreateRequest.toServiceRequest(), multipartFile);
        URI location = URI.create("/api/brands/" + savedId);

        return ResponseEntity.created(location).build();
    }
}
