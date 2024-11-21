package pe.com.muertelenta.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.com.muertelenta.entity.EmpleadoEntity;
import pe.com.muertelenta.repository.generic.GenericoRepositorio;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends GenericoRepositorio<EmpleadoEntity, Long> {

    @Query("select e from EmpleadoEntity e where e.usuario= :usuario and e.clave= :clave")
    EmpleadoEntity login(@Param("usuario") String usuario, @Param("clave") String clave);

    @Query("select e from EmpleadoEntity e where e.estado=true")
    List<EmpleadoEntity> findAllCustom();

}
