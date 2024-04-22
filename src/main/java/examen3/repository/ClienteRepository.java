package examen3.repository;

import examen3.entity.Cliente;
import examen3.entity.Factura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClienteRepository extends CrudRepository<Cliente,Long> {
    List<Cliente> findByNombreIs(String name);
}
