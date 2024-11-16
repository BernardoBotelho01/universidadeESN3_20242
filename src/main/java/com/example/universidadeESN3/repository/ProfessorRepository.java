package com.example.universidadeESN3.repository;

import com.example.universidadeESN3.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    List<Professor> findByNome(String nome);

    List<Professor> findByNomeStartingWith(String nome);

//    @Query(value = "SELECT a FROM Aluno a WHERE a.nome LIKE :nome%", nativeQuery = true)
//    List<Aluno> findByNomeStartingWith(@Param("nome") String nome);

    @Query(value = "SELECT * FROM aluno a WHERE LOWER(a.nome) LIKE LOWER(CONCAT(:nome, '%'))", nativeQuery = true)
    List<Professor> findByNomeStartingWithIgnoreCase(@Param("nome") String nome);

}
