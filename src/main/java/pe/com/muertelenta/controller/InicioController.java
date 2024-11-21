package pe.com.muertelenta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pe.com.muertelenta.entity.EmpleadoEntity;

@Controller
public class InicioController {

    @ModelAttribute("empleado")
    public EmpleadoEntity Modeloempleado() {
        return new EmpleadoEntity();
    }

    //manejar rutas
    //@GetMapping permiten manejar turas
    @GetMapping
    public String MostrarIndex() {
        return "index";
    }

    @GetMapping("/menuprincipal")
    public String MostrarMenuPrincipal() {
        return "menuprincipal";
    }

}
