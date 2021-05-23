package br.com.zup.repositories

import br.com.zup.model.Livro
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository


@Repository
interface LivroRepository: JpaRepository<Livro,Long>{
}