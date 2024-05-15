package tech.ada.java.usuario;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Usuario {

    private final UUID uuid;
    private String nome;
    @Setter(AccessLevel.PRIVATE)
    private String email;
    private LocalDate dataNascimento;

    public Usuario() {
        this.uuid = UUID.randomUUID();
    }

    public Usuario(String nome, String email, LocalDate dataNascimento) {
        this();
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }


}
