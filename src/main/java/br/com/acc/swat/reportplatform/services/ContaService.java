package br.com.acc.swat.reportplatform.services;

import br.com.acc.swat.reportplatform.model.Conta;
import br.com.acc.swat.reportplatform.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;

    public List<Conta> findAll(){
        return repository.findAll();
    }

    public Conta findById(Long id){
        Optional<Conta> obj = repository.findById(id);
        return obj.get();
    }
}
