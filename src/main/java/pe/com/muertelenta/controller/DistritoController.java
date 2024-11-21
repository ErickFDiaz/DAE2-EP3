package pe.com.muertelenta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.muertelenta.entity.DistritoEntity;
import pe.com.muertelenta.service.DistritoService;

@Controller
public class DistritoController {

    // Inyección de dependencias
    @Autowired
    private DistritoService servicio;

    // Rutas --> @GetMapping

    @GetMapping("/distrito/listar")
    public String mostrarListarDistrito(Model modelo) {
        modelo.addAttribute("listaDistritos", servicio.findAllCustom());
        return "distrito/listar_distrito";
    }

    @GetMapping("/distrito/registro")
    public String mostrarRegistroDistrito() {
        return "distrito/registrar_distrito";
    }

    @GetMapping("/distrito/actualiza/{id}")
    public String mostrarActualizaDistrito(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("distrito", servicio.findById(id));
        return "distrito/actualizar_distrito";
    }

    @GetMapping("/distrito/eliminar/{id}")
    public String eliminarDistrito(@PathVariable Long id) {
        DistritoEntity objDistrito = new DistritoEntity();
        objDistrito.setCodigo(id);
        servicio.delete(objDistrito);
        return "redirect:/distrito/listar";
    }

    @GetMapping("/distrito/habilita")
    public String mostrarHabilitaDistrito(Model modelo) {
        modelo.addAttribute("listaDistritos", servicio.findAll());
        return "distrito/habilitar_distrito";
    }

    @GetMapping("/distrito/habilitar/{id}")
    public String habilitarDistrito(@PathVariable Long id) {
        DistritoEntity objDistrito = new DistritoEntity();
        objDistrito.setCodigo(id);
        servicio.enable(objDistrito);
        return "redirect:/distrito/habilita";
    }

    @GetMapping("/distrito/deshabilitar/{id}")
    public String deshabilitarDistrito(@PathVariable Long id) {
        DistritoEntity objDistrito = new DistritoEntity();
        objDistrito.setCodigo(id);
        servicio.delete(objDistrito);
        return "redirect:/distrito/habilita";
    }

    // Modelo
    @ModelAttribute("distrito")
    public DistritoEntity modeloDistrito() {
        return new DistritoEntity();
    }

    // Acciones
    @PostMapping("/distrito/registrar")
    public String registrarDistrito(@ModelAttribute("distrito") DistritoEntity distrito) {
        servicio.add(distrito);
        return "redirect:/distrito/listar";
    }

    @PostMapping("/distrito/actualizar/{id}")
    public String actualizarDistrito(@PathVariable Long id, @ModelAttribute("distrito") DistritoEntity distrito) {
        distrito.setCodigo(id);
        servicio.update(distrito);
        return "redirect:/distrito/listar";
    }
}