package com.example.demo.renta.repository;

import com.example.demo.renta.modelo.Cliente;

public interface IClienteRepo {

	public void insertar(Cliente cliente);
	public Cliente buscar(String cedula);
	
}
