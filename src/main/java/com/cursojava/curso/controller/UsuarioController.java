package com.cursojava.curso.controller;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization") String token) {
        if (!validarToken(token)) { return null; }
        return usuarioDao.getUsuarios();
    }

    private boolean validarToken(String token) {
        String idUsuario = jwtUtil.getKey(token);
        return idUsuario != null;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1, usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.registrar(usuario);
    }

    /*@RequestMapping(value = "api/usuarios/modificar")
    public Usuario modifyUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Sergio");
        usuario.setApellido("Agudelo");
        usuario.setEmail("ofocacion.34");
        usuario.setTelefono("123");

        return usuario;
    }*/

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminarUsuario(@RequestHeader(value = "Authorization") String token, @PathVariable Long id) {
        if (!validarToken(token)) { return; }
        usuarioDao.eliminar(id);
    }

    /*@RequestMapping(value = "api/usuario/buscar")
    public Usuario buscarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Sergio");
        usuario.setApellido("Agudelo");
        usuario.setEmail("ofocacion.34");
        usuario.setTelefono("123");

        return usuario;
    }*/
}
