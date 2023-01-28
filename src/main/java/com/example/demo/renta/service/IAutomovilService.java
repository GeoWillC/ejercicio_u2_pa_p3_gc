package com.example.demo.renta.service;

import com.example.demo.renta.modelo.Automovil;

public interface IAutomovilService {

	public void agregar(Automovil automovil);
	public Automovil encontrar(String placa);
}
