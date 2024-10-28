package konkuk.proteinroad.api.service.menu;

import konkuk.proteinroad.api.service.menu.request.MenuCreateServiceRequest;
import org.springframework.web.multipart.MultipartFile;

public interface MenuService {

    Long createMenu(MenuCreateServiceRequest request, MultipartFile multipartFile);
}
