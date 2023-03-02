package com.inditex.backend.services;

import java.util.List;

import com.inditex.backend.entity.Price;

public interface PricesService {
	
	List<Price> getPrices();
	
	List<Price> getByPriceList(Long p, String startDate, Long productId);

}
 