package model;

public class Paciente {

    private String nombre;
    private int edad;
    private String documento;

    public Paciente() {
    }

    public Paciente(String nombre, int edad, String documento) {
        this.nombre = nombre;
        this.edad = edad;
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre.isEmpty()){
            this.nombre = nombre;
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        
            this.edad = edad;
        
    }

    public String getdocumento() {
        return documento;
    }

    public void setdocumento(String documento) {
        if(documento.isEmpty()){
            this.documento = documento;
        }
    }


}