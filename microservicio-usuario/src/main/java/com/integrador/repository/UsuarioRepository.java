package com.integrador.repository;



import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.integrador.domain.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
//	
//	@Query( "SELECT e FROM Estudiante e  ORDER BY e.apellido ASC" )
//	List<Usuario>  estudiantesPorApellido();
//
//
//	@Query ("SELECT e FROM Estudiante e WHERE e.LU = :LU")
//	Optional<Estudiante> findByLibreta(int LU);
//
//
//	@Query ("SELECT e FROM Estudiante e WHERE e.genero = :genero")
//	List<Estudiante> findByGenero(String genero);

}
