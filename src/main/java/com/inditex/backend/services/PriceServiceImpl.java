package com.inditex.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inditex.backend.entity.Price;
import com.inditex.backend.entitys.repository.RepoPrice;

@Service
@Transactional
public class PriceServiceImpl implements PricesService{
	
	@Autowired
	RepoPrice repo;

	@Override
	public List<Price> getPrices() {
		
		 List<Price>  lstPrices=repo.findAll();
		return lstPrices;
	}


	@Override
	public List<Price> getByPriceList(Long p, String startDate, Long productId) {
		List<Price>  prices=repo.getParams(p, startDate, productId);
		return prices;
	}

}
