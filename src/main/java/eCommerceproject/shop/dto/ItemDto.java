package eCommerceproject.shop.dto;

import eCommerceproject.shop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
    private Long id;

    private String ItemNm;

    private Integer price; //가격

    private int stockNumber; //재고수량

    private String itemDetail; //상품 상세 설명

    private ItemSellStatus itemSellStatus; //상품 판매 상태
}
