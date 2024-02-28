package org.example.cv_03.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @Entity: Označuje třídu jako JPA entitu, což znamená, že je mapována na tabulku v databázi.
 * @Id: Určuje, že atribut je primárním klíčem entity.
 * @Table: Specifikuje jméno tabulky v databázi, ke které se entita mapuje.
 * @Column: Mapuje atribut entity na sloupec v databázové tabulce. Lze použít pro specifikaci vlastností sloupce, jako je jeho název, délka, povolení null hodnot atd.
 * @Transient: Označuje atribut entity, který není mapován na sloupec v databázi. Sloupec pro tento atribut nebude vytvořen.
 * @Temporal: Používá se pro mapování atributů typu java.util.Date nebo java.util.Calendar do databáze. Specifikuje formát uložení data a času.
 * @Enumerated: Mapuje atribut enum na sloupec v databázi. Umožňuje specifikovat strategii mapování pro enum hodnoty.
 * @OneToMany: Označuje vztah mezi dvěma entitami, kde jedna entita má mnoho vazeb na druhou entitu.
 * @ManyToOne: Označuje vztah mezi dvěma entitami, kde mnoho instancí jedné entity odkazuje na jednu instanci druhé entity.
 * @ManyToMany: Označuje vztah mezi dvěma entitami, kde každá entita může mít mnoho vazeb na druhou entitu.
 * @JoinColumn: Specifikuje sloupec v databázové tabulce, který slouží jako cizí klíč pro vztah mezi entitami.
 * @JoinTable: Používá se pro definici spojovací tabulky pro vztahy typu Many-to-Many.
 * @Embedded: Označuje, že atribut entity obsahuje jinou entitu, která má být vložena přímo do tabulky entity.
 * @Data: Generuje standardní metody jako toString(), equals(), hashCode() a metody pro přístup k atributům pomocí getterů a setterů.
 * @AllArgsConstructor: Generuje konstruktor, který přijímá všechny atributy třídy jako parametry, což usnadňuje inicializaci objektů s mnoha atributy.
 *
 */
@Data
@AllArgsConstructor
@Entity(name="appuser")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    public String username;

    @Column
    public String password;

    @Column
    public boolean active;

    @Column
    public Date creation_date;

    @Column
    public Date update_date;

    @OneToMany(mappedBy = "app_user")
    private List<AppUserRole> app_user_roles = Collections.emptyList();

    public AppUser() {

    }

}
