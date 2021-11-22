package br.com.senac.ads4n.reciclaRecife.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

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
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "tipo_compra_id")
    private TipoCompra tipoCompra;

    @ManyToOne
    @JoinColumn(name = "parcela_id")
    private Parcela parcela;

}
