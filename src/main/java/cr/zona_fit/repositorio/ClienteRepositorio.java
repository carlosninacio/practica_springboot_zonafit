package cr.zona_fit.repositorio;

import cr.zona_fit.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

// Tipo de la clase y el tipo de la llave primaria
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

}