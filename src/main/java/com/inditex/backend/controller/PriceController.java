package com.inditex.backend.controller;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.inditex.backend.entity.Price;
import com.inditex.backend.services.PricesService;

@RequestMapping(value = "/prices")
@RestController
public class PriceController {

	@Autowired
	PricesService service;

	@GetMapping("/all")
	public ResponseEntity<List<Price>> findAll() {

		return ResponseEntity.ok().body(service.getPrices());

	}

	/*
	 * Las fechas ponerlas en este formato : 2020-06-14 15:00:00 Ejemplo entrada :
	 * http://localhost:8080/prices/1/2020-06-14 15:00:00/2
	 * 
	 * Sería mejor devolver una lista de DTO en vez de la lista de entidades Price
	 * haciendo un mapeo
	 */

	@GetMapping(value = "/{idProducto}/{startDate}/{priceList}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Price>> findByPriceList2(@PathVariable Long idProducto, @PathVariable String startDate,
			@PathVariable Long priceList) throws Exception {

		List<Price> prices = service.getByPriceList(idProducto, startDate, priceList);

		if (prices.size() == 0) {
			throw new Exception("El producto no existe con los parametros dados");
		}

		return ResponseEntity.ok().body(service.getByPriceList(idProducto, startDate, priceList));

	}
}
