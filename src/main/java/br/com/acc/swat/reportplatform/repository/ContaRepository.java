package br.com.acc.swat.reportplatform.repository;

import br.com.acc.swat.reportplatform.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

}
