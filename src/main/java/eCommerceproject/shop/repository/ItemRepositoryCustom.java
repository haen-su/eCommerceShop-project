package eCommerceproject.shop.repository;

import eCommerceproject.shop.domain.Item;
import eCommerceproject.shop.dto.ItemSearchDto;
import eCommerceproject.shop.dto.MainItemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemRepositoryCustom {

    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getMainItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

}
