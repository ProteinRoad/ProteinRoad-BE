package konkuk.proteinroad.api.controller.menu;

import konkuk.proteinroad.api.controller.menu.request.MenuCreateRequest;
import konkuk.proteinroad.api.service.menu.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/menus")
public class MenuController {

    private final MenuService menuService;

    @PostMapping
    public ResponseEntity<Long> createMenu(
            @RequestPart(value = "file", required = false) MultipartFile multipartFile,
            @RequestPart(value = "request") MenuCreateRequest menuCreateRequest
    ) {
        Long savedId = menuService.createMenu(menuCreateRequest.toServiceRequest(), multipartFile);

    }
}
