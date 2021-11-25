package br.com.acc.swat.reportPlatform.repository;

import br.com.acc.swat.reportPlatform.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

}
