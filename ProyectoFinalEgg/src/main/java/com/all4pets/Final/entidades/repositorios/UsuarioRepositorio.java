package com.all4pets.Final.entidades.repositorios;

import com.all4pets.Final.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {

    @Query("SELECT a FROM Usuario a WHERE a.email = :email")
    public Usuario buscarPorEmail(@Param("email") String email);

}