/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.evaluacion2julca.controller;

import com.example.evaluacion2julca.model.Trabajador;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.evaluacion2julca.service.TrabajadorService;

@Controller
@RequestMapping("/trabajadores")
public class TrabajadorController {

    private final TrabajadorService service;

    public TrabajadorController(TrabajadorService service) {
        this.service = service;
    }

    @GetMapping
    public String listarTrabajadores(Model model) {
        model.addAttribute("trabajadores", service.listarTodos());
        return "trabajadores";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("trabajador", new Trabajador());
        return "formularioTrabajador";
    }

    @PostMapping
    public String guardarTrabajador(@ModelAttribute Trabajador trabajador) {
        service.guardar(trabajador);
        return "redirect:/trabajadores";
    }

    @GetMapping("/editar/{id}")
    public String editarTrabajador(@PathVariable Long id, Model model) {
        model.addAttribute("trabajador", service.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id)));
        return "formularioTrabajador";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTrabajador(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/trabajadores";
    }
}
