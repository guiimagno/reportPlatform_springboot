package br.com.acc.swat.reportplatform.resources;

import br.com.acc.swat.reportplatform.entities.Conta;
import br.com.acc.swat.reportplatform.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/conta")
public class ContaResource {

    @Autowired
    private ContaService service;

    @GetMapping
    public ResponseEntity<Iterable<Conta>> findList() {
        Iterable<Conta> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Conta> findById(@PathVariable Long id) {
        Conta obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

//    @GetMapping
//    public ResponseEntity<Page<Conta>> findPageable(Pageable p) {
//        return ResponseEntity.ok(service.findAll(p));
//    }

    @PostMapping
    public ResponseEntity<Conta> inserir(@RequestBody Conta obj) {
        obj = service.inserir(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Conta> editar(@PathVariable Long id, @RequestBody Conta obj) {
        obj = service.editar(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
