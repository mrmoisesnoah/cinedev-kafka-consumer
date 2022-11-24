package br.com.dbc.vemser.notascinedevconsumidor.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "nf")
public class NotaEntity {
        @Id
        private String id;
        Integer idIngresso;
        String nomeFilme;
        String nomeCliente;
        String cpf;
        String nomeCinema;
        Double preco;
        Integer quantidade;
        LocalDateTime data;

}
