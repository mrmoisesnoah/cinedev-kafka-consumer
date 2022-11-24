package br.com.dbc.vemser.notascinedevconsumidor.service;

import br.com.dbc.vemser.notascinedevconsumidor.entity.NotaEntity;
import br.com.dbc.vemser.notascinedevconsumidor.repository.NotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
//@EnableScheduling
@RequiredArgsConstructor
public class AgendamentoService {
private final EmailService emailService;
private final NotaRepository notaRepository;
 @Scheduled(cron ="0 43 17 * * *")
         public void enviarEmailNotaFiscal(){
     List<NotaEntity> notas = notaRepository.findAllByDataBetween(LocalDateTime.now().minusHours(24), LocalDateTime.now());
     emailService.sendEmail(notas);
     notas.stream().forEach(System.out::println);
     System.out.println("Julio é lindo");
 }

}
