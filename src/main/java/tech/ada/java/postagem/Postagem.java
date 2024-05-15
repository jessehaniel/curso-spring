package tech.ada.java.postagem;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tech.ada.java.usuario.Usuario;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Postagem {

    private final UUID uuid;
    private final LocalDateTime datahora;
    private String titulo;
    private String corpo;
    private Usuario autor;

    public Postagem() {
        this.datahora = LocalDateTime.now();
        this.uuid = UUID.randomUUID();
    }

    public Postagem(String titulo, String corpo, Usuario autor) {
        this();
        this.titulo = titulo;
        this.corpo = corpo;
        this.autor = autor;
    }

}
