package shein.micro_color.service;

import shein.micro_color.entity.Color;
import java.util.List;

public interface ColorService {
    List<Color> obtenerTodosLosColores();
    Color obtenerColorPorId(Integer id);
    Color crearColor(Color color);
    Color actualizarColor(Integer id, Color color);
    void eliminarColor(Integer id);
}
