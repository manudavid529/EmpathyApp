package model;

public interface IOperaciones {

    void guardar(Usuario usuario);

    Usuario buscar(String documento);

    void eliminar(String documento);

    void listar();
}