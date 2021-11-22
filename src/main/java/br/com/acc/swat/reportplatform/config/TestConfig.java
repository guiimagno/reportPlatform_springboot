//package br.com.acc.swat.reportplatform.config;
//
//import br.com.acc.swat.reportplatform.model.Conta;
//import br.com.acc.swat.reportplatform.model.Parcela;
//import br.com.acc.swat.reportplatform.model.TipoCompra;
//import br.com.acc.swat.reportplatform.repository.ContaRepository;
//import br.com.acc.swat.reportplatform.repository.ParcelaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//import java.time.Instant;
//import java.util.Arrays;
//
//@Configuration
//@Profile("test")
//public class TestConfig implements CommandLineRunner {
//
//    @Autowired
//    private ContaRepository contaRepository;
//
//    @Autowired
//    private ParcelaRepository parcelaRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        Conta c1 = new Conta(null, "iphone12",  ,300.0, TipoCompra.MENSAL, 1212.22);
//
//        Parcela p1 = new Parcela(null, 1, Instant.parse("2019-06-20T19:53:07Z"), c1);
//
//        contaRepository.saveAll(Arrays.asList(c1));
//        parcelaRepository.saveAll(Arrays.asList(p1));
//    }
//}
