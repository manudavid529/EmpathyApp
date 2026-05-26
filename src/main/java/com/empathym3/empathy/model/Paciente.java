package com.empathym3.empathy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pacientes")
public class Paciente extends Usuario {

    private String enfermedad;

    @Column(name = "nivel_ansiedad")
    private String nivelAnsiedad;

    @Column(name = "objetivo_terapia")
    private String objetivoTerapia;

    public Paciente() {
    }

    public Paciente(String nombre, int edad, String documento,
                    String enfermedad, String nivelAnsiedad, String objetivoTerapia) {
        super(nombre, edad, documento);
        this.enfermedad = enfermedad;
        this.nivelAnsiedad = nivelAnsiedad;
        this.objetivoTerapia = objetivoTerapia;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Paciente: " + getNombre() +
                " | Edad: " + getEdad() +
                " | Documento: " + getDocumento() +
                " | Enfermedad: " + enfermedad +
                " | Nivel Ansiedad: " + nivelAnsiedad +
                " | Objetivo: " + objetivoTerapia);
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getNivelAnsiedad() {
        return nivelAnsiedad;
    }

    public void setNivelAnsiedad(String nivelAnsiedad) {
        this.nivelAnsiedad = nivelAnsiedad;
    }

    public String getObjetivoTerapia() {
        return objetivoTerapia;
    }

    public void setObjetivoTerapia(String objetivoTerapia) {
        this.objetivoTerapia = objetivoTerapia;
    }
}
