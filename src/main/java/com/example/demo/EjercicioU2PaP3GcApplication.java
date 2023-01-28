package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.renta.modelo.Automovil;
import com.example.demo.renta.modelo.Cliente;
import com.example.demo.renta.modelo.Renta;
import com.example.demo.renta.repository.IAutomovilRepo;
import com.example.demo.renta.service.IAutomovilService;
import com.example.demo.renta.service.IClienteService;
import com.example.demo.renta.service.IRentaService;

@SpringBootApplication
public class EjercicioU2PaP3GcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EjercicioU2PaP3GcApplication.class, args);
	}

	@Autowired
	private IAutomovilService iAutomovilService;
	
	@Autowired 
	private IClienteService iClienteService;
	
	@Autowired
	private IRentaService iRentaService;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
		Automovil automovil=new Automovil();
		automovil.setPlaca("PCS122");
		automovil.setValorDia(new BigDecimal(120));

		Cliente cliente=new Cliente();
		cliente.setCedula("1272731");
		cliente.setNombre("Carlos");
		List<Renta > rentar=new ArrayList<>();
		Renta renta=this.iRentaService.rentar(automovil,cliente) ;
		rentar.add(renta);
		automovil.setRenta(rentar);
		cliente.setRenta(rentar);
		this.iAutomovilService.agregar(automovil);
		this.iClienteService.agregar(cliente);
		
		this.iAutomovilService.encontrar("PCS122");
		this.iClienteService.encontrar("1272731");
		//Se remueve en cascada por lo que el pago tambien se cancela
		this.iRentaService.cancelar(1);
		
	}

}
