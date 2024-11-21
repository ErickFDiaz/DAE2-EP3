package pe.com.muertelenta.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.muertelenta.entity.RolEntity;
import pe.com.muertelenta.repository.generic.GenericoRepositorio;

@Repository
public interface RolRepository extends GenericoRepositorio<RolEntity, Long> {

    @Query("select r from RolEntity r where r.estado=true")
    List<RolEntity> findAllCustom();
}
