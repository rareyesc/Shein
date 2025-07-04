package shein.micro_estado.service;

import shein.micro_estado.entity.Estado;
import shein.micro_estado.exception.ResourceNotFoundException;
import shein.micro_estado.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public List<Estado> obtenerTodosLosEstados() {
        return estadoRepository.findAll();
    }

    @Override
    public Estado obtenerEstadoPorId(Integer id) {
        return estadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estado no encontrada con ID: " + id));
    }

    @Override
    public Estado crearEstado(Estado estado) {
        return estadoRepository.save(estado);
    }

    @Override
    public Estado actualizarEstado(Integer id, Estado detallesEstado) {
        Estado estado = obtenerEstadoPorId(id);
        estado.setNombreEstado(detallesEstado.getNombreEstado());
        return estadoRepository.save(estado);
    }

    @Override
    public void eliminarEstado(Integer id) {
        Estado estado = obtenerEstadoPorId(id);
        estadoRepository.delete(estado);
    }
}
