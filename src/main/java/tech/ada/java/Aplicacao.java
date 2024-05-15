package tech.ada.java;

import tech.ada.java.usuario.UsuarioControlador;

public class Aplicacao {

    public static void main(String[] args) {
        new Aplicacao().run();
    }

    private void run() {
        UsuarioControlador usuarioControlador = new UsuarioControlador();
        usuarioControlador.listarUsuarios().forEach(System.out::println);
    }

}
