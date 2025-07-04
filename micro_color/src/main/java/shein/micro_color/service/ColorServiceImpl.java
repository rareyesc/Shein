package shein.micro_color.service;

import shein.micro_color.entity.Color;
import shein.micro_color.exception.ResourceNotFoundException;
import shein.micro_color.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public List<Color> obtenerTodosLosColores() {
        return colorRepository.findAll();
    }

    @Override
    public Color obtenerColorPorId(Integer id) {
        return colorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Color no encontrada con ID: " + id));
    }

    @Override
    public Color crearColor(Color color) {
        return colorRepository.save(color);
    }

    @Override
    public Color actualizarColor(Integer id, Color detallesColor) {
        Color color = obtenerColorPorId(id);
        color.setNombreColor(detallesColor.getNombreColor());
        return colorRepository.save(color);
    }

    @Override
    public void eliminarColor(Integer id) {
        Color color = obtenerColorPorId(id);
        colorRepository.delete(color);
    }
}
