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

    public Conta inserir(Conta obj){
        return repository.save(obj);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }

    public Conta editar(Long id, Conta obj){
        Conta conta = repository.getOne(id);
        updateData(conta, obj);
        return repository.save(conta);
    }

    private void updateData(Conta conta, Conta obj) {
        conta.setDescricao(obj.getDescricao());
    }
}
