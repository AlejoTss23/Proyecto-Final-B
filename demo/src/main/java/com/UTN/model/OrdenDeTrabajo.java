package com.UTN.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class OrdenDeTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoDeOrden;
    private String codigoActivo;
    private String tipoActivo;
    private String edificio;
    private String pisoNivel;
    private String sector;
    private String observaciones;
    private String instruccionesDeTarea;

    @OneToMany(mappedBy = "ordenDeTrabajo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Tarea> tareas = new ArrayList<>();

    private LocalDate fechaRealizacion;
    private LocalDate fechaImpresion;

    // Cambiado de Integer a String para más flexibilidad
    private String tiempoTotalUtilizado;

    // Guardamos solo el nombre de usuario
    private String username;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoDeOrden() {
        return tipoDeOrden;
    }

    public void setTipoDeOrden(String tipoDeOrden) {
        this.tipoDeOrden = tipoDeOrden;
    }

    public String getCodigoActivo() {
        return codigoActivo;
    }

    public void setCodigoActivo(String codigoActivo) {
        this.codigoActivo = codigoActivo;
    }

    public String getTipoActivo() {
        return tipoActivo;
    }

    public void setTipoActivo(String tipoActivo) {
        this.tipoActivo = tipoActivo;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public String getPisoNivel() {
        return pisoNivel;
    }

    public void setPisoNivel(String pisoNivel) {
        this.pisoNivel = pisoNivel;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public LocalDate getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(LocalDate fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public LocalDate getFechaImpresion() {
        return fechaImpresion;
    }

    public void setFechaImpresion(LocalDate fechaImpresion) {
        this.fechaImpresion = fechaImpresion;
    }

    public String getTiempoTotalUtilizado() {
        return tiempoTotalUtilizado;
    }

    public void setTiempoTotalUtilizado(String tiempoTotalUtilizado) {
        this.tiempoTotalUtilizado = tiempoTotalUtilizado;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getInstruccionesDeTarea() {
        return instruccionesDeTarea;
    }

    public void setInstruccionesDeTarea(String InstruccionesDeTarea) {
        this.instruccionesDeTarea = InstruccionesDeTarea;
    }
}



