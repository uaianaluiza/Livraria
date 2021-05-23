package br.com.zup.services

import br.com.zup.model.Livro
import javax.inject.Singleton

@Singleton
interface LivroService {
    fun create(livro: Livro):Livro
    fun getAll(): List<Livro>
    fun getById(id: Long):Livro?
    fun delete(id:Long)

}