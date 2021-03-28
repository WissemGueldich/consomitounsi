package tn.esprit.consomitounsi.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pidv.consomiTounsi.webservices.model.Stock;
import com.pidv.consomiTounsi.webservices.repository.StockRepository;

@RestController
@RequestMapping("/api/v1")
public class StockController {
	@Autowired
	private StockRepository stockRepository;
	
	// create get all stocks api
	
	@GetMapping("/stocks")
	public List<Stock> getAllstocks(){
		return stockRepository.findAll();
	}
	// create stock
	@PostMapping("/stocks")
	public Stock createStock(@Validated @RequestBody Stock stock) {
		return stockRepository.save(stock);
	}
	
	// get stock by id
	@GetMapping("/stocks/{id}")
	public ResponseEntity<Stock> getstockById(@PathVariable(value = "id") Long stockId)
			throws ResourceNotFoundException {
		Stock stock = stockRepository.findById(stockId)
				.orElseThrow(() -> new ResourceNotFoundException("stock not found for this id :: " + stockId));
		return ResponseEntity.ok().body(stock);
	}
	// update stock
	@PutMapping("/stocks/{id}")
	public ResponseEntity<Stock> updatestock(@PathVariable(value = "id") Long stockId,
			@Validated @RequestBody Stock stockDetails) throws ResourceNotFoundException {
		Stock stock = stockRepository.findById(stockId)
				.orElseThrow(() -> new ResourceNotFoundException("stock not found for this id :: " + stockId));

		stock.setProductNumber(stockDetails.getProductNumber());
		stock.setStockName(stockDetails.getStockName());
		stock.setStockType(stockDetails.getStockType());
		stock.setStockCategory(stockDetails.getStockCategory());
		final Stock updatedStock = stockRepository.save(stock);
		return ResponseEntity.ok(updatedStock);
	}
	// delete stock 
	@DeleteMapping("/stocks/{id}")
	public Map<String, Boolean> deleteStock(@PathVariable(value = "id") Long stockId)
			throws ResourceNotFoundException {
		Stock stock = stockRepository.findById(stockId)
				.orElseThrow(() -> new ResourceNotFoundException("stock not found for this id :: " + stockId));

		stockRepository.delete(stock);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
