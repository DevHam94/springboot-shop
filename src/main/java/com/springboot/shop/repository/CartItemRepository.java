package com.springboot.shop.repository;

import com.springboot.shop.dto.CartDetailDto;
import com.springboot.shop.entity.Cart;
import com.springboot.shop.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    CartItem findByCartIdAndItemId(Long cartId, Long itemId);

    @Query("select new com.springboot.shop.dto.CartDetailDto(ci.id, i.itemNm, i.price, ci.count, im.imgUrl) " +
    "from CartItem ci, ItemImg im " +
    "join ci.item i " +
    "where ci.cart.id = :cartId " +
    "and im.item.id = ci.item.id " +
    "and im.repimgYn = 'Y' " +
    "order by ci.regTime desc")
    List<CartDetailDto> findCartDetailDtoList(Long cartId);

    CartItem cart(Cart cart);
}
