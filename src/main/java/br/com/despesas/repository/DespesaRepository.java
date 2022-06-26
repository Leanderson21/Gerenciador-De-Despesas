package br.com.despesas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.despesas.model.Despesa;



@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

	
	@Query(value="SELECT ROUND(SUM(valor_despesa),2) as total FROM tb_despesa" ,nativeQuery = true)
	String totalDespesa();
	
	
}
