package br.com.acc.swat.reportplatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "tipo_compra_id")
    private TipoCompra tipoCompra;

    @ManyToOne
    @JoinColumn(name = "parcela_id")
    private Parcela parcela;

}
