package br.com.acc.swat.reportplatform.repositories;

import br.com.acc.swat.reportplatform.entities.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
