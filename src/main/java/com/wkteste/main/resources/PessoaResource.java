package com.wkteste.main.resources;

import com.wkteste.main.models.dtos.PessoaDTO;
import com.wkteste.main.services.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class PessoaResource {

    private final PessoaService service;

    @PostMapping("/inserir_pessoa")
    ResponseEntity<?> savePessoa(@RequestBody PessoaDTO pessoa){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.savePessoa(pessoa));
    }

    @PostMapping("inserir_lista_pessoas")
    ResponseEntity<?> saveAllPessoa(@RequestBody List<PessoaDTO> pessoa){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.saveAllPessoas(pessoa));
    }
    @GetMapping("/busca_por_estado/")
    ResponseEntity<?> buscaQtdPorEstado(){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.qtdPessoaPorEstado());
    }

    @GetMapping("/busca_doadores/")
    ResponseEntity<?> buscaDoadores(){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.buscarDoadores());
    }

    @GetMapping("/quantidade_doadores_receptor/")
    ResponseEntity<?> qtdDoadorReceptor(){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.qtdDoadorTipoReceptor());
    }

}
