package br.com.acc.swat.reportplatform.controllers;

import br.com.acc.swat.reportplatform.entities.Conta;
import br.com.acc.swat.reportplatform.services.ContaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@RequestMapping(value = "/conta")
@Api(value = "Cadastro de contas")
@CrossOrigin(origins = "*")
public class ContaController {

    private final ContaService service;

    @GetMapping
    public ResponseEntity<List<Conta>> findAll(){
        List<Conta> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Conta> findById(@PathVariable Long id){
        Conta obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation(value = "Inserir conta")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "conta cadastrada"),
            @ApiResponse(code = 500, message = "Ocorreu um erro ao processar a requisição"),

    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Conta> inserir(@RequestBody Conta obj){
        obj = service.inserir(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        service.excluir(id);
        return  ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Conta> editar(@PathVariable Long id, @RequestBody Conta obj){
        obj = service.editar(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
