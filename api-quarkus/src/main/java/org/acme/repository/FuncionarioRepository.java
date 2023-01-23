package org.acme.repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.Funcionario;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FuncionarioRepository implements PanacheRepository<Funcionario> {
}
