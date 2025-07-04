package shein.micro_correopedido.service;

import shein.micro_correopedido.entity.CorreoPedido;
import shein.micro_correopedido.exception.ResourceNotFoundException;
import shein.micro_correopedido.repository.CorreoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CorreoPedidoServiceImpl implements CorreoPedidoService {

    @Autowired
    private CorreoPedidoRepository correoPedidoRepository;

    @Override
    public List<CorreoPedido> obtenerTodosLosCorreosPedidos() {
        return correoPedidoRepository.findAll();
    }

    @Override
    public CorreoPedido obtenerCorreoPedidoPorId(Integer id) {
        return correoPedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Correo de Pedido no encontrado con ID: " + id));
    }

    @Override
    public CorreoPedido crearCorreoPedido(CorreoPedido correoPedido) {
        return correoPedidoRepository.save(correoPedido);
    }

    @Override
    public CorreoPedido actualizarCorreoPedido(Integer id, CorreoPedido detallesCorreoPedido) {
        CorreoPedido correoPedido = obtenerCorreoPedidoPorId(id);
        correoPedido.setNombreCorreoPedido(detallesCorreoPedido.getNombreCorreoPedido());
        return correoPedidoRepository.save(correoPedido);
    }

    @Override
    public void eliminarCorreoPedido(Integer id) {
        CorreoPedido correoPedido = obtenerCorreoPedidoPorId(id);
        correoPedidoRepository.delete(correoPedido);
    }
}
