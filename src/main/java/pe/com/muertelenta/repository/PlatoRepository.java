package pe.com.muertelenta.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import pe.com.muertelenta.entity.PlatoEntity;
import pe.com.muertelenta.repository.generic.GenericoRepositorio;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepository extends GenericoRepositorio<PlatoEntity, Long>{
        
    @Query("select p from PlatoEntity p where p.estado=true")
    List<PlatoEntity> findAllCustom();
}