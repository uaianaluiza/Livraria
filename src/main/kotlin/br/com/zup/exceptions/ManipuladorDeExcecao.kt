package br.com.zup.exceptions

import io.micronaut.context.annotation.Requires
import io.micronaut.http.server.exceptions.ExceptionHandler
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Produces
import javax.inject.Singleton

@Produces
@Singleton
@Requires(classes = [LivroNaoEncontradoException:: class, ManipuladorDeExcecao :: class])
class ManipuladorDeExcecao : ExceptionHandler<LivroNaoEncontradoException?,HttpResponse<*>>{

    override fun handle( request: HttpRequest<*>?, exception: LivroNaoEncontradoException?): HttpResponse<*>{
        val erro = Erro(HttpStatus.BAD_REQUEST.toString(),400,"invalid arguments")

        return HttpResponse.badRequest(erro)
    }
}