package com.company.service;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.exceptions.NoSuchClientException;
import com.company.exceptions.NoSuchUserException;
import com.company.model.Cliente;
import com.company.model.Usuario;
import com.company.repository.ClienteRepository;
import com.google.gson.Gson;

@Service(value="clienteService")
@Transactional
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	Gson gson;
	
	public String getCliente(String clienteId, String usuarioId) throws NoSuchClientException, NoSuchUserException {
		Cliente cliente = clienteRepository.getCliente(clienteId);
		Usuario usuario = clienteRepository.getUsuario(usuarioId);
		
		String perfil = usuario.getPerfil();
		
		System.out.println(perfil);
		switch(perfil) {
		case "Manager":
			return gson.toJson(cliente);
		/*case "Validador":
			return gson.toJson(convertClienteForValidador(cliente));*/
		case "Restringido":
			return gson.toJson(this.convertClienteForRestringido(cliente));
		default:
			return null;
		}
		
	}
	
	/*public Cliente convertClienteForValidador(Cliente cliente) {
		String str1 = cliente.getDireccion().substring(0, 3);
		Integer len = cliente.getDireccion().length() - 3;
		cliente.setDireccion(str1 + "*".repeat(len));
		return cliente;
	}*/
	
	public Cliente convertClienteForRestringido(Cliente cliente) {
		//Solo se setean null los campos que deben ser restringido
		cliente.setApellidoPaterno(null);
		cliente.setApellidoMaterno(null);
		cliente.setFechaNacimiento(null);
		cliente.setNacionalidad(null);
		cliente.setRfc(null);
		cliente.setTipoID(null);
		cliente.setNumeroID(null);
		cliente.setEmail(null);
		return cliente;
	}
	
	/*public List<String> readReglas() {
		try {
			List<String> list = Files.readAllLines(new File("D:\\Mock App\\Sitio\\tblue\\src\\main\\resources\\reglas.txt").toPath(), Charset.defaultCharset() );
			return list;
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}*/
	
	/*public Integer addNewProduct(Product product) {
		Integer productId = sellerProductRepository.addNewProduct(product);
		return productId;
	}
	
	public List<String> getCategories(){
		return sellerProductRepository.getCategories();
	}*/
}
