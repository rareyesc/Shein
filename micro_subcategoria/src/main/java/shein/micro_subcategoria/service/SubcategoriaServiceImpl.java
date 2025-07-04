package shein.micro_subcategoria.service;

import shein.micro_subcategoria.entity.Subcategoria;
import shein.micro_subcategoria.exception.ResourceNotFoundException;
import shein.micro_subcategoria.repository.SubcategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubcategoriaServiceImpl implements SubcategoriaService {

    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    @Override
    public List<Subcategoria> obtenerTodasLasSubcategorias() {
        return subcategoriaRepository.findAll();
    }

    @Override
    public Subcategoria obtenerSubcategoriaPorId(Integer id) {
        return subcategoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subcategoría no encontrada con ID: " + id));
    }

    @Override
    public Subcategoria crearSubcategoria(Subcategoria subcategoria) {
        return subcategoriaRepository.save(subcategoria);
    }

    @Override
    public Subcategoria actualizarSubcategoria(Integer id, Subcategoria detallesSubcategoria) {
        Subcategoria subcategoria = obtenerSubcategoriaPorId(id);
        subcategoria.setNombreSubcategoria(detallesSubcategoria.getNombreSubcategoria());
        subcategoria.setIdCategoria(detallesSubcategoria.getIdCategoria());
        return subcategoriaRepository.save(subcategoria);
    }

    @Override
    public void eliminarSubcategoria(Integer id) {
        Subcategoria subcategoria = obtenerSubcategoriaPorId(id);
        subcategoriaRepository.delete(subcategoria);
    }
}
