package pe.com.muertelenta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.muertelenta.entity.RolEntity;
import pe.com.muertelenta.service.RolService;

@Controller
public class RolController {

    // Inyección de dependencias
    @Autowired
    private RolService servicio;

    // Rutas --> @GetMapping
    @GetMapping("/rol/listar")
    public String mostrarListarRol(Model modelo) {
        modelo.addAttribute("listaRoles", servicio.findAllCustom());
        return "rol/listar_rol";
    }

    @GetMapping("/rol/registro")
    public String mostrarRegistroRol() {
        return "rol/registrar_rol";
    }

    @GetMapping("/rol/actualiza/{id}")
    public String mostrarActualizaRol(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("rol", servicio.findById(id));
        return "rol/actualizar_rol";
    }

    @GetMapping("/rol/eliminar/{id}")
    public String eliminarRol(@PathVariable Long id) {
        RolEntity objRol = new RolEntity();
        objRol.setCodigo(id);
        servicio.delete(objRol);
        return "redirect:/rol/listar";
    }

    @GetMapping("/rol/habilita")
    public String mostrarHabilitaRol(Model modelo) {
        modelo.addAttribute("listaRoles", servicio.findAll());
        return "rol/habilitar_rol";
    }

    @GetMapping("/rol/habilitar/{id}")
    public String habilitarRol(@PathVariable Long id) {
        RolEntity objRol = new RolEntity();
        objRol.setCodigo(id);
        servicio.enable(objRol);
        return "redirect:/rol/habilita";
    }

    @GetMapping("/rol/deshabilitar/{id}")
    public String deshabilitarRol(@PathVariable Long id) {
        RolEntity objRol = new RolEntity();
        objRol.setCodigo(id);
        servicio.delete(objRol);
        return "redirect:/rol/habilita";
    }

    // Modelo
    @ModelAttribute("rol")
    public RolEntity modeloRol() {
        return new RolEntity();
    }

    // Acciones
    @PostMapping("/rol/registrar")
    public String registrarRol(@ModelAttribute("rol") RolEntity rol) {
        servicio.add(rol);
        return "redirect:/rol/listar";
    }

    @PostMapping("/rol/actualizar/{id}")
    public String actualizarRol(@PathVariable Long id, @ModelAttribute("rol") RolEntity rol) {
        rol.setCodigo(id);
        servicio.update(rol);
        return "redirect:/rol/listar";
    }
}
