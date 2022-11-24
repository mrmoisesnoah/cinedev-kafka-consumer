package br.com.dbc.vemser.notascinedevconsumidor.repository;

import br.com.dbc.vemser.notascinedevconsumidor.entity.NotaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NotaRepository extends MongoRepository<NotaEntity, String> {

  public List<NotaEntity> findAllByDataBetween(LocalDateTime dataInit, LocalDateTime dataFinal);
}
