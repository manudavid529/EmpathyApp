import java.util.Scanner;
import model.Paciente;
import model.Psicologo;
import model.TestCompatibilidad;
import model.Usuario;
import model.UsuarioService;

public class EmpathyApp {

    static Scanner scanner = new Scanner(System.in);
    static UsuarioService service = new UsuarioService();

    public static void main(String[] args) {

        int opcion = 0;

        do {
            System.out.println("\n========== EMPATHY ==========");
            System.out.println("1. Registrar Paciente");
            System.out.println("2. Registrar Psicologo");
            System.out.println("3. Listar Usuarios");
            System.out.println("4. Buscar Usuario");
            System.out.println("5. Eliminar Usuario");
            System.out.println("6. Test de Compatibilidad");
            System.out.println("7. Salir");
            System.out.println("=============================");

            if (!scanner.hasNextInt()) {
                System.out.println("Opción inválida");
                scanner.nextLine();
                continue;
            }

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
                    service.listar();
                    break;

                case 4:
                    buscarUsuario();
                    break;

                case 5:
                    eliminarUsuario();
                    break;

                case 6:
                    crearTestCompatibilidad();
                    break;

                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 7);
    }

    // ================= PACIENTE =================
    public static void registrarPaciente() {

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Edad: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Edad inválida");
            scanner.nextLine();
            return;
        }
        int edad = scanner.nextInt();
        scanner.nextLine();

        if (edad <= 0) {
            System.out.println("Edad inválida");
            return;
        }

        System.out.print("Documento: ");
        String documento = scanner.nextLine();

        System.out.print("Enfermedad: ");
        String enfermedad = scanner.nextLine();

        System.out.print("Nivel de ansiedad (Alto/Medio/Bajo): ");
        String nivelAnsiedad = scanner.nextLine();

        System.out.print("Objetivo de terapia: ");
        String objetivo = scanner.nextLine();

        service.guardar(new Paciente(
                nombre, edad, documento,
                enfermedad, nivelAnsiedad, objetivo
        ));

        System.out.println("Paciente registrado correctamente.");
    }

    // ================= PSICÓLOGO =================
    public static void registrarPsicologo() {

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Edad: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Edad inválida");
            scanner.nextLine();
            return;
        }
        int edad = scanner.nextInt();
        scanner.nextLine();

        if (edad <= 0) {
            System.out.println("Edad inválida");
            return;
        }

        System.out.print("Documento: ");
        String documento = scanner.nextLine();

        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();

        System.out.print("Enfoque: ");
        String enfoque = scanner.nextLine();

        System.out.print("Años de experiencia: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Experiencia inválida");
            scanner.nextLine();
            return;
        }
        int experiencia = scanner.nextInt();
        scanner.nextLine();

        service.guardar(new Psicologo(
                nombre, edad, documento,
                especialidad, enfoque, experiencia
        ));

        System.out.println("Psicólogo registrado correctamente.");
    }

    // ================= BUSCAR =================
    public static void buscarUsuario() {

        System.out.print("Documento: ");
        String doc = scanner.nextLine();

        Usuario u = service.buscar(doc);

        if (u != null) {
            u.mostrarDatos();
        } else {
            System.out.println("Usuario no encontrado");
        }
    }

    // ================= ELIMINAR =================
    public static void eliminarUsuario() {

        System.out.print("Documento: ");
        String doc = scanner.nextLine();

        Usuario u = service.buscar(doc);

        if (u != null) {
            service.eliminar(doc);
        } else {
            System.out.println("Usuario no encontrado");
        }
    }

    // ================= TEST COMPATIBILIDAD =================
    public static void crearTestCompatibilidad() {

        System.out.print("Documento del paciente: ");
        String doc = scanner.nextLine();

        Usuario u = service.buscar(doc);

        if (u instanceof Paciente) {

            Paciente p = (Paciente) u;

            System.out.print("Necesidad principal: ");
            String necesidad = scanner.nextLine();

            System.out.print("Estilo preferido: ");
            String estilo = scanner.nextLine();

            TestCompatibilidad test = new TestCompatibilidad(p, necesidad, estilo);
            test.mostrarTest();

        } else {
            System.out.println("El usuario no es un paciente o no existe");
        }
    }
}