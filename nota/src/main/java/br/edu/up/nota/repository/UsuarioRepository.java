package br.edu.up.nota.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.up.nota.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query(value ="SELECT * FROM usuario WHERE email =?1", nativeQuery = true)	
	Usuario getUsuarioByEmail(String email);
	
	@Query(value ="SELECT * FROM Usuario WHERE id =?", nativeQuery = true)
	List<Usuario> getAllById(int id);
	
}
