package konkuk.proteinroad.api.service.brand;

import konkuk.proteinroad.api.service.brand.request.BrandCreateServiceRequest;
import konkuk.proteinroad.api.service.file.FileService;
import konkuk.proteinroad.domain.brand.Brand;
import konkuk.proteinroad.domain.brand.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Transactional
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final FileService s3Service;

    public Long createBrand(BrandCreateServiceRequest request, MultipartFile multipartFile) {
        String fileName = s3Service.uploadFile(multipartFile);
        Brand brand = Brand.create(request.getName(), fileName);

        return brandRepository.save(brand).getId();
    }
}
