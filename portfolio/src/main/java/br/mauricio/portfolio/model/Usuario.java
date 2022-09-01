package br.mauricio.portfolio.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Size(max = 40)
    @Getter
    @Setter
    private String nome;

    @Size(max = 70)
    @Getter
    @Setter
    private String email;

    @Size(max = 35)
    @Getter
    @Setter
    private String senha;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", Nome='" + nome + '\'' +
                ", Email='" + email + '\'' +
                ", Senha='" + senha + '\'' +
                '}';
    }
}
