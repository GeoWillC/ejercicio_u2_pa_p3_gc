package com.example.demo.renta.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="renta")
public class Renta {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rent_sec")
	@SequenceGenerator(name = "prent_sec", sequenceName = "rent_sec", allocationSize = 1)
	@Column(name="rent_id")
	private Integer id;

	@Column(name="rent_fecha")
	private LocalDateTime fechaDia;
	
	@Column(name="rent_numero_dias")
	private Integer numeroDia;
	
	@Column(name="rent_valor")
	private BigDecimal valor;

	
	@ManyToOne
	@JoinColumn(name="rent_cedula_cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="rent_placa_automivil")
	private Automovil automovil;

	@OneToOne(mappedBy = "renta",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Pago pago;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFechaDia() {
		return fechaDia;
	}

	public void setFechaDia(LocalDateTime fechaDia) {
		this.fechaDia = fechaDia;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Automovil getAutomovil() {
		return automovil;
	}

	public void setAutomovil(Automovil automovil) {
		this.automovil = automovil;
	}

	
	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	
	public Integer getNumeroDia() {
		return numeroDia;
	}

	public void setNumeroDia(Integer numeroDia) {
		this.numeroDia = numeroDia;
	}

	@Override
	public String toString() {
		return "Renta [id=" + id + ", fechaDia=" + fechaDia + ", numeroDia=" + numeroDia + ", valor=" + valor
				+ ", pago=" + pago + "]";
	}
	
}
