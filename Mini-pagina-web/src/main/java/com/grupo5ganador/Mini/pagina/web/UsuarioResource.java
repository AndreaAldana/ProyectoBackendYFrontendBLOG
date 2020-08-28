package com.grupo5ganador.Mini.pagina.web;


import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

@RequestMapping("/api")
public class UsuarioResource {


    @RequestMapping(method = RequestMethod.GET, value = "/usuario/{rut}")
    public List<Usuario> getDatosUsuario(@PathVariable("rut") String rut)
            throws SQLException {
        List<Usuario> usu = new UsuarioDAO()
                .obtenerDatosPorRut(rut);
        return usu;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/crear")
    public void crearUsuario(@RequestBody Usuario p) throws SQLException {
        new UsuarioDAO().crearUsuario(p);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/usuario/borrar/{rut}")
    public void borrarUsuario (@PathVariable("rut") String rut) throws SQLException {
        new UsuarioDAO().borrarUser(rut);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/usuario/tabla")
    public List<Usuario> getUsuarios () throws SQLException {
        List<Usuario> user = new UsuarioDAO().obtenerUsuarios();
        return user;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/loginUsuario/")
    public Usuario loginUsuario(@RequestBody Usuario usuarios) throws Exception {
        return UsuarioDAO.loginUsuario(usuarios);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/usuario/editar/")
    public Usuario modificarUsuario(@RequestBody Usuario a) throws SQLException {
        return UsuarioDAO.modificar(a);
    }


}
