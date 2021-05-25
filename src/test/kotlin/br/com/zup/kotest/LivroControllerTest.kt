package br.com.zup.kotest

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
    lateinit var livro : Livro

    @BeforeEach
    fun setUp(){

       livro = Livro(1L,"nome","nomeautor","2019")

    }
    @Test
    fun save(){
        every { service.create(any()) } answers { livro}
        val result= livroController.adicionarLivro(livro).body()
        result shouldBe livro
    }
}