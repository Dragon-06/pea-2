/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.evaluacion2julca.service;

import java.util.List;
import java.util.Optional;
import com.example.evaluacion2julca.model.Trabajador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.evaluacion2julca.repository.TrabajadorRepository;

@Service
public class TrabajadorService {

    @Autowired
    private TrabajadorRepository repository;

    public List<Trabajador> listarTodos() {
        return repository.findAll();
    }

    public void guardar(Trabajador trabajador) {
        repository.save(trabajador);
    }

    public Optional<Trabajador> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
