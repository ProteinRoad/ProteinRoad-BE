package konkuk.proteinroad.api.service.menu;

import static konkuk.proteinroad.global.exception.errorCode.brand.BrandErrorCode.BRAND_NOT_FOUND;

import konkuk.proteinroad.api.service.file.FileService;
import konkuk.proteinroad.api.service.menu.request.MenuCreateServiceRequest;
import konkuk.proteinroad.domain.brand.Brand;
import konkuk.proteinroad.domain.brand.BrandRepository;
import konkuk.proteinroad.domain.menu.Menu;
import konkuk.proteinroad.domain.menu.MenuConverter;
import konkuk.proteinroad.domain.menu.MenuRepository;
import konkuk.proteinroad.global.exception.RestApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Transactional
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final BrandRepository brandRepository;
    private final FileService s3Service;

    public Long createMenu(MenuCreateServiceRequest request, MultipartFile multipartFile) {
        Brand brand = brandRepository.findById(request.getBrandId())
                .orElseThrow(() -> new RestApiException(BRAND_NOT_FOUND.getErrorCode()));
        String fileName = s3Service.uploadFile(multipartFile);

        Menu menu = MenuConverter.toEntity(request);
        menu.registerBrand(brand);
        menu.registerImage(fileName);
        brand.addMenu(menu);

        return menuRepository.save(menu).getId();
    }
}
