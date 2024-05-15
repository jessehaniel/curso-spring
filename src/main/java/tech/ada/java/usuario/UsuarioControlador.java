package tech.ada.java.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UsuarioControlador {

    private final List<Usuario> usuarios;

    public UsuarioControlador() {
        this.usuarios = new ArrayList<>();
    }

    public Usuario adicionarUsuario(Usuario usuario) {
        //evitar duplicação usando o email como valor único
        usuario.definirUuid();
        this.usuarios.add(usuario);
        return usuario;
    }

    public void removerUsuario(Usuario usuario) {
        //buscar antes de remover
        this.usuarios.remove(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return this.usuarios;
    }

    public Usuario buscarUsuarioPorUuid(UUID uuid) {
        return this.usuarios.stream()
            .filter(it -> it.getUuid().equals(uuid))
            .findFirst().orElseThrow();
    }

    public Usuario buscarPorEmail(String email) {
        return this.usuarios.stream()
            .filter(it -> it.getEmail().equals(email))
            .findFirst().orElseThrow();
    }

}
