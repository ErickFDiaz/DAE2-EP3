
package pe.com.muertelenta.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.muertelenta.entity.ClienteEntity;
import pe.com.muertelenta.repository.ClienteRepository;
import pe.com.muertelenta.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    private ClienteRepository repositorio;

    @Override
    public List<ClienteEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<ClienteEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public ClienteEntity findById(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public ClienteEntity add(ClienteEntity c) {
        return repositorio.save(c);
    }

    @Override
    public ClienteEntity update(ClienteEntity c) {
        ClienteEntity objCliente = repositorio.getById(c.getCodigo());
        BeanUtils.copyProperties(c, objCliente);
        return repositorio.save(objCliente);
    }

    @Override
    public ClienteEntity delete(ClienteEntity c) {
        ClienteEntity objCliente = repositorio.getById(c.getCodigo());
        objCliente.setEstado(false);
        return repositorio.save(objCliente);
    }

    @Override
    public ClienteEntity enable(ClienteEntity c) {
        ClienteEntity objCliente = repositorio.getById(c.getCodigo());
        objCliente.setEstado(true);
        return repositorio.save(objCliente);
    }
    
}
