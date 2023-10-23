package com.wkteste.main.services.impl;

import com.wkteste.main.mapper.Mappable;
import com.wkteste.main.models.dtos.PessoaDTO;
import com.wkteste.main.models.entities.Pessoa;
import com.wkteste.main.repositories.PessoaRepository;
import com.wkteste.main.services.PessoaService;
import com.wkteste.main.util.FactoryTipoReceptor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
@Data
public class PessoaServiceImpl implements PessoaService, Mappable {

    private final PessoaRepository repository;
    @Override
    @Transactional
    public PessoaDTO savePessoa(PessoaDTO pessoa) {
        return map(repository.save(map(pessoa,Pessoa.class)), PessoaDTO.class);
    }

    @Override
    @Transactional
    public List<PessoaDTO> saveAllPessoas(List<PessoaDTO> pessoa) {
         return map(repository.saveAll(map(pessoa,Pessoa.class)), PessoaDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Map<String, Integer>> qtdPessoaPorEstado() {
        return repository.buscaQtdPessoaPorEstado();
    }

    @Override
    public List<PessoaDTO> buscarDoadores() {
        return map(repository.buscarDoadores(), PessoaDTO.class);
    }

    @Override
    public List<Map<String, Long>> qtdDoadorTipoReceptor() {

        List tipos =  Arrays.asList("A+","A-","B+","B-","AB+","AB-","O+","O-");
        List<Map<String,Long>> resultado = new ArrayList<>();

        tipos.stream().forEach(tipo -> {
            Map<String, Long> quantidadeReceptor = new HashMap<>();
            quantidadeReceptor.put(tipo.toString(), getQtdPossivelDoador(FactoryTipoReceptor.getTipos(tipo.toString())));
            resultado.add(quantidadeReceptor);
        });
        return resultado;
    }
    private Long getQtdPossivelDoador(List<String> tipos){
       return repository.getQtdPossivelDoador(tipos);
    }

}
