package shein.micro_categoria.service;

import shein.micro_categoria.entity.Categoria;
import java.util.List;

public interface CategoriaService {
    List<Categoria> obtenerTodasLasCategorias();
    Categoria obtenerCategoriaPorId(Integer id);
    Categoria crearCategoria(Categoria categoria);
    Categoria actualizarCategoria(Integer id, Categoria categoria);
    void eliminarCategoria(Integer id);
}
