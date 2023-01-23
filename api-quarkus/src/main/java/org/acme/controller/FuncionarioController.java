package org.acme.controller;

import lombok.RequiredArgsConstructor;
import org.acme.dto.FuncionarioDto;
import org.acme.service.FuncionarioService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/funcionario")
public class FuncionarioController {
    @Inject
    private FuncionarioService funcionarioService;

    @GET
    @Path("/lista")
    public Response buscaFuncionarios(){
        return Response.ok(funcionarioService.buscaFuncionario()).build();
    }

    @POST
    @Transactional
    public Response criarFuncionario(FuncionarioDto funcionario){
        try{
            funcionarioService.inserirFuncionario(funcionario);
            return Response.ok().build();
        } catch (Exception e){
            return Response.serverError().build();
        }
    }
}
