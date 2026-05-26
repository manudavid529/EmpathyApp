package com.empathym3.empathy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.empathym3.empathy.model.Paciente;
import com.empathym3.empathy.model.Psicologo;
import com.empathym3.empathy.model.TestCompatibilidad;
import com.empathym3.empathy.model.Usuario;
import com.empathym3.empathy.repository.PacienteRepository;
import com.empathym3.empathy.repository.PsicologoRepository;
import com.empathym3.empathy.repository.TestCompatibilidadRepository;

@SpringBootApplication
public class EmpathyApp implements CommandLineRunner {

    private final PacienteRepository pacienteRepository;
    private final PsicologoRepository psicologoRepository;
    private final TestCompatibilidadRepository testRepository;

    private final Scanner scanner = new Scanner(System.in);

    public EmpathyApp(
            PacienteRepository pacienteRepository,
            PsicologoRepository psicologoRepository,
            TestCompatibilidadRepository testRepository) {

        this.pacienteRepository = pacienteRepository;
        this.psicologoRepository = psicologoRepository;
        this.testRepository = testRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(EmpathyApp.class, args);
    }

    @Override
    public void run(String... args) {

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
                    listarUsuarios();
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
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 7);
    }

    public void registrarPaciente() {

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Documento: ");
        String documento = scanner.nextLine();

        System.out.print("Enfermedad: ");
        String enfermedad = scanner.nextLine();

        System.out.print("Nivel ansiedad: ");
        String ansiedad = scanner.nextLine();

        System.out.print("Objetivo terapia: ");
        String objetivo = scanner.nextLine();

        Paciente paciente = new Paciente(
                nombre,
                edad,
                documento,
                enfermedad,
                ansiedad,
                objetivo);

        pacienteRepository.save(paciente);

        System.out.println("Paciente registrado");
    }

    public void registrarPsicologo() {

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Documento: ");
        String documento = scanner.nextLine();

        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();

        System.out.print("Enfoque: ");
        String enfoque = scanner.nextLine();

        System.out.print("Experiencia: ");
        int experiencia = scanner.nextInt();
        scanner.nextLine();

        Psicologo psicologo = new Psicologo(
                nombre,
                edad,
                documento,
                especialidad,
                enfoque,
                experiencia);

        psicologoRepository.save(psicologo);

        System.out.println("Psicólogo registrado");
    }

    public void listarUsuarios() {

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.addAll(pacienteRepository.findAll());
        usuarios.addAll(psicologoRepository.findAll());

        for (Usuario u : usuarios) {
            u.mostrarDatos();
        }
    }

    public void buscarUsuario() {

        System.out.print("Documento: ");
        String documento = scanner.nextLine();

        Optional<Paciente> paciente = pacienteRepository.findByDocumento(documento);
        if (paciente.isPresent()) {
            paciente.get().mostrarDatos();
            return;
        }

        Optional<Psicologo> psicologo = psicologoRepository.findByDocumento(documento);
        if (psicologo.isPresent()) {
            psicologo.get().mostrarDatos();
            return;
        }

        System.out.println("Usuario no encontrado");
    }

    public void eliminarUsuario() {

        System.out.print("Documento: ");
        String documento = scanner.nextLine();

        Optional<Paciente> paciente = pacienteRepository.findByDocumento(documento);

        if (paciente.isPresent()) {
            pacienteRepository.delete(paciente.get());
            System.out.println("Usuario eliminado");
        } else {
            Optional<Psicologo> psicologo = psicologoRepository.findByDocumento(documento);
            if (psicologo.isPresent()) {
                psicologoRepository.delete(psicologo.get());
                System.out.println("Usuario eliminado");
            } else {
                System.out.println("Usuario no encontrado");
            }
        }
    }

    public void crearTestCompatibilidad() {

        System.out.print("Documento paciente: ");
        String documento = scanner.nextLine();

        Optional<Paciente> paciente = pacienteRepository.findByDocumento(documento);

        if (paciente.isPresent()) {
            System.out.print("Necesidad principal: ");
            String necesidad = scanner.nextLine();

            System.out.print("Estilo preferido: ");
            String estilo = scanner.nextLine();

            TestCompatibilidad test =
                    new TestCompatibilidad(
                            paciente.get(),
                            necesidad,
                            estilo);

            testRepository.save(test);

            System.out.println("Test creado");
        } else {
            System.out.println("Paciente no encontrado");
        }
    }
}