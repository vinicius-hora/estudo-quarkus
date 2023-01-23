package org.acme.service;


import lombok.RequiredArgsConstructor;
import org.acme.dto.FuncionarioDto;
import org.acme.entity.Funcionario;
import org.acme.repository.FuncionarioRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped

public class FuncionarioService {

    @Inject
    private FuncionarioRepository funcionarioRepository;

    public void inserirFuncionario(FuncionarioDto funcionario){

        Funcionario novoFuncionario = new Funcionario();

        novoFuncionario.setNome(funcionario.getNome());
        novoFuncionario.setCpf(funcionario.getCpf());
        novoFuncionario.setIdade(funcionario.getIdade());
        novoFuncionario.setCargo(funcionario.getCargo());
        novoFuncionario.setCelular(funcionario.getCelular());
        novoFuncionario.setSalario(funcionario.getSalario());
        novoFuncionario.setSetor(funcionario.getSetor());

        funcionarioRepository.persist(novoFuncionario);
    }

    public List<FuncionarioDto> buscaFuncionario(){

        List<FuncionarioDto> listaFuncionario = new ArrayList<>();

        funcionarioRepository.findAll().list().forEach(item ->{
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
