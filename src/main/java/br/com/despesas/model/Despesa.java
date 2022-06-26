package br.com.despesas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "TB_DESPESA")
public class Despesa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_despesa;
	
	@NotBlank
	private String nome_despesa;
	
	@NotBlank
	private String descricao_despesa;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate Data_vencimento;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate Data_pagamento;
	
	private Float valor_despesa;
	
	
	
	
	public Long getId_despesa() {
		return id_despesa;
	}

	public void setId_despesa(Long id_despesa) {
		this.id_despesa = id_despesa;
	}

	public String getNome_despesa() {
		return nome_despesa;
	}

	public void setNome_despesa(String nome_despesa) {
		this.nome_despesa = nome_despesa;
	}

	public String getDescricao_despesa() {
		return descricao_despesa;
	}

	public void setDescricao_despesa(String descricao_despesa) {
		this.descricao_despesa = descricao_despesa;
	}

	public LocalDate getData_vencimento() {
		return Data_vencimento;
	}

	public void setData_vencimento(LocalDate data_vencimento) {
		Data_vencimento = data_vencimento;
	}

	public LocalDate getData_pagamento() {
		return Data_pagamento;
	}

	public void setData_pagamento(LocalDate data_pagamento) {
		Data_pagamento = data_pagamento;
	}

	public Float getValor_despesa() {
		return valor_despesa;
	}

	public void setValor_despesa(Float valor_despesa) {
		this.valor_despesa = valor_despesa;
	}

	
}
