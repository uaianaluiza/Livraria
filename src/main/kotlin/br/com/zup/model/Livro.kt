package br.com.zup.model


import javax.persistence.*

@Entity
@Table(name = "Livros")
 data class Livro(

    @Id
    @javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column
    val nome: String,
    @Column
    val nomeAutor: String,
    @Column
    val anoDePublicacao: String,

    ){
     constructor(): this(null,"","","")
 }
