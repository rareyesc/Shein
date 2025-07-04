package shein.micro_genero.service;

import shein.micro_genero.entity.Genero;
import java.util.List;

public interface GeneroService {
    List<Genero> obtenerTodosLosGeneros();
    Genero obtenerGeneroPorId(Integer id);
    Genero crearGenero(Genero genero);
    Genero actualizarGenero(Integer id, Genero genero);
    void eliminarGenero(Integer id);
}
