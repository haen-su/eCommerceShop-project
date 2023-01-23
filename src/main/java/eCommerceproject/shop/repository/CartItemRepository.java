package eCommerceproject.shop.repository;

import eCommerceproject.shop.domain.CartItem;
import eCommerceproject.shop.dto.CartDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    CartItem findByCartIdAndItemId(Long cartId, Long itemId);


    // Dto 생성자로 바로 반환하는 JPQL 쿼리
    @Query("select new eCommerceproject.shop.dto.CartDetailDto(ci.id, i.itemNm, i.price, ci.count, im.imgUrl)" +
            "from CartItem ci, ItemImg im " +
            "join ci.item i " +
            "where ci.cart.id = :cartId " +
            "and im.item.id = ci.item.id " +
            "and im.repimgYn = 'Y' " +
            "order by ci.regTime desc")
    List<CartDetailDto> findCartDetailDtoList(Long cartId);

}
