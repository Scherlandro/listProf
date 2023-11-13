package com.api.listProf.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name ="contatos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contatos implements Serializable {
        private static final Long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Integer id;

        @Column(nullable = false, length = 20)
        private String nome;

        @Column(nullable = false, length = 80)
        private String contato;

        @Column(nullable = false)
        private Date created_date;

    }

