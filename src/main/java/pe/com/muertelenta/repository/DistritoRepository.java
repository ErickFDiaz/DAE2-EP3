package pe.com.muertelenta.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.muertelenta.entity.DistritoEntity;
import pe.com.muertelenta.repository.generic.GenericoRepositorio;

@Repository
public interface DistritoRepository extends GenericoRepositorio<DistritoEntity, Long> {

    @Query("select d from DistritoEntity d where d.estado = true")
    List<DistritoEntity> findAllCustom();
}
