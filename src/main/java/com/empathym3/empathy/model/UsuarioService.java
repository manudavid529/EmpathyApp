package com.empathym3.empathy.model;

import java.util.ArrayList;

public class UsuarioService implements IOperaciones {

    private ArrayList<Usuario> lista = new ArrayList<>();

    @Override
    public void guardar(Usuario usuario) {

        // Validar duplicados
        if (buscar(usuario.getDocumento()) != null) {
            System.out.println("Ya existe un usuario con ese documento");
            return;
        }

        lista.add(usuario);
    }

    @Override
    public Usuario buscar(String documento) {
        for (Usuario u : lista) {
            if (u.getDocumento().equals(documento)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public void eliminar(String documento) {

        Usuario u = buscar(documento);

        if (u != null) {
            lista.remove(u);
            System.out.println("Usuario eliminado correctamente");
        } else {
            System.out.println("Usuario no encontrado");
        }
    }

    @Override
    public void listar() {

        if (lista.isEmpty()) {
            System.out.println("No hay usuarios registrados");
            return;
        }

        System.out.println("\n--- LISTA DE USUARIOS ---");

        for (Usuario u : lista) {
            System.out.println("Tipo: " + u.getClass().getSimpleName());
            u.mostrarDatos();
        }

        System.out.println("Total usuarios: " + lista.size());
    }
}