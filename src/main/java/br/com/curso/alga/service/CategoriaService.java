package br.com.curso.alga.service;

import br.com.curso.alga.model.Categoria;
import br.com.curso.alga.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository cateRepo;

    public Categoria buscarCategoria(Integer p) {
        Optional<Categoria> categoria = cateRepo.findById(p);
        return categoria.orElse(null);
    }

    public Categoria salvarCategoria (Categoria categoria) {
        return cateRepo.save(categoria);
    }

    public void deletarCategoria(Integer id) {
        cateRepo.deleteById(id);
    }

    public Categoria alterarCategoria(Categoria categoria) {
        Optional<Categoria> p = cateRepo.findById(categoria.getId());
        return cateRepo.save(categoria);
    }

    public List<Categoria> listarCategorias(){
        List<Categoria> categorias = cateRepo.findAll();
        return categorias;
    }

}
