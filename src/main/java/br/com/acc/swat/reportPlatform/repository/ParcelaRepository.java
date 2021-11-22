package br.com.acc.swat.reportPlatform.repository;

import br.com.acc.swat.reportPlatform.model.Parcela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelaRepository extends JpaRepository<Parcela, Long> {
}
