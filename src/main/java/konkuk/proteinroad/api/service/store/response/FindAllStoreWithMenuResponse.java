package konkuk.proteinroad.api.service.store.response;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FindAllStoreWithMenuResponse {

    private final List<StoreWithMenusDto> storeWithMenusDtoList;

    @Builder
    private FindAllStoreWithMenuResponse(List<StoreWithMenusDto> storeWithMenusDtoList) {
        this.storeWithMenusDtoList = storeWithMenusDtoList;
    }
}
