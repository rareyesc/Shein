package shein.micro_talla.service;

import shein.micro_talla.entity.Talla;
import shein.micro_talla.exception.ResourceNotFoundException;
import shein.micro_talla.repository.TallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TallaServiceImpl implements TallaService {

    @Autowired
    private TallaRepository tallaRepository;

    @Override
    public List<Talla> obtenerTodasLasTallas() {
        return tallaRepository.findAll();
    }

    @Override
    public Talla obtenerTallaPorId(Integer id) {
        return tallaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Talla no encontrada con ID: " + id));
    }

    @Override
    public Talla crearTalla(Talla talla) {
        return tallaRepository.save(talla);
    }

    @Override
    public Talla actualizarTalla(Integer id, Talla detallesTalla) {
        Talla talla = obtenerTallaPorId(id);
        talla.setNombreTalla(detallesTalla.getNombreTalla());
        return tallaRepository.save(talla);
    }

    @Override
    public void eliminarTalla(Integer id) {
        Talla talla = obtenerTallaPorId(id);
        tallaRepository.delete(talla);
    }
}
