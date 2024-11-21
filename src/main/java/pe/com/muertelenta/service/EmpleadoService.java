package pe.com.muertelenta.service;

import pe.com.muertelenta.entity.EmpleadoEntity;
import pe.com.muertelenta.service.generic.GenericoService;

public interface EmpleadoService extends GenericoService<EmpleadoEntity>{

    EmpleadoEntity login(String usuario, String clave);
}
