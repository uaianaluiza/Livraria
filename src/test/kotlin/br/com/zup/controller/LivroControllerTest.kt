package br.com.zup.controller

import br.com.zup.controllers.LivroController
import br.com.zup.model.Livro
import br.com.zup.services.LivroService
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk


@MicronautTest
class LivroControllerTest: AnnotationSpec() {

    val service = mockk<LivroService>()
    val livroController = LivroController(service)
    lateinit var livro: Livro

    @BeforeEach
    fun setUp() {

        livro = Livro(1L, "nome", "nomeautor", "2019")

    }

    @Test
    fun save() {
        every { service.create(any()) } answers { livro }
        val result = livroController.adicionarLivro(livro).body()
        result shouldBe livro
    }

    @Test
    fun `visualizar todos os livros`() {
        every { service.getAll() } answers { listOf(livro) }
        val result = livroController.visualitarTodosOsLivros().body()
        result shouldBe listOf(livro)
    }

    @Test
    fun `testar deletar livro`() {
        every { service.delete(any()) } answers { Unit }
        val result = livroController.deletarLivro(1L)
        result shouldBe Unit
    }

    @Test
    fun `testar buscar livro pelo id`(){
        every { service.getById(any())} answers {livro}
        val result = livroController.buscarLivroPeloId(1L).body()
        result shouldBe livro
    }
}
