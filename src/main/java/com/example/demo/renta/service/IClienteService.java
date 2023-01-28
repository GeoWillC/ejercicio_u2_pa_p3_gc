package com.example.demo.renta.service;

import com.example.demo.renta.modelo.Cliente;

public interface IClienteService {
	public void agregar(Cliente cliente);
	public Cliente encontrar(String cedula);
}
