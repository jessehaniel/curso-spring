package tech.ada.java.usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioControlador {

    private final List<Usuario> usuarios;

    public UsuarioControlador() {
        usuarios = new ArrayList<>();
    }

    public Usuario adicionarUsuario(Usuario usuario) {
        //não deve repetir Usuarios, considerar o email como único
        this.usuarios.add(usuario);
        return usuario;
    }

    public List<Usuario> listarUsuarios() {
        return this.usuarios;
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        return this.usuarios.stream().filter(it -> it.getEmail().equals(email)).findFirst().orElseThrow();
    }

    public List<Usuario> buscarUsuarioPorNomeParcial(String nome) {
        return this.usuarios.stream().filter(it -> it.getNome().toLowerCase().contains(nome.toLowerCase())).toList();
    }

    public void removerUsuario(Usuario usuario) {
        //não pode excluir usuários que possui postagens
        this.usuarios.remove(usuario);
    }

    public Usuario substituirUsuario(Usuario usuario) {
        Usuario usuarioVelho = this.buscarUsuarioPorEmail(usuario.getEmail());
        this.usuarios.set(this.usuarios.indexOf(usuarioVelho), usuario);
        return usuario;
    }

}
