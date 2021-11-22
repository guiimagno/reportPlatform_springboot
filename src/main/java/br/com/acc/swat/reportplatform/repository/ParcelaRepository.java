package br.com.acc.swat.reportplatform.repository;

import br.com.acc.swat.reportplatform.model.Parcela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ParcelaRepository extends JpaRepository<Parcela, Long> {
}
