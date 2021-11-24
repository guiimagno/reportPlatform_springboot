//package br.com.acc.swat.reportplatform.services;
//
//import br.com.acc.swat.reportplatform.model.Parcela;
//import br.com.acc.swat.reportplatform.repository.ParcelaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ParcelaService {
//
//    @Autowired
//    private ParcelaRepository repository;
//
//    public List<Parcela> findAll(){
//        return repository.findAll();
//    }
//
//    public Parcela findById(Long id){
//        Optional<Parcela> obj = repository.findById(id);
//        return obj.get();
//    }
//
//    public Parcela inserir(Parcela obj){
//        return repository.save(obj);
//    }
//
//    public void excluir(Long id){
//        repository.deleteById(id);
//    }

//    public Parcela editar(Long id, Parcela obj){
//        Parcela parcela = repository.getOne(id);
//        updateData(parcela, obj);
//        return repository.save(parcela);
//    }

//    private void updateData(Parcela conta, Parcela obj) {
//        conta.setDescricao(obj.getDescricao());
//    }

