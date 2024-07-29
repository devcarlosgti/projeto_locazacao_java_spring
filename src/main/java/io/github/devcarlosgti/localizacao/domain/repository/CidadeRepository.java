package io.github.devcarlosgti.localizacao.domain.repository;

import io.github.devcarlosgti.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    //busca pelo nome correto
    List<Cidade> findByNome(String nome);

    //busca pelo nome por todas as forma de busca
    @Query(" select c from Cidade c where upper(c.nome) like upper(?1) ")
    List<Cidade> findByNomeLike(String nome);
    //Lower - converte todas as letras maiúsculas em minúsculas.
    //Upper - converte todas as letras minúsculas em maiúsculas.
    //Proper - converte a primeira letra de cada palavra em maiúscula se for minúscula,
    // e converte todas as outras letras maiúsculas em minúsculas.

//    //busca pelo nome começando por aquele pedaço
//    List<Cidade> findByNomeStartingWith(String nome);
//
//    //busca pelo nome terminando por aquele pedaço
//    List<Cidade> findByNomeEndingWith(String nome);
//
//    //busca pelo nome contendo aquele pedaço
//    List<Cidade> findByNomeContaining(String nome);

    List<Cidade> findByHabitantes(Long habitantes);

}
