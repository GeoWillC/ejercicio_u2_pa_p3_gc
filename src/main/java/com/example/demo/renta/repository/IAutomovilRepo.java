package com.example.demo.renta.repository;

import com.example.demo.renta.modelo.Automovil;

public interface IAutomovilRepo {

	public void insertar(Automovil automovil);
	public Automovil buscar(String placa);
}
