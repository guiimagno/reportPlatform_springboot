package br.com.acc.swat.reportplatform.config;

import br.com.acc.swat.reportplatform.model.Conta;
import br.com.acc.swat.reportplatform.model.OpcoesConta;
import br.com.acc.swat.reportplatform.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ContaRepository contaRepository;

    @Override
    public void run(String... args) throws Exception {

        Conta c1 = new Conta(null, "iphone12", 3200.0, OpcoesConta.MENSAL);
        Conta c2 = new Conta(null, "hotel", 450.5, OpcoesConta.UNICA);
        Conta c3 = new Conta(null, "netflix", 45.9, OpcoesConta.MENSAL);
        Conta c4 = new Conta(null, "OAB", 999.9, OpcoesConta.ANUAL);

//        Pedido p1 = new Pedido();



        contaRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
//        pedidoRepository.saveAll(Arrays.asList(p1));
    }
}
