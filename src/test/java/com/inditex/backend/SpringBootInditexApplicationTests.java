package com.inditex.backend;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
class SpringBootInditexApplicationTests {

	@Autowired
	MockMvc mvc;

	/* Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
-          Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)

		   Test 6: se crea uno nuevo para con fecha 2021 para comprobar que falla

	 */
	
		
	@Test
	@DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)")	
	void test_2() throws Exception {
		mvc.perform(get("/prices/{idProducto}/{startDate}/{idProducto}", 1, "2020-06-14 10:00:00", 35455))
				.andExpect(status().isOk());
					

	}
	
	@Test
	@DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)")	
	void test_1() throws Exception {
		mvc.perform(get("/prices/{idProducto}/{startDate}/{idProducto}", 1, "2020-06-14 16:00:00", 35455))
				.andExpect(status().isOk());
					

	}

	@Test
	@DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)")	
	void test_3() throws Exception {
		mvc.perform(get("/prices/{idProducto}/{startDate}/{idProducto}", 1, "2020-06-14 21:00:00", 35455))
				.andExpect(status().isOk());				

	}
	
	@Test
	@DisplayName(" Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)")	
	void test_4() throws Exception {
		mvc.perform(get("/prices/{idProducto}/{startDate}/{idProducto}", 1, "2020-06-15 10:00:00", 35455))
				.andExpect(status().isOk());				

	}

	@Test
	@DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)")	
	void test_5() throws Exception {
		mvc.perform(get("/prices/{idProducto}/{startDate}/{idProducto}", 1, "2020-06-16 21:00:00", 35455))
				.andExpect(status().isOk());				

	}

	
	//@Test
	@DisplayName("Test 6: Falla porque no existen productos para el año 2021")	
	void test_6() throws Exception {
		mvc.perform(get("/prices/{idProducto}/{startDate}/{idProducto}", 1, "2021-06-16 21:00:00", 35455))
				.andExpect(status().isOk());					

	}
}
