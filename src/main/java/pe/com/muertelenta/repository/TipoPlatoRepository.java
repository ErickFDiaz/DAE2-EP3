package pe.com.muertelenta.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.muertelenta.entity.TipoPlatoEntity;
import pe.com.muertelenta.repository.generic.GenericoRepositorio;

@Repository
public interface TipoPlatoRepository extends GenericoRepositorio<TipoPlatoEntity, Long>{

    @Query("select tp from TipoPlatoEntity tp where tp.estado=true")
    List<TipoPlatoEntity> findAllCustom();
}