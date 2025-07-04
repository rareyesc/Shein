package shein.micro_correopedido.service;

import shein.micro_correopedido.entity.CorreoPedido;
import java.util.List;

public interface CorreoPedidoService {
    List<CorreoPedido> obtenerTodosLosCorreosPedidos();
    CorreoPedido obtenerCorreoPedidoPorId(Integer id);
    CorreoPedido crearCorreoPedido(CorreoPedido correoPedido);
    CorreoPedido actualizarCorreoPedido(Integer id, CorreoPedido correoPedido);
    void eliminarCorreoPedido(Integer id);
}
