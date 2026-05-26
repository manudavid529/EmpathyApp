package model;

public class Paciente extends Usuario {

    private String enfermedad;
    private String nivelAnsiedad;
    private String objetivoTerapia;

    //Constructor Vacío
    public Paciente() {
    }

    //Constructor Sobrecargado
    public Paciente(String nombre, int edad, String documento,
                    String enfermedad, String nivelAnsiedad, String objetivoTerapia) {
        super(nombre, edad, documento);
        this.enfermedad = enfermedad;
        this.nivelAnsiedad = nivelAnsiedad;
        this.objetivoTerapia = objetivoTerapia;
    }

    //Método de sobrescritura
    @Override
    public void mostrarDatos() {
        System.out.println("Paciente: " + getNombre() +
                " | Edad: " + getEdad() +
                " | Documento: " + getDocumento() +
                " | Enfermedad: " + enfermedad +
                " | Nivel Ansiedad: " + nivelAnsiedad +
                " | Objetivo: " + objetivoTerapia);
    }

    //Getters & Setters
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