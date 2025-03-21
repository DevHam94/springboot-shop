package com.springboot.shop.repository;

import com.springboot.shop.dto.ItemSearchDto;
import com.springboot.shop.dto.MainItemDto;
import com.springboot.shop.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemRepositoryCustom {
    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getMainItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
}
