package br.mauricio.portfolio.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id_usuario")
    private long id;

    @Size(max = 40)
    @Getter
    @Setter
    @NotNull
    @Column(name = "nome_usuario")
    private String nome;

    @Size(max = 70)
    @Getter
    @Setter
    @NotNull
    @Column(name = "email_usuario")
    private String email;

    @Size(max = 35)
    @Getter
    @Setter
    @NotNull
    @Column(name = "senha_Usuario")
    private String senha;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
