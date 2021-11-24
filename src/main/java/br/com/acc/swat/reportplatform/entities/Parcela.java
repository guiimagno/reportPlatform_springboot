package br.com.acc.swat.reportplatform.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
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


//    private List<String> datas = new ArrayList<>();
//
//    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
//
//    public void validacaoTempo() {
//        Calendar c = Calendar.getInstance();
//        c.setTime(dataParcela);
//        for (int i = 1; i < numParcela; i++) {
//            c.add(Calendar.MONTH, i);
//            Date data = c.getTime();
//            String dataFotmatada = sdf.format(data);
//            datas.add(dataFotmatada);
//        }
//    }
