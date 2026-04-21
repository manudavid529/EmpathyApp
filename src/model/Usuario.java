package model;

//Esta es la clase Padre
public abstract class Usuario {

    protected String nombre;
    protected int edad;
    protected String documento;

    public Usuario() {
    }


    public Usuario(String nombre, int edad, String documento) {
        this.nombre = nombre;
        this.edad = edad;
        this.documento = documento;
    }

   
    //Eeste es el método
    public abstract void mostrarDatos();


    //Getters & Setters
    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public int getEdad() {
        return edad;
    }



    public void setEdad(int edad) {
        this.edad = edad;
    }



    public String getDocumento() {
        return documento;
    }



    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
