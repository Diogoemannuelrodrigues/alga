package br.com.curso.alga.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nome;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "senha", nullable = false)
    private String senha;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Permissao> permissoes;

}
