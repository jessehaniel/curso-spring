package tech.ada.java.usuario;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario {

    private UUID uuid;
    private String nome;
    private String email;
    private LocalDate dataNascimento;

    public Usuario(String nome, String email, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public void definirUuid() {
        this.uuid = UUID.randomUUID();
    }

}
