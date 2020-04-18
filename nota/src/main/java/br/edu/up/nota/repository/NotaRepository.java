package br.edu.up.nota.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.up.nota.entity.Nota;

public interface NotaRepository extends JpaRepository<Nota, Integer> {
	@Query(value ="SELECT * FROM Nota WHERE valor =?", nativeQuery = true)	
	List<Nota> getAllByValor(double valor);
}
