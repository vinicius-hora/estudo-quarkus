package com.empresa.api.service;

import com.empresa.api.dto.FuncionarioDto;
import com.empresa.api.entity.Funcionario;
import com.empresa.api.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public void inserirFuncionario(FuncionarioDto funcionario){

        Funcionario novoFuncionario = new Funcionario();

        novoFuncionario.setNome(funcionario.getNome());
        novoFuncionario.setCpf(funcionario.getCpf());
        novoFuncionario.setIdade(funcionario.getIdade());
        novoFuncionario.setCargo(funcionario.getCargo());
        novoFuncionario.setCelular(funcionario.getCelular());
        novoFuncionario.setSalario(funcionario.getSalario());
        novoFuncionario.setSetor(funcionario.getSetor());

        funcionarioRepository.save(novoFuncionario);
    }

    public List<FuncionarioDto> buscaFuncionario(){

        List<FuncionarioDto> listaFuncionario = new ArrayList<>();

        funcionarioRepository.findAll().forEach(item ->{
            FuncionarioDto funcionario = FuncionarioDto.builder()
                    .nome(item.getNome())
                    .cargo(item.getCargo())
                    .setor(item.getSetor())
                    .celular(item.getCelular())
                    .cpf(item.getCpf())
                    .idade(item.getIdade())
                    .salario(item.getSalario())
                    .build();

            listaFuncionario.add(funcionario);
        });

        return listaFuncionario;

    }
}
