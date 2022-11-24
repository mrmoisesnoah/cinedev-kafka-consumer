package br.com.dbc.vemser.notascinedevconsumidor.service;

import br.com.dbc.vemser.notascinedevconsumidor.entity.NotaEntity;
import br.com.dbc.vemser.notascinedevconsumidor.repository.NotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
//@EnableScheduling
@RequiredArgsConstructor
public class AgendamentoService {
private final EmailService emailService;
private final NotaRepository notaRepository;
 @Scheduled(cron ="0 43 16 * * *")
         public void enviarEmailNotaFiscal(){
     List<NotaEntity> notas = new ArrayList<>();
     for(notaRepository.findAll(): notas){

     }
         emailService.sendEmail();
     System.out.println("Julio é lindo");
    }

}
