package pe.com.muertelenta.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.muertelenta.entity.EmpleadoEntity;
import pe.com.muertelenta.repository.EmpleadoRepository;
import pe.com.muertelenta.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository repositorio;

    @Override
    public List<EmpleadoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<EmpleadoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public EmpleadoEntity findById(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public EmpleadoEntity add(EmpleadoEntity e) {
        return repositorio.save(e);
    }

    @Override
    public EmpleadoEntity update(EmpleadoEntity e) {
        EmpleadoEntity objEmpleado = repositorio.getById(e.getCodigo());
        BeanUtils.copyProperties(e, objEmpleado);
        return repositorio.save(objEmpleado);
    }

    @Override
    public EmpleadoEntity delete(EmpleadoEntity e) {
        EmpleadoEntity objEmpleado = repositorio.getById(e.getCodigo());
        objEmpleado.setEstado(false);
        return repositorio.save(objEmpleado);
    }

    @Override
    public EmpleadoEntity enable(EmpleadoEntity e) {
        EmpleadoEntity objEmpleado = repositorio.getById(e.getCodigo());
        objEmpleado.setEstado(true);
        return repositorio.save(objEmpleado);
    }

    @Override
    public EmpleadoEntity login(String usuario, String clave) {
        return repositorio.login(usuario, clave);
    }

}
