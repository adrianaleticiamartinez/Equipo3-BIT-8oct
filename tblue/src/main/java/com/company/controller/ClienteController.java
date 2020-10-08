package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.exceptions.NoSuchClientException;
import com.company.exceptions.NoSuchUserException;
import com.company.service.ClienteService;

@CrossOrigin
@RestController
@RequestMapping("/cliente")
@Validated
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(produces="application/json")
	public ResponseEntity<String> getCliente(@RequestParam("clienteId") String clienteId,
			@RequestParam("usuarioId")String usuarioId) throws NoSuchClientException, NoSuchUserException {
		//try {
			String cliente = clienteService.getCliente(clienteId, usuarioId);
			return new ResponseEntity<String>(cliente, HttpStatus.OK);
		//}catch(Exception e) {
			//System.out.println(e);
			//throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El cliente no existe");
		//}
		
	}
	
	/*@PostMapping(consumes="application/json")
	public ResponseEntity<?> addNewProduct(@RequestBody Product product) throws Exception{
		try {
			sellerProductService.addNewProduct(product);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}catch(Exception e) {
			System.out.println(e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"");
		}
	}
	
	//Get all the categories
	@GetMapping(value="/categories", produces="application/json")
	public ResponseEntity<List<String>> getCategories() throws Exception {
		try {
			List<String> categories = sellerProductService.getCategories();
			return new ResponseEntity<List<String>>(categories, HttpStatus.OK);
		}catch(Exception e) {
			System.out.println(e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"");
		}
	}*/
}
