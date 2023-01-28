package com.example.demo.renta.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.renta.modelo.Automovil;
import com.example.demo.renta.modelo.Cliente;
import com.example.demo.renta.modelo.Pago;
import com.example.demo.renta.modelo.Renta;
import com.example.demo.renta.repository.IRentaRepo;

@Service
public class RentaServiceImpl implements IRentaService{

	@Autowired
	private IRentaRepo iRentaRepo;
	
	@Autowired
	private IAutomovilService iAutomovilService;
	
	@Autowired
	private IClienteService iClienteService;
	
	@Override
	public Renta rentar(Automovil automovil, Cliente cliente) {
		// TODO Auto-generated method stub
		Renta renta=new Renta();
		Pago pago=new Pago();
		renta.setNumeroDia(3);
		renta.setAutomovil(automovil);
		renta.setCliente(cliente);
		renta.setFechaDia(LocalDateTime.now());
		pago.setNumeroTarjeta("23123asd");
		
		BigDecimal dias=new BigDecimal(renta.getNumeroDia());
		BigDecimal valor=automovil.getValorDia().multiply(dias);
		renta.setValor(valor);

		BigDecimal valorPago=valor.add(valor.multiply(new BigDecimal(0.05)));
		pago.setValor(valorPago);

		pago.setRenta(renta);
		renta.setPago(pago);
		this.iRentaRepo.insertar(renta);
		return renta;
	}

	@Override
	public void cancelar(Integer renta) {
		this.iRentaRepo.eliminar(renta);
	}

}
