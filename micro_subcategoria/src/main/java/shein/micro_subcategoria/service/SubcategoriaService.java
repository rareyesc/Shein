package shein.micro_subcategoria.service;

import shein.micro_subcategoria.entity.Subcategoria;
import java.util.List;

public interface SubcategoriaService {
    List<Subcategoria> obtenerTodasLasSubcategorias();
    Subcategoria obtenerSubcategoriaPorId(Integer id);
    Subcategoria crearSubcategoria(Subcategoria subcategoria);
    Subcategoria actualizarSubcategoria(Integer id, Subcategoria subcategoria);
    void eliminarSubcategoria(Integer id);
}
