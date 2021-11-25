package br.com.acc.swat.reportPlatform.repository;

import br.com.acc.swat.reportPlatform.model.TipoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCompraRepository extends JpaRepository<TipoCompra, Long> {
}
