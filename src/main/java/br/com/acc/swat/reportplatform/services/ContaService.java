package br.com.acc.swat.reportplatform.services;

import br.com.acc.swat.reportplatform.entities.Conta;
import br.com.acc.swat.reportplatform.entities.Parcela;
import br.com.acc.swat.reportplatform.repositories.ContaRepository;
import br.com.acc.swat.reportplatform.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;

//    public Page<Conta> findPageable(Pageable pageable) {
//        return repository.findAll(pageable);
//    }

    public Iterable<Conta> findAll() {
        return repository.findAll();
    }

    public Conta findById(Long id) {
        Optional<Conta> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Conta inserir(Conta obj) {

        double valorParcela = obj.getValorProduto() / obj.getQtdParcelas();

        if (obj.getTipoCompra().getCodigo() == 1) {
            if (obj.getQtdParcelas() > 0) {
                List<Parcela> list = new ArrayList<>();

                for (int i = 1; i <= obj.getQtdParcelas(); i++) {
                    Parcela p = new Parcela();
                    p.setDataParcela(LocalDate.now().plusMonths(Long.parseLong(String.valueOf(i))));
                    p.setNumParcela(i);
                    p.setValorParcela(valorParcela);
                    p.setContas(obj);
                    list.add(p);
                }

                obj.setParcela(list);
            }


        } else if (obj.getTipoCompra().getCodigo() == 2) {

            List<Parcela> list1 = new ArrayList<>();

            for (int i = 1; i <= obj.getQtdParcelas(); i++) {
                Parcela p = new Parcela();
                p.setDataParcela(LocalDate.now().plusYears(Long.parseLong(String.valueOf(i))));
                p.setNumParcela(i);
                p.setValorParcela(valorParcela);
                p.setContas(obj);
                list1.add(p);

            }
            obj.setParcela(list1);
        }

        obj.setData(LocalDate.now());
        return repository.save(obj);
    }


    public void excluir(Long id) {
        repository.deleteById(id);
    }


    public Conta editar(Long id, Conta obj) {
        Conta conta = repository.getOne(id);
        updateData(conta, obj);
        return repository.save(conta);
    }

    private void updateData(Conta conta, Conta obj) {

        List<Parcela> list2 = new ArrayList<>();

        conta.setDescricao(obj.getDescricao());
        conta.setValorProduto(obj.getValorProduto());
        conta.setTipoCompra(obj.getTipoCompra());
        conta.setQtdParcelas(obj.getQtdParcelas());
        Parcela p = new Parcela();
        p.setNumParcela(p.getNumParcela());
        p.setContas(obj);
        list2.add(p);
        obj.setParcela(list2);
    }

}
