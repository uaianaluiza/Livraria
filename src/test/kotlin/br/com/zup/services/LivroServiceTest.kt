package br.com.zup.services

import br.com.zup.model.Livro
import br.com.zup.repositories.LivroRepository
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*


@MicronautTest
class LivroServiceTest : AnnotationSpec(){

    val repository = mockk<LivroRepository>()
    val livroService = LivroServiceImpl(repository)
    lateinit var livro: Livro

    @BeforeEach
    fun setUp(){
        livro = Livro(1L, "nome", "nomeautor", "2019")
    }

    @Test
    fun `salvar livro`(){
        every { repository.save(any()) } answers {livro}
        val result = livroService.create(livro)
        result shouldBe livro
    }

    @Test
    fun `deletar livro`(){
        every { repository.findById(any()) } answers  { Optional.of(livro)}
        every { repository.deleteById(any()) } answers  {Unit}
        val result = livroService.delete(1L)
        result shouldBe Unit
    }

    @Test
    fun `pesquisar pelo id`(){
        every { repository.findById(any()) } answers { Optional.of(livro)}
        val result = livroService.getById(1L)
        result shouldBe livro
    }
}