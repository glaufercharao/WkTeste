package com.wkteste.main.repositories;

import com.wkteste.main.models.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("SELECT p.estado as estado, COUNT(p.estado) as quantidade FROM Pessoa as p " +
            "WHERE p.estado IN (SELECT DISTINCT p.estado  FROM Pessoa) AND FLOOR(DATEDIFF(NOW(),p.dataNasc)/365) " +
            "BETWEEN 16 AND 69 and p.peso > 50" +
            "GROUP BY p.estado")
    List<Map<String,Integer>> buscaQtdPessoaPorEstado();
    @Query("SELECT p FROM Pessoa p " +
            "WHERE FLOOR(DATEDIFF(NOW(),p.dataNasc)/365) " +
            "BETWEEN 16 AND 69 and p.peso > 50")
    List<Pessoa> buscarDoadores();

    @Query("SELECT" +
            "   count(p.tipoSanguineo) as quantidade " +
            "FROM" +
            "    Pessoa p " +
            "WHERE p.tipoSanguineo IN (?1) AND FLOOR(DATEDIFF(NOW(),p.dataNasc)/365) " +
            "BETWEEN 16 AND 69 and p.peso > 50")
    Long getQtdPossivelDoador(List<String> tipoSanguineo);
}
