package br.com.acc.swat.reportplatform.repositories;

import br.com.acc.swat.reportplatform.entities.Conta;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends PagingAndSortingRepository<Conta, Long> {

    Conta getOne(Long id);

}
