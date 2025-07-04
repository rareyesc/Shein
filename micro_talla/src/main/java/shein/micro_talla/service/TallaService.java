package shein.micro_talla.service;

import shein.micro_talla.entity.Talla;
import java.util.List;

public interface TallaService {
    List<Talla> obtenerTodasLasTallas();
    Talla obtenerTallaPorId(Integer id);
    Talla crearTalla(Talla talla);
    Talla actualizarTalla(Integer id, Talla talla);
    void eliminarTalla(Integer id);
}
