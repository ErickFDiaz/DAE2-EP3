package pe.com.muertelenta.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.muertelenta.entity.ClienteEntity;
import pe.com.muertelenta.repository.generic.GenericoRepositorio;

@Repository
public interface ClienteRepository extends GenericoRepositorio<ClienteEntity, Long>{
        
    @Query("select c from ClienteEntity c where c.estado=true")
    List<ClienteEntity> findAllCustom();
}
