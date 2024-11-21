package pe.com.muertelenta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.muertelenta.entity.EmpleadoEntity;
import pe.com.muertelenta.service.DistritoService;
import pe.com.muertelenta.service.EmpleadoService;
import pe.com.muertelenta.service.RolService;

@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoService servicio;

    @Autowired
    private DistritoService distritoServicio;

    @Autowired
    private RolService rolServicio;

    // Rutas --> @GetMapping
    @GetMapping("/empleado/listar")
    public String mostrarListarEmpleado(Model modelo) {
        modelo.addAttribute("listaEmpleados", servicio.findAllCustom());
        return "empleado/listar_empleado";
    }

    @GetMapping("/empleado/registro")
    public String mostrarRegistroEmpleado(Model modelo) {
        modelo.addAttribute("distritos", distritoServicio.findAllCustom());
        modelo.addAttribute("roles", rolServicio.findAllCustom());
        return "empleado/registrar_empleado";
    }

    @GetMapping("/empleado/actualiza/{id}")
    public String mostrarActualizaEmpleado(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("empleado", servicio.findById(id));
        modelo.addAttribute("distritos", distritoServicio.findAllCustom());
        modelo.addAttribute("roles", rolServicio.findAllCustom());
        return "empleado/actualizar_empleado";
    }

    @GetMapping("/empleado/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable Long id) {
        EmpleadoEntity objEmpleado = new EmpleadoEntity();
        objEmpleado.setCodigo(id);
        servicio.delete(objEmpleado);
        return "redirect:/empleado/listar";
    }

    @GetMapping("/empleado/habilita")
    public String mostrarHabilitaEmpleado(Model modelo) {
        modelo.addAttribute("listaEmpleados", servicio.findAll());
        return "empleado/habilitar_empleado";
    }

    @GetMapping("/empleado/habilitar/{id}")
    public String habilitarEmpleado(@PathVariable Long id) {
        EmpleadoEntity objEmpleado = new EmpleadoEntity();
        objEmpleado.setCodigo(id);
        servicio.enable(objEmpleado);
        return "redirect:/empleado/habilita";
    }

    @GetMapping("/empleado/deshabilitar/{id}")
    public String deshabilitarEmpleado(@PathVariable Long id) {
        EmpleadoEntity objEmpleado = new EmpleadoEntity();
        objEmpleado.setCodigo(id);
        servicio.delete(objEmpleado);
        return "redirect:/empleado/habilita";
    }

    // Modelo
    @ModelAttribute("empleado")
    public EmpleadoEntity modeloEmpleado() {
        return new EmpleadoEntity();
    }

    // Acciones
    @PostMapping("/empleado/registrar")
    public String registrarEmpleado(@ModelAttribute("empleado") EmpleadoEntity empleado) {
        servicio.add(empleado);
        return "redirect:/empleado/listar";
    }

    @PostMapping("/empleado/actualizar/{id}")
    public String actualizarEmpleado(@PathVariable Long id, @ModelAttribute("empleado") EmpleadoEntity empleado) {
        empleado.setCodigo(id);
        servicio.update(empleado);
        return "redirect:/empleado/listar";
    }

    //acciones
    @PostMapping("/login")
    public String EmpleadoLogin(@ModelAttribute("empleado") EmpleadoEntity e, Model modelo) {
        EmpleadoEntity objempleado = servicio.login(e.getUsuario(), e.getClave());
        if (objempleado != null) {
            return "redirect:/menuprincipal";
        } else {
            return "index";
        }
    }
}
