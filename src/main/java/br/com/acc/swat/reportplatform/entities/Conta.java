package br.com.acc.swat.reportplatform.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "tb_conta")
public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conta_id")
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor_produto")
    private Double valorProduto;

    @Column(name = "tipo_compra")
    @Enumerated
    private TipoCompra tipoCompra;

    @Column(name = "qtd_parcelas")
    private int qtdParcelas;

    @JsonIgnore
    @OneToMany(mappedBy = "contas", cascade = CascadeType.ALL)
    private List<Parcela> parcela;

//    @Column(name = "valor_total")
//    private Double valorTotal;

    @Column(name = "data")
    private LocalDate data;

}