package examen3.repository;

import examen3.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FacturaRepository extends CrudRepository<Factura,Long> {
List<Factura> findByCantidadGreaterThan(Integer cantidad);
}