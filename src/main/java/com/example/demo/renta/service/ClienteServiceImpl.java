package com.example.demo.renta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.renta.modelo.Cliente;
import com.example.demo.renta.repository.IClienteRepo;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteRepo iClienteRepo;
	
	@Override
	public void agregar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.iClienteRepo.insertar(cliente);
	}

	@Override
	public Cliente encontrar(String cedula) {
		// TODO Auto-generated method stub
		return this.iClienteRepo.buscar(cedula);
	}

}
