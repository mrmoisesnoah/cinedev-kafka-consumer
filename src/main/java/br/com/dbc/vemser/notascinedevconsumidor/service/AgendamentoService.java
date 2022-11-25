package br.com.dbc.vemser.notascinedevconsumidor.service;

import br.com.dbc.vemser.notascinedevconsumidor.entity.NotaEntity;
import br.com.dbc.vemser.notascinedevconsumidor.repository.NotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
//@EnableScheduling
@RequiredArgsConstructor
public class AgendamentoService {
private final EmailService emailService;
private final NotaRepository notaRepository;
    @Scheduled(cron ="0 0 18 * * *")
    public void enviarEmailNotaFiscal(){
        List<NotaEntity> notas = notaRepository.findAllByDataBetween(LocalDateTime.now().minusHours(24), LocalDateTime.now());
        NotaEntity notaFinal = new NotaEntity();
        Double precoFinal = 0.0;
        Integer quantidadeFinal = 0;
        for(int i = 0; i < notas.size(); i++){
            precoFinal += notas.get(i).getPreco();
            quantidadeFinal += notas.get(i).getQuantidade();
        }
        notaFinal.setPreco(precoFinal);
        notaFinal.setQuantidade(quantidadeFinal);
        emailService.sendEmail(notaFinal);
        notas.stream().forEach(System.out::println);
        System.out.println("Julio é lindo");
    }

}
