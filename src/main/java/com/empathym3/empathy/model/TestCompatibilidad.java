package com.empathym3.empathy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tests_compatibilidad")
public class TestCompatibilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    private String necesidadPrincipal;
    private String estiloPreferido;

    public TestCompatibilidad() {
    }

    public TestCompatibilidad(Paciente paciente, String necesidadPrincipal, String estiloPreferido) {
        this.paciente = paciente;
        this.necesidadPrincipal = necesidadPrincipal;
        this.estiloPreferido = estiloPreferido;
    }

    public Long getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getNecesidadPrincipal() {
        return necesidadPrincipal;
    }

    public void setNecesidadPrincipal(String necesidadPrincipal) {
        this.necesidadPrincipal = necesidadPrincipal;
    }

    public String getEstiloPreferido() {
        return estiloPreferido;
    }

    public void setEstiloPreferido(String estiloPreferido) {
        this.estiloPreferido = estiloPreferido;
    }

    public void mostrarTest() {
        System.out.println("Paciente: " + paciente.getNombre() +
                " | Necesidad: " + necesidadPrincipal +
                " | Estilo: " + estiloPreferido);
    }
}
