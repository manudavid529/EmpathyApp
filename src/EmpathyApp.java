import java.util.ArrayList;
import java.util.Scanner;
import model.Paciente;
import model.Psicologo;
import model.TestCompatibilidad;

public class EmpathyApp {

    static ArrayList<Paciente> listaPacientes = new ArrayList<>();
    static ArrayList<Psicologo> listaPsicologos = new ArrayList<>();
    static ArrayList<TestCompatibilidad> listaTests = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        System.out.println("Bienvenido a EMPATHY");
        System.out.println("Donde tu proceso empieza con la conexión correcta");

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarPaciente();
                    break;
                case 2:
                    registrarPsicologo();
                    break;
                case 3:
                    registrarTest();
                    break;
                case 4:
                    verPacientes();
                    break;
                case 5:
                    verPsicologos();
                    break;
                case 6:
                    verTests();
                    break;
                case 7:
                    System.out.println("Gracias por usar Empathy. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 7);
    }

    public static void mostrarMenu() {
        System.out.println("\n--- MENÚ EMPATHY ---");
        System.out.println("1. Registrar paciente");
        System.out.println("2. Registrar psicólogo");
        System.out.println("3. Registrar test de compatibilidad");
        System.out.println("4. Ver pacientes");
        System.out.println("5. Ver psicólogos");
        System.out.println("6. Ver tests");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void registrarPaciente() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = scanner.nextInt();
         if(edad >=5){
            edad = edad;
        } else {
            System.out.println("La edad no puede ser menor a 5.");
            edad=0;
        }
        scanner.nextLine();

        System.out.print("documento: ");
        String documento = scanner.nextLine();

        Paciente paciente = new Paciente(nombre, edad, documento);
        listaPacientes.add(paciente);

        System.out.println("Paciente registrado correctamente.");
    }

    public static void registrarPsicologo() {
        System.out.print("Nombre del psicólogo: ");
        String nombre = scanner.nextLine();

        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();

        System.out.print("Enfoque terapéutico: ");
        String enfoque = scanner.nextLine();

        Psicologo psicologo = new Psicologo(nombre, especialidad, enfoque);
        listaPsicologos.add(psicologo);

        System.out.println("Psicólogo registrado correctamente.");
    }

    public static void registrarTest() {
        System.out.print("Nombre del paciente: ");
        String nombrePaciente = scanner.nextLine();

        System.out.print("Necesidad principal: ");
        String necesidad = scanner.nextLine();

        System.out.print("Estilo preferido: ");
        String estilo = scanner.nextLine();

        TestCompatibilidad test = new TestCompatibilidad(nombrePaciente, necesidad, estilo);
        listaTests.add(test);

        System.out.println("Test registrado correctamente.");
    }

    public static void verPacientes() {
        System.out.println("\n--- LISTA DE PACIENTES ---");
        for (Paciente p : listaPacientes) {
            System.out.println(p);
        }
    }

    public static void verPsicologos() {
        System.out.println("\n--- LISTA DE PSICÓLOGOS ---");
        for (Psicologo p : listaPsicologos) {
            System.out.println(p);
        }
    }

    public static void verTests() {
        System.out.println("\n--- LISTA DE TESTS ---");
        for (TestCompatibilidad t : listaTests) {
            System.out.println(t);
        }
    }
}