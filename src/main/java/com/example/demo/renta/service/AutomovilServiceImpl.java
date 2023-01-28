package com.example.demo.renta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.renta.modelo.Automovil;
import com.example.demo.renta.repository.IAutomovilRepo;

@Service
public class AutomovilServiceImpl implements IAutomovilService{

	@Autowired
	private IAutomovilRepo iAutomovilRepo;
	
	@Override
	public void agregar(Automovil automovil) {
		// TODO Auto-generated method stub
		this.iAutomovilRepo.insertar(automovil);
	}

	@Override
	public Automovil encontrar(String placa) {
		// TODO Auto-generated method stub
		return this.iAutomovilRepo.buscar(placa);
	}

}
