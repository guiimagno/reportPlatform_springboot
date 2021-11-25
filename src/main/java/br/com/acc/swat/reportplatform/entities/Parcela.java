package br.com.acc.swat.reportplatform.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_parcela")
public class Parcela implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parcela_id")
    private Long id;

    @Column(name = "data_parcela")
    private LocalDate dataParcela;

    @Column(name = "numero_parcelas")
    private int numParcela;

    @Column(name = "valor_parcela")
    private Double valorParcela;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta contas;
}
