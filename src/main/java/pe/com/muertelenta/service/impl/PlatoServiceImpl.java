package pe.com.muertelenta.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.muertelenta.entity.PlatoEntity;
import pe.com.muertelenta.repository.PlatoRepository;
import pe.com.muertelenta.service.PlatoService;

@Service
public class PlatoServiceImpl implements PlatoService {

    @Autowired
    private PlatoRepository repositorio;

    @Override
    public List<PlatoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<PlatoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public PlatoEntity findById(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public PlatoEntity add(PlatoEntity p) {
        return repositorio.save(p);
    }

    @Override
    public PlatoEntity update(PlatoEntity p) {
        PlatoEntity objplato = repositorio.getById(p.getCodigo());
        BeanUtils.copyProperties(p, objplato);
        return repositorio.save(objplato);
    }

    @Override
    public PlatoEntity delete(PlatoEntity p) {
        PlatoEntity objplato = repositorio.getById(p.getCodigo());
        objplato.setEstado(false);
        return repositorio.save(objplato);
    }

    @Override
    public PlatoEntity enable(PlatoEntity p) {
        PlatoEntity objplato = repositorio.getById(p.getCodigo());
        objplato.setEstado(true);
        return repositorio.save(objplato);
    }

}
