/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.muertelenta.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.muertelenta.entity.DistritoEntity;
import pe.com.muertelenta.repository.DistritoRepository;
import pe.com.muertelenta.service.DistritoService;

@Service
public class DistritoServiceImpl implements DistritoService {

    @Autowired
    private DistritoRepository repositorio;

    @Override
    public List<DistritoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<DistritoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public DistritoEntity findById(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public DistritoEntity add(DistritoEntity d) {
        return repositorio.save(d);
    }

    @Override
    public DistritoEntity update(DistritoEntity d) {
        DistritoEntity objDistrito = repositorio.getById(d.getCodigo());
        BeanUtils.copyProperties(d, objDistrito);
        return repositorio.save(objDistrito);
    }

    @Override
    public DistritoEntity delete(DistritoEntity d) {
        DistritoEntity objDistrito = repositorio.getById(d.getCodigo());
        objDistrito.setEstado(false);
        return repositorio.save(objDistrito);
    }

    @Override
    public DistritoEntity enable(DistritoEntity d) {
        DistritoEntity objDistrito = repositorio.getById(d.getCodigo());
        objDistrito.setEstado(true);
        return repositorio.save(objDistrito);
    }

}
