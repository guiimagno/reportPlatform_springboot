package br.com.acc.swat.reportplatform.repository;

import br.com.acc.swat.reportplatform.model.TipoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCompraRepository extends JpaRepository<TipoCompra, Long> {
}
