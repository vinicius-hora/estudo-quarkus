package com.empresa.api.controller;

import com.empresa.api.dto.FuncionarioDto;
import com.empresa.api.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
@RequiredArgsConstructor
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    @GetMapping("/lista")
    public ResponseEntity<List<FuncionarioDto>> buscaFuncionarios(){
        return new ResponseEntity<>(funcionarioService.buscaFuncionario(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity criarFuncionario(@RequestBody FuncionarioDto funcionario){
        try{
            funcionarioService.inserirFuncionario(funcionario);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
