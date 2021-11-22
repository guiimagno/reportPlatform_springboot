package br.com.senac.ads4n.reciclaRecife.repository;

import br.com.senac.ads4n.reciclaRecife.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

}
