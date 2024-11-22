package konkuk.proteinroad.api.service.brand;

import konkuk.proteinroad.api.service.brand.request.BrandCreateServiceRequest;
import org.springframework.web.multipart.MultipartFile;

public interface BrandService {

    Long createBrand(BrandCreateServiceRequest request, MultipartFile multipartFile);
}
