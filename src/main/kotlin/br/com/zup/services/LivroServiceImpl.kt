package br.com.zup.services

import br.com.zup.exceptions.LivroNaoEncontradoException
import br.com.zup.model.Livro
import br.com.zup.repositories.LivroRepository
import javax.inject.Singleton


@Singleton
class LivroServiceImpl ( private var livroRepository: LivroRepository)
    :LivroService{


    override fun create(livro: Livro): Livro {
        return livroRepository.save(livro)
    }

    override fun getAll():List<Livro> {
        return livroRepository.findAll().toList()
    }

    override fun delete(id: Long) {

        if (livroRepository.findById(id).isPresent){
            livroRepository.deleteById(id)
        }else{
          throw LivroNaoEncontradoException()
        }
    }

    override fun getById(id: Long): Livro? {
        val livro = livroRepository.findById(id)

        if (livro.isPresent){
            return livro.get()
        }
        throw LivroNaoEncontradoException()
    }
    }
