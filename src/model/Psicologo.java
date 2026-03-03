package model;

public class Psicologo {

    private String nombre;
    private String especialidad;
    private String enfoque;

    public Psicologo() {
    }

    public Psicologo(String nombre, String especialidad, String enfoque) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.enfoque = enfoque;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(!nombre.isEmpty()){
            this.nombre = nombre;
        }
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        if(!especialidad.isEmpty()){
            this.especialidad = especialidad;
        }
    }

    public String getEnfoque() {
        return enfoque;
    }

    public void setEnfoque(String enfoque) {
        if(!enfoque.isEmpty()){
            this.enfoque = enfoque;
        }
    }


}