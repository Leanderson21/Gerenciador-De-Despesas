package br.com.despesas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.despesas.model.Despesa;
import br.com.despesas.service.DespesaService;

@Controller
public class DespesaController {

	@Autowired
	DespesaService despesaService;
	
	@GetMapping("/novadespesa")
	public ModelAndView getFormDespesas() {
		ModelAndView mv = new ModelAndView("NovaDespesa");
		return mv;
	}
	
	@PostMapping("/salvar")
	public String salvarDespesa(@ModelAttribute Despesa despesa) {
		despesaService.salvarDespesa(despesa);
		return "redirect:/listar";
	}
	
	@PostMapping("/editar")
	public String editarDespesa(@ModelAttribute Despesa despesa) {
		despesaService.editarDespesa(despesa);
		return "redirect:/listar";
	}
	
	
	@GetMapping("/listar")
	public ModelAndView listarDespesas() {
		ModelAndView mv = new ModelAndView("index");
		List<Despesa> despesas = despesaService.listarDespesas();
		String dp = despesaService.totalDespesa();
		mv.addObject("despesas", despesas);
		mv.addObject("total", dp);
		return mv;
	}
	
	
	@GetMapping("/detalhe/{id}")
	public ModelAndView detalheDespesa(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("DespesaDetalhe");
		Despesa despesa = despesaService.encontrarDespesaPorId(id);
		mv.addObject("despesa", despesa);
		return mv;
	}
	
	@GetMapping("/excluir/{id}")
	public String excluirDespesa(@PathVariable("id") long id){
		despesaService.excluirDespesa(id);
		return "redirect:/listar";
	}
	
}
