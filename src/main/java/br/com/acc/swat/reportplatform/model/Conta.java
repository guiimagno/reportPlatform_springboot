package br.com.acc.swat.reportplatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private BigDecimal valorProduto;

    @Transient
    private Parcela parcela;

    @Enumerated
    @Column(name = "tipo_conta")
    private TipoCompra tipoCompra;

    private BigDecimal total;

//    public Double subTotal() {
//
//    }
//
//    public Double getTotal(){
//        double soma = 0.0;
//        for(Conta x : itens){
//            soma += x.getSubtotal();
//        }
//        return soma;
//    }


}
