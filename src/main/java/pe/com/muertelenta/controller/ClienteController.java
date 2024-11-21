package pe.com.muertelenta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.muertelenta.entity.ClienteEntity;
import pe.com.muertelenta.entity.DistritoEntity;
import pe.com.muertelenta.service.ClienteService;
import pe.com.muertelenta.service.DistritoService;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService servicio;

    @Autowired
    private DistritoService distritoServicio;

    // Rutas --> @GetMapping
    @GetMapping("/cliente/listar")
    public String mostrarListarCliente(Model modelo) {
        modelo.addAttribute("listaClientes", servicio.findAllCustom());
        return "cliente/listar_cliente";
    }

    @GetMapping("/cliente/registro")
    public String mostrarRegistroCliente(Model modelo) {
        modelo.addAttribute("distritos", distritoServicio.findAllCustom());
        return "cliente/registrar_cliente";
    }

    @GetMapping("/cliente/actualiza/{id}")
    public String mostrarActualizaCliente(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("cliente", servicio.findById(id));
        modelo.addAttribute("distritos", distritoServicio.findAllCustom());
        return "cliente/actualizar_cliente";
    }

    @GetMapping("/cliente/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        ClienteEntity objCliente = new ClienteEntity();
        objCliente.setCodigo(id);
        servicio.delete(objCliente);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/cliente/habilita")
    public String mostrarHabilitaCliente(Model modelo) {
        modelo.addAttribute("listaClientes", servicio.findAll());
        return "cliente/habilitar_cliente";
    }

    @GetMapping("/cliente/habilitar/{id}")
    public String habilitarCliente(@PathVariable Long id) {
        ClienteEntity objCliente = new ClienteEntity();
        objCliente.setCodigo(id);
        servicio.enable(objCliente);
        return "redirect:/cliente/habilita";
    }

    @GetMapping("/cliente/deshabilitar/{id}")
    public String deshabilitarCliente(@PathVariable Long id) {
        ClienteEntity objCliente = new ClienteEntity();
        objCliente.setCodigo(id);
        servicio.delete(objCliente);
        return "redirect:/cliente/habilita";
    }

    // Modelo
    @ModelAttribute("cliente")
    public ClienteEntity modeloCliente() {
        return new ClienteEntity();
    }

    // Acciones
    @PostMapping("/cliente/registrar")
    public String registrarCliente(@ModelAttribute("cliente") ClienteEntity cliente) {
        servicio.add(cliente);
        return "redirect:/cliente/listar";
    }

    @PostMapping("/cliente/actualizar/{id}")
    public String actualizarCliente(@PathVariable Long id, @ModelAttribute("cliente") ClienteEntity cliente) {
        cliente.setCodigo(id);
        servicio.update(cliente);
        return "redirect:/cliente/listar";
    }
}
