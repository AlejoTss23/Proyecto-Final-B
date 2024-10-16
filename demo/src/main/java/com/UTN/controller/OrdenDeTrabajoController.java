package com.UTN.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UTN.model.OrdenDeTrabajo;
import com.UTN.service.OrdenDeTrabajoService;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenDeTrabajoController {

    @Autowired
    private OrdenDeTrabajoService ordenDeTrabajoService;

    @PostMapping("/crear")
    public ResponseEntity<OrdenDeTrabajo> crearOrden(@RequestBody OrdenDeTrabajo ordenDeTrabajo, @RequestHeader("Authorization") String token) {
        String jwtToken = token.substring(7);
        OrdenDeTrabajo nuevaOrden = ordenDeTrabajoService.crearOrdenDeTrabajo(ordenDeTrabajo, jwtToken);
        return ResponseEntity.ok(nuevaOrden);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenDeTrabajo> obtenerOrden(@PathVariable Long id) {
        Optional<OrdenDeTrabajo> orden = ordenDeTrabajoService.obtenerOrdenDeTrabajo(id);
        return orden.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOrden(@PathVariable Long id) {
        ordenDeTrabajoService.eliminarOrdenDeTrabajo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<OrdenDeTrabajo>> listarOrdenes() {
        List<OrdenDeTrabajo> ordenes = ordenDeTrabajoService.listarOrdenes();
        return ResponseEntity.ok(ordenes);
    }
}


