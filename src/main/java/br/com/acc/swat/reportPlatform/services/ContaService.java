package br.com.acc.swat.reportplatform.services;

import br.com.acc.swat.reportplatform.entities.Conta;
import br.com.acc.swat.reportplatform.entities.Parcela;
import br.com.acc.swat.reportplatform.repositories.ContaRepository;
import br.com.acc.swat.reportplatform.services.exceptions.DataBaseException;
import br.com.acc.swat.reportplatform.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;

    // LISTAR TODOS
    public List<Conta> findAll() {
        return (List<Conta>) repository.findAll();
    }

    public Conta findById(Long id) {
        Optional<Conta> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    // CADASTRAR CONTA E PARCELA - MENSAL/ANUAL
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

    // DELETAR CONTA POR ID
    public void excluir(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    // ATUALIZAR CONTA
    public Conta editar(Long id, Conta obj) {

        try {
            Conta conta = repository.getOne(id);
            updateData(conta, obj);
            return repository.save(conta);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
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
