package com.company.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.company.exceptions.NoSuchClientException;
import com.company.exceptions.NoSuchUserException;
import com.company.model.Cliente;
import com.company.model.Usuario;

import ch.qos.logback.core.net.server.Client;

@Repository(value="clienteRepository")
public class ClienteRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Cliente getCliente(String clienteId) throws NoSuchClientException {
		try {
			System.out.println(clienteId);
			String sql = "select * from cliente where idCliente = ?";
			return jdbcTemplate.queryForObject(sql, new Object[] {clienteId}, new RowMapper<Cliente>() {
				public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
					Cliente cliente = new Cliente();
					cliente.setIdCliente(rs.getString("idCliente"));
					cliente.setNombre(rs.getString("nombre"));
					cliente.setApellidoPaterno(rs.getString("apellidopaterno"));
					cliente.setApellidoMaterno(rs.getString("apellidomaterno"));
					cliente.setFechaNacimiento(rs.getString("fechanacimiento"));
					cliente.setSexo(rs.getString("sexo"));
					cliente.setNacionalidad(rs.getString("nacionalidad"));
					cliente.setRfc(rs.getString("rfc"));
					cliente.setTipoID(rs.getString("tipoid"));
					cliente.setNumeroID(rs.getString("numeroid"));
					cliente.setCuenta(rs.getString("cuenta"));
					cliente.setEmail(rs.getString("email"));
					cliente.setSegmento(rs.getString("segmento"));
					return cliente;
				}
			});
		}catch(Exception ex) {
			throw new NoSuchClientException("Cliente con id " + clienteId + " no existe");
		}
	}
	
	public Usuario getUsuario(String usuarioId) throws NoSuchUserException {
		try {
			String sql = "select * from usuario where usuario = ?";
			return jdbcTemplate.queryForObject(sql, new Object[] {usuarioId}, new RowMapper<Usuario>() {
				public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
					Usuario usuario = new Usuario();
					usuario.setPerfil(rs.getString("perfil"));
					return usuario;
				}
			});
		}catch(Exception ex) {
			throw new NoSuchUserException("Usuario con id " + usuarioId + " no existe");
		}
	}
	
}
