package model;

public class TestCompatibilidad {

    private Paciente paciente;
    private String necesidadPrincipal;
    private String estiloPreferido;

    public TestCompatibilidad(Paciente paciente, String necesidadPrincipal, String estiloPreferido) {
        this.paciente = paciente;
        this.necesidadPrincipal = necesidadPrincipal;
        this.estiloPreferido = estiloPreferido;
    }

    public void mostrarTest() {
        System.out.println("Paciente: " + paciente.getNombre() +
                " | Necesidad: " + necesidadPrincipal +
                " | Estilo: " + estiloPreferido);
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

   
}