package br.com.despesas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.despesas.model.Despesa;
import br.com.despesas.repository.DespesaRepository;

@Service
public class DespesaService {

	@Autowired
	DespesaRepository despesaRepository;
	
	
	public Despesa salvarDespesa(Despesa despesa){
		return despesaRepository.save(despesa); 
	}
	
	public List<Despesa> listarDespesas(){
		return despesaRepository.findAll();
	}
	
	public Despesa encontrarDespesaPorId(long id){
		return despesaRepository.findById(id).get();
	}
	
	public void excluirDespesa(long id){
		despesaRepository.deleteById(id);
	}
	
	public Despesa editarDespesa(Despesa despesa) {
		return despesaRepository.save(despesa);
	}
	
	public String totalDespesa() {
	return despesaRepository.totalDespesa();
	}
	
}
