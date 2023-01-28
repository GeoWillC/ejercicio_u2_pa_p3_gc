package com.example.demo.renta.repository;

import com.example.demo.renta.modelo.Renta;

public interface IRentaRepo {

	public void insertar(Renta renta);
	public void eliminar(Integer id);
	public Renta buscar(Integer id);

	
}
