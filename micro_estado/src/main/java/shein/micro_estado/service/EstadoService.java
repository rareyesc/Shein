package shein.micro_estado.service;

import shein.micro_estado.entity.Estado;
import java.util.List;

public interface EstadoService {
    List<Estado> obtenerTodosLosEstados();
    Estado obtenerEstadoPorId(Integer id);
    Estado crearEstado(Estado estado);
    Estado actualizarEstado(Integer id, Estado estado);
    void eliminarEstado(Integer id);
}
