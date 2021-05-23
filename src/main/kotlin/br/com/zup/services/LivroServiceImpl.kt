package br.com.zup.services

import br.com.zup.model.Livro
import br.com.zup.repositories.LivroRepository
import javax.inject.Inject

class LivroServiceImpl (@Inject private var livroRepository: LivroRepository)
    :LivroService{


    override fun create(livro: Livro): Livro {
        return livroRepository.save(livro)
    }

    override fun getAll():List<Livro> {
        return livroRepository.findAll()
    }

    }
