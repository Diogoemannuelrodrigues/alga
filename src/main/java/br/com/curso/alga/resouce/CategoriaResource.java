package br.com.curso.alga.resouce;

import br.com.curso.alga.model.Categoria;
import br.com.curso.alga.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    private CategoriaService service;

    @Autowired
    private CategoriaService catService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Categoria> findCategoria(@PathVariable Integer id) {
        Categoria categoria = catService.buscarCategoria(id);
        return ResponseEntity.ok().body(categoria);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveCategoria(@RequestBody Categoria categoria) {
        Categoria categorianew = catService.salvarCategoria(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> categorias() {
        List<Categoria> cat = catService.listarCategorias();
        return cat;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Categoria> alterarCategoria(@RequestBody Categoria Categoria) {
        Categoria cli = catService.alterarCategoria(Categoria);
        return ResponseEntity.ok().body(cli);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Categoria> deletaProduto(@PathVariable Integer id) {
        catService.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }

}
