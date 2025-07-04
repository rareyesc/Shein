package shein.micro_categoria.service;

import shein.micro_categoria.entity.Categoria;
import shein.micro_categoria.exception.ResourceNotFoundException;
import shein.micro_categoria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> obtenerTodasLasCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria obtenerCategoriaPorId(Integer id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con ID: " + id));
    }

    @Override
    public Categoria crearCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria actualizarCategoria(Integer id, Categoria detallesCategoria) {
        Categoria categoria = obtenerCategoriaPorId(id);
        categoria.setNombreCategoria(detallesCategoria.getNombreCategoria());
        return categoriaRepository.save(categoria);
    }

    @Override
    public void eliminarCategoria(Integer id) {
        Categoria categoria = obtenerCategoriaPorId(id);
        categoriaRepository.delete(categoria);
    }
}
