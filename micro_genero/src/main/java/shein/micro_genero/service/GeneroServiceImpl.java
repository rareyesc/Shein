package shein.micro_genero.service;

import shein.micro_genero.entity.Genero;
import shein.micro_genero.exception.ResourceNotFoundException;
import shein.micro_genero.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    public List<Genero> obtenerTodosLosGeneros() {
        return generoRepository.findAll();
    }

    @Override
    public Genero obtenerGeneroPorId(Integer id) {
        return generoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genero no encontrada con ID: " + id));
    }

    @Override
    public Genero crearGenero(Genero genero) {
        return generoRepository.save(genero);
    }

    @Override
    public Genero actualizarGenero(Integer id, Genero detallesGenero) {
        Genero genero = obtenerGeneroPorId(id);
        genero.setNombreGenero(detallesGenero.getNombreGenero());
        return generoRepository.save(genero);
    }

    @Override
    public void eliminarGenero(Integer id) {
        Genero genero = obtenerGeneroPorId(id);
        generoRepository.delete(genero);
    }
}
