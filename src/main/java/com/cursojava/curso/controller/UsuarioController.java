package com.cursojava.curso.controller;

import com.cursojava.curso.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios() {
        List<Usuario> userList = new ArrayList<Usuario>();

        Usuario usuario = new Usuario();
        usuario.setId(01L);
        usuario.setNombre("Sergio");
        usuario.setApellido("Agudelo");
        usuario.setEmail("ofocacion.34");
        usuario.setTelefono("123");

        Usuario usuario2 = new Usuario();
        usuario2.setId(02L);
        usuario2.setNombre("andres");
        usuario2.setApellido("rendon");
        usuario2.setEmail("andres.85");
        usuario2.setTelefono("321");

        Usuario usuario3 = new Usuario();
        usuario3.setId(03L);
        usuario3.setNombre("juanito");
        usuario3.setApellido("perez");
        usuario3.setEmail("juanito.66");
        usuario3.setTelefono("8523");

        userList.add(usuario);
        userList.add(usuario2);
        userList.add(usuario3);
        return userList;
    }

    @RequestMapping(value = "usuario/modificar")
    public Usuario modifyUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Sergio");
        usuario.setApellido("Agudelo");
        usuario.setEmail("ofocacion.34");
        usuario.setTelefono("123");

        return usuario;
    }

    @RequestMapping(value = "usuario/eliminar")
    public Usuario deleteUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Sergio");
        usuario.setApellido("Agudelo");
        usuario.setEmail("ofocacion.34");
        usuario.setTelefono("123");

        return usuario;
    }

    @RequestMapping(value = "usuario/buscar")
    public Usuario buscarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Sergio");
        usuario.setApellido("Agudelo");
        usuario.setEmail("ofocacion.34");
        usuario.setTelefono("123");

        return usuario;
    }
}
