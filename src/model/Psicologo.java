package model;

public class Psicologo extends Usuario {

    private String especialidad;
    private String enfoque;
    private int aniosExperiencia;

     //Constructor Vacío
    public Psicologo() {
    }

    //Constructor Sobrecargado
    public Psicologo(String nombre, int edad, String documento,
                     String especialidad, String enfoque, int aniosExperiencia) {
        super(nombre, edad, documento);
        this.especialidad = especialidad;
        this.enfoque = enfoque;
        this.aniosExperiencia = aniosExperiencia;
    }

    //Método de sobrescritura
 @Override
public void mostrarDatos() {
    System.out.println("Psicólogo: " + getNombre() +
            " | Edad: " + getEdad() +
            " | Documento: " + getDocumento() +
            " | Especialidad: " + especialidad +
            " | Enfoque: " + enfoque +
            " | Experiencia: " + aniosExperiencia + " años");
}

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEnfoque() {
        return enfoque;
    }

    public void setEnfoque(String enfoque) {
        this.enfoque = enfoque;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }
}