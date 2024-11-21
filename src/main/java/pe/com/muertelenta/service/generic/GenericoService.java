package pe.com.muertelenta.service.generic;

import java.util.List;

public interface GenericoService<T> {

    List<T> findAll();

    List<T> findAllCustom();

    T findById(Long id);

    T add(T p);

    T update(T p);

    T delete(T p);

    T enable(T p);
}
