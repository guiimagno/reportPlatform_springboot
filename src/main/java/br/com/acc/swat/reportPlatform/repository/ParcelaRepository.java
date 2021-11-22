package br.com.senac.ads4n.reciclaRecife.repository;

import br.com.senac.ads4n.reciclaRecife.model.Parcela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelaRepository extends JpaRepository<Parcela, Long> {
}
