package pe.com.muertelenta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.muertelenta.entity.TipoPlatoEntity;
import pe.com.muertelenta.service.TipoPlatoService;

@Controller
public class TipoPlatoController {

    //inyeccion de dependencias
    @Autowired
    private TipoPlatoService servicio;

    //GetMapping --> rutas
    @GetMapping("/tipoplato/listar")
    //Model modelo --> permite enviar datos desde el controlador a la vista
    public String MostrarListarTipoPlato(Model modelo) {
        modelo.addAttribute("listatipoplatos", servicio.findAllCustom());
        return "tipoplato/listar_tipoplato";
    }

    @GetMapping("/tipoplato/registro")
    public String MostrarRegistroTipoPlato() {
        return "tipoplato/registrar_tipoplato";
    }

    @GetMapping("/tipoplato/actualiza/{id}")
    public String MostrarActualizaTipoPlato(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("listatipoplatos", servicio.findById(id));
        return "tipoplato/actualizar_tipoplato";
    }

    @GetMapping("/tipoplato/eliminar/{id}")
    public String EliminarTipoPlato(@PathVariable Long id) {
        TipoPlatoEntity objtipoplato = new TipoPlatoEntity();
        objtipoplato.setCodigo(id);
        servicio.delete(objtipoplato);
        return "redirect:/tipoplato/listar";
    }

    @GetMapping("/tipoplato/habilita")
    public String MostrarHabilitaTipoPlato(Model modelo) {
        modelo.addAttribute("listatipoplatos", servicio.findAll());
        return "tipoplato/habilitar_tipoplato";
    }

    @GetMapping("/tipoplato/habilitar/{id}")
    public String HabilitarTipoPlato(@PathVariable Long id) {
        TipoPlatoEntity objtipoplato = new TipoPlatoEntity();
        objtipoplato.setCodigo(id);
        servicio.enable(objtipoplato);
        return "redirect:/tipoplato/habilita";
    }

    @GetMapping("/tipoplato/deshabilitar/{id}")
    public String DeshabilitarTipoPlato(@PathVariable Long id) {
        TipoPlatoEntity objtipoplato = new TipoPlatoEntity();
        objtipoplato.setCodigo(id);
        servicio.delete(objtipoplato);
        return "redirect:/tipoplato/habilita";
    }

    //Modelo --> transporta la informacion
    @ModelAttribute("tipoplato")
    public TipoPlatoEntity ModeloTipoPlato() {
        return new TipoPlatoEntity();
    }

    //@PostMappimg --> acciones
    @PostMapping("/tipoplato/registrar")
    public String RegistrarTipoPlato(@ModelAttribute("tipoplato") TipoPlatoEntity tp) {
        servicio.add(tp);
        return "redirect:/tipoplato/listar";
    }

    @PostMapping("/tipoplato/actualizar/{id}")
    public String ActualizarTipoPlato(@PathVariable Long id, @ModelAttribute("tipoplato") TipoPlatoEntity tp) {
        servicio.update(tp);
        return "redirect:/tipoplato/listar";
    }
}
