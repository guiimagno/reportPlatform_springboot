package br.com.acc.swat.reportplatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.MappedByteBuffer;
import java.util.List;

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

    @OneToMany(mappedBy = "conta")
    private List<Parcela> parcela;
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
