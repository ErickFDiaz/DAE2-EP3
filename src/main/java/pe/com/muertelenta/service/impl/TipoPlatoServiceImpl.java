package pe.com.muertelenta.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.muertelenta.entity.TipoPlatoEntity;
import pe.com.muertelenta.repository.TipoPlatoRepository;
import pe.com.muertelenta.service.TipoPlatoService;

@Service
public class TipoPlatoServiceImpl implements TipoPlatoService {

    //inyeccion de dependencia
    @Autowired
    private TipoPlatoRepository repositorio;

    @Override
    public List<TipoPlatoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<TipoPlatoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public TipoPlatoEntity findById(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public TipoPlatoEntity add(TipoPlatoEntity tp) {
        return repositorio.save(tp);
    }

    @Override
    public TipoPlatoEntity update(TipoPlatoEntity tp) {
        TipoPlatoEntity objtipoplato = repositorio.getById(tp.getCodigo());
        BeanUtils.copyProperties(tp, objtipoplato);
        return repositorio.save(objtipoplato);
    }

    @Override
    public TipoPlatoEntity delete(TipoPlatoEntity tp) {
        TipoPlatoEntity objtipoplato = repositorio.getById(tp.getCodigo());
        objtipoplato.setEstado(false);
        return repositorio.save(objtipoplato);
    }

    @Override
    public TipoPlatoEntity enable(TipoPlatoEntity tp) {
        TipoPlatoEntity objtipoplato = repositorio.getById(tp.getCodigo());
        objtipoplato.setEstado(true);
        return repositorio.save(objtipoplato);
    }

}
