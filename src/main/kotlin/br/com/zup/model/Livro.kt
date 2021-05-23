package br.com.zup.model

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GenerationType.*
import javax.persistence.Table

@Entity
@Table(name = "Livros")
 data class Livro(

    @Id
     @GeneratedValue(IDENTITY)
    val id: Long?,
    @Column
    var name: String,
    @Column
    var nameautor: String,
    @Column
    var anoDePublicacao: String,

    ){
     constructor(): this(null,"","","")
 }
