package model;
// Clase TestCompatibilidad
public class TestCompatibilidad {
// Atributos
    private String nombrePaciente;
    private String necesidadPrincipal;
    private String estiloPreferido;
// Constructor vacio
    public TestCompatibilidad() {
    }
// Constructor sobrecagrado
    public TestCompatibilidad(String nombrePaciente, String necesidadPrincipal, String estiloPreferido) {
        this.nombrePaciente = nombrePaciente;
        this.necesidadPrincipal = necesidadPrincipal;
        this.estiloPreferido = estiloPreferido;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        if(!nombrePaciente.isEmpty()){
            this.nombrePaciente = nombrePaciente;
        }
    }

    public String getNecesidadPrincipal() {
        return necesidadPrincipal;
    }

    public void setNecesidadPrincipal(String necesidadPrincipal) {
        if(!necesidadPrincipal.isEmpty()){
            this.necesidadPrincipal = necesidadPrincipal;
        }
    }

    public String getEstiloPreferido() {
        return estiloPreferido;
    }

    public void setEstiloPreferido(String estiloPreferido) {
        if(!estiloPreferido.isEmpty()){
            this.estiloPreferido = estiloPreferido;
        }
    }


}