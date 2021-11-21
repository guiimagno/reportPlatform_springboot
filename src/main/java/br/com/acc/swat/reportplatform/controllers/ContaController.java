package br.com.acc.swat.reportplatform.controllers;

import br.com.acc.swat.reportplatform.model.Conta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/conta")
public class ContaController {

    @GetMapping
    public ResponseEntity<Conta> findAll(){
        Conta c = new Conta();
        return ResponseEntity.ok().body(c);
    }
}
