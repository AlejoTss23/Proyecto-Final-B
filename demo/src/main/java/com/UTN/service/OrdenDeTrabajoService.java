package com.UTN.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UTN.model.OrdenDeTrabajo;
import com.UTN.model.Usuario;
import com.UTN.repository.OrdenDeTrabajoRepository;
import com.UTN.repository.UsuarioRepository;
import com.UTN.security.JwtTokenUtil;

@Service
public class OrdenDeTrabajoService {

    @Autowired
    private OrdenDeTrabajoRepository ordenDeTrabajoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public OrdenDeTrabajo crearOrdenDeTrabajo(OrdenDeTrabajo orden, String token) {
        String username = jwtTokenUtil.getUsernameFromToken(token);
        Usuario usuario = usuarioRepository.findByUsername(username);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }

        // Guardar solo el username en lugar del objeto Usuario completo
        orden.setUsername(usuario.getUsername());

        return ordenDeTrabajoRepository.save(orden);
    }
    public Optional<OrdenDeTrabajo> obtenerOrdenDeTrabajo(Long id) {
        return ordenDeTrabajoRepository.findById(id);
    }

    public void eliminarOrdenDeTrabajo(Long id) {
        ordenDeTrabajoRepository.deleteById(id);
    }

    public List<OrdenDeTrabajo> listarOrdenes() {
        return ordenDeTrabajoRepository.findAll();
    }
}


