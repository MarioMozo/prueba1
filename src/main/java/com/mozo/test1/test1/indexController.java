package com.mozo.test1.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mozo.models.app.Usuario;

@Controller

public class indexController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();

        usuario.setNombre("Mario Iván");
        usuario.setApellido("Martínez Mozo");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil de usuario: ".concat(usuario.getNombre()));
        return "perfil";

    }

    @RequestMapping("/lista/uno") // Forma de pasar datos por un ArrayList
    public String listar(Model model) {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Mario Ivan", "Martinez Mozo", "mario@correo.com"));
        usuarios.add(new Usuario("Diana", "Mozo", "diana@correo.com"));
        usuarios.add(new Usuario("Diego", "Martinez", "diego@correo.com"));
        model.addAttribute("titulo", "Listado de usuarios");
        model.addAttribute("usuarios", usuarios);
        return "listar";
    }

    @RequestMapping("/listarDos") // Forma de pasar datos con libreria Arrays.asList
    public String listarDos(Model model) {
        List<Usuario> usuarios = Arrays.asList
                (new Usuario("Mario Ivan", "Martinez Mozo", "mario@correo.com"),
                new Usuario("Usuario2", "apellido2", "correo2@correo.com"),
                new Usuario("usuario3", "apellido3", "correo3@correo.com"));
        model.addAttribute("titulo", "Lista Dos de usuarios");
        model.addAttribute("usuarios", usuarios);

        return "listarDos";

    }

}
