package br.com.zup.controllers

import br.com.zup.model.Livro
import br.com.zup.services.LivroService
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*

@Controller("livros/")
class LivroController (private val service: LivroService){

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    fun adicionarLivro(@Body livros:Livro): HttpResponse<Livro?> {
        return HttpResponse.created(HttpStatus.CREATED).body(this.service.create(livros))
    }

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun visualitarTodosOsLivros():HttpResponse<List<Livro?>>{
        return HttpResponse.ok(HttpStatus.CREATED).body(this.service.getAll())
    }

    @Delete("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun deletarLivro(@PathVariable id:Long){
        service.delete(id)
    }

    @Get("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun buscarLivroPeloId(@PathVariable id:Long):HttpResponse<Livro>{
        return HttpResponse.ok(HttpStatus.OK).body(this.service.getById(id))
    }
}