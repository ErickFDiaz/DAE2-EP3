package pe.com.muertelenta.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.muertelenta.entity.RolEntity;

import pe.com.muertelenta.repository.RolRepository;

import pe.com.muertelenta.service.RolService;

@Service
public class RolServiceImpl implements RolService{
    //inyeccion de dependencia
    @Autowired
    private RolRepository repositorio;

    @Override
    public List<RolEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<RolEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public RolEntity findById(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public RolEntity add(RolEntity r) {
        return repositorio.save(r);
    }

    @Override
    public RolEntity update(RolEntity r) {
        RolEntity objRol = repositorio.getById(r.getCodigo());
        BeanUtils.copyProperties(r, objRol);
        return repositorio.save(objRol);
    }

    @Override
    public RolEntity delete(RolEntity r) {
        RolEntity objRol = repositorio.getById(r.getCodigo());
        objRol.setEstado(false);
        return repositorio.save(objRol);
    }

    @Override
    public RolEntity enable(RolEntity r) {
        RolEntity objRol = repositorio.getById(r.getCodigo());
        objRol.setEstado(true);
        return repositorio.save(objRol);
    }
}
