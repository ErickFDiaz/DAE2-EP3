package pe.com.muertelenta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.muertelenta.entity.PlatoEntity;
import pe.com.muertelenta.service.PlatoService;
import pe.com.muertelenta.service.TipoPlatoService;

@Controller
public class PlatoController {

    @Autowired
    private PlatoService servicio;

    @Autowired
    private TipoPlatoService serviciotipoplato;

    //rutas -->@GetMapping
    @GetMapping("/plato/listar")
    public String MostrarListarPlato(Model modelo) {
        modelo.addAttribute("listaplatos", servicio.findAllCustom());
        return "plato/listar_plato";
    }

    @GetMapping("/plato/registro")
    public String MostrarRegistroPlato(Model modelo) {
        //para cargar los combos que estan en el formulario
        //modelo.addAttribute("listamarcas", serviciomarca.findAllCustom());
        //modelo.addAttribute("listacategorias", serviciocategoria.findAllCustom());
        modelo.addAttribute("tipoplatos", serviciotipoplato.findAllCustom());
        return "plato/registrar_plato";
    }

    @GetMapping("/plato/actualiza/{id}")
    public String MostrarActualizaPlato(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("tipoplatos", serviciotipoplato.findAllCustom());
        modelo.addAttribute("listaplatos", servicio.findById(id));
        return "plato/actualizar_plato";
    }

    @GetMapping("/plato/eliminar/{id}")
    public String EliminarPlato(@PathVariable Long id) {
        PlatoEntity objplato = new PlatoEntity();
        objplato.setCodigo(id);
        servicio.delete(objplato);
        return "redirect:/plato/listar";
    }

    @GetMapping("/plato/habilita")
    public String MostrarHabilitaPlato(Model modelo) {
        modelo.addAttribute("listaplatos", servicio.findAll());
        return "plato/habilitar_plato";
    }

    @GetMapping("/plato/habilitar/{id}")
    public String HabilitarPlato(@PathVariable Long id) {
        PlatoEntity objplato = new PlatoEntity();
        objplato.setCodigo(id);
        servicio.enable(objplato);
        return "redirect:/plato/habilita";
    }

    @GetMapping("/plato/deshabilitar/{id}")
    public String DeshabilitarPlato(@PathVariable Long id) {
        PlatoEntity objplato = new PlatoEntity();
        objplato.setCodigo(id);
        servicio.delete(objplato);
        return "redirect:/plato/habilita";
    }

    //modelo
    @ModelAttribute("plato")
    public PlatoEntity ModeloPlato() {
        return new PlatoEntity();
    }
    //acciones

    //@PostMappimg --> acciones
    @PostMapping("/plato/registrar")
    public String RegistrarTipoPlato(@ModelAttribute("plato") PlatoEntity p) {
        servicio.add(p);
        return "redirect:/plato/listar";
    }

    @PostMapping("/plato/actualizar/{id}")
    public String ActualizaPlato(@PathVariable Long id, @ModelAttribute("plato") PlatoEntity tp) {
        servicio.update(tp);
        return "redirect:/plato/listar";
    }
}
