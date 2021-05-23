package br.com.zup.repositories

import br.com.zup.model.Livro
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface LivroRepository: CrudRepository<Livro,Long>{
}