package com.inditex.backend.entitys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inditex.backend.entity.Price;

public interface RepoPrice extends JpaRepository<Price, Long> {

		//SELECT * FROM Prices WHERE brand_id = 1 AND start_date <= '2020-06-14 16:00:00' AND end_date >= 	'2020-06-14 16:00:00 ' AND product_id=35455
	@Query(value = "SELECT * FROM Prices WHERE brand_id = ?1 AND start_date <= ?2 AND end_date >= ?2 AND product_id=?3", nativeQuery = true)
	List<Price> getParams(Long brandId, String startDate, Long product_id);
	

}
