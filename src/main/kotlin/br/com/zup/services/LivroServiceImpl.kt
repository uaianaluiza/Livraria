package br.com.zup.services

import br.com.zup.model.Livro
import br.com.zup.repositories.LivroRepository
import java.lang.RuntimeException
import javax.inject.Inject

class LivroServiceImpl (@Inject private var livroRepository: LivroRepository)
    :LivroService{


    override fun create(livro: Livro): Livro {
        return livroRepository.save(livro)
    }

    override fun getAll():List<Livro> {
        return livroRepository.findAll()
    }

    override fun delete(id: Long) {
        if (livroRepository.existsById(id)){
            livroRepository.deleteById(id)
        }else{
          throw RuntimeException ("Livro não encontrado")
        }
    }

    override fun getById(id: Long): Livro? {
        val livro = livroRepository.findById(id)

        if (livro.isPresent){
            return livro.get()
        }
        throw RuntimeException ("Livro não encontrado")
    }
    }
