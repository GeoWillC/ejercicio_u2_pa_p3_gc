package com.example.demo.renta.service;

import com.example.demo.renta.modelo.Automovil;
import com.example.demo.renta.modelo.Cliente;
import com.example.demo.renta.modelo.Renta;


public interface IRentaService {
	public Renta rentar(Automovil automovil,Cliente cliente);
	public void cancelar(Integer renta);
}
