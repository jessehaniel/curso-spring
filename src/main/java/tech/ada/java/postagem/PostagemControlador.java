package tech.ada.java.postagem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PostagemControlador {

    private List<Postagem> postagens;

    public PostagemControlador() {
        this.postagens = new ArrayList<>();
    }

    public Postagem adicionarPostagem(Postagem postagem) {
        this.postagens.add(postagem);
        return postagem;
    }

    public void removerPostagem(Postagem postagem) {
        this.postagens.remove(postagem);
    }

    public List<Postagem> listarPostagens() {
        return this.postagens;
    }

    public Postagem buscarPostagemPorUuid(UUID uuid) {
        return this.postagens.stream()
            .filter(it -> it.getUuid().equals(uuid))
            .findFirst().orElseThrow();
    }

    public List<Postagem> buscarPorAutor(UUID uuidUsuario) {
        return this.postagens.stream()
            .filter(it -> it.getAutor().getUuid().equals(uuidUsuario))
            .toList();
    }

}
