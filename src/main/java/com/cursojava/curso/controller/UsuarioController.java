package com.cursojava.curso.controller;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios() {
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario) {
        usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "api/usuarios/modificar")
    public Usuario modifyUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Sergio");
        usuario.setApellido("Agudelo");
        usuario.setEmail("ofocacion.34");
        usuario.setTelefono("123");

        return usuario;
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void deleteUsuario(@PathVariable Long id) {
        usuarioDao.eliminar(id);
    }

    @RequestMapping(value = "api/usuario/buscar")
    public Usuario buscarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Sergio");
        usuario.setApellido("Agudelo");
        usuario.setEmail("ofocacion.34");
        usuario.setTelefono("123");

        return usuario;
    }
}
