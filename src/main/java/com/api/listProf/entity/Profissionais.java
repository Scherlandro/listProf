package com.api.listProf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "profissionais")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profissionais implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_prof;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 50)
    private String cargo;

    @Column(nullable = false)
    private Date nascimnento;

    @Column(nullable = false)
    private Date created_date;

/*    @OneToMany(mappedBy = "contatos", fetch = FetchType.EAGER)
    private List<Contatos> listaContatos;

    @OneToMany(mappedBy = "contatos", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Contatos> setContatos;*/

}