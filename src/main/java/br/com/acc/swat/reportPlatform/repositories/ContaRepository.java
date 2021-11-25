package br.com.acc.swat.reportplatform.repositories;

import br.com.acc.swat.reportplatform.entities.Conta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends PagingAndSortingRepository<Conta, Long> {

//    Page<Conta> findPageable(Pageable pageable);

    Conta getOne(Long id);
}
