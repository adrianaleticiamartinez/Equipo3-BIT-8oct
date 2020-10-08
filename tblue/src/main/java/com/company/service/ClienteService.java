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
		case "Validador":
			return gson.toJson(convertClienteForValidador(cliente));
		case "Restringido":
			return gson.toJson(this.convertClienteForRestringido(cliente));
		default:
			return null;
		}
		
	}
	
	public Cliente convertClienteForValidador(Cliente cliente) {
		String str1 = cliente.getApellidoPaterno().substring(0, 3);
		Integer len1 = cliente.getApellidoPaterno().length() - 3;
		cliente.setApellidoPaterno(str1 + "*".repeat(len1));
		
		String str2 = cliente.getApellidoMaterno().substring(0, 3);
		Integer len2 = cliente.getApellidoMaterno().length() - 3;
		cliente.setApellidoMaterno(str2 + "*".repeat(len2));
		
		String str3 = cliente.getFechaNacimiento().substring(0, 3);
		Integer len3 = cliente.getFechaNacimiento().length() - 3;
		cliente.setFechaNacimiento(str3 + "*".repeat(len3));

		String str4 = cliente.getNacionalidad().substring(0, 3);
		Integer len4 = cliente.getNacionalidad().length() - 3;
		cliente.setNacionalidad(str4 + "*".repeat(len4));
		
		String str6 = cliente.getRfc().substring(0, 3);
		Integer len6 = cliente.getRfc().length() - 3;
		cliente.setRfc(str6 + "*".repeat(len6));
		
		String str7 = cliente.getTipoID().substring(0, 3);
		Integer len7 = cliente.getTipoID().length() - 3;
		cliente.setTipoID(str7 + "*".repeat(len7));
		
		String str8 = cliente.getNumeroID().substring(0, 3);
		Integer len8 = cliente.getNumeroID().length() - 3;
		cliente.setNumeroID(str8 + "*".repeat(len8));
		
		String str9 = cliente.getEmail().substring(0, 3);
		Integer len9 = cliente.getEmail().length() - 3;
		cliente.setEmail(str9 + "*".repeat(len9));
		
		return cliente;
	}
	
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

}
