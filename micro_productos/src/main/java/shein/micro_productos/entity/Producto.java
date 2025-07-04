package shein.micro_productos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Entity
@Table(name = "producto")
@Data
@Schema(description = "Entidad que representa un producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del producto", example = "1")
    private Integer idProducto;

    @Column(name = "nombre_producto", nullable = false)
    @NotBlank(message = "El nombre del producto es obligatorio")
    @Schema(description = "Nombre del producto", example = "Camisa Casual")
    private String nombreProducto;

    @Column(name = "descripcion")
    @Schema(description = "Descripción del producto", example = "Camisa casual de manga larga")
    private String descripcion;

    @Column(name = "sku", unique = true)
    @Schema(description = "SKU del producto", example = "SKU-001")
    private String sku;

    @Column(name = "imagen")
    @Schema(description = "URL de la imagen del producto", example = "http://imagen.com/camisa.jpg")
    private String imagen;

    @Column(name = "precio_compra", nullable = false)
    @NotNull(message = "El precio de compra es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio de compra debe ser mayor que 0")
    @Schema(description = "Precio de compra del producto", example = "20.00")
    private Double precioCompra;

    @Column(name = "precio_sin_descuento")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio sin descuento debe ser mayor que 0")
    @Schema(description = "Precio sin descuento del producto", example = "30.00")
    private Double precioSinDescuento;

    @Column(name = "precio_venta", nullable = false)
    @NotNull(message = "El precio de venta es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio de venta debe ser mayor que 0")
    @Schema(description = "Precio de venta del producto", example = "25.00")
    private Double precioVenta;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    @Schema(description = "Fecha de creación del producto")
    private Date fechaCreacion;

    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    @Schema(description = "Fecha de última actualización del producto")
    private Date fechaActualizacion;

    // IDs de tablas relacionadas
    @Column(name = "id_categoria", nullable = false)
    @NotNull(message = "El ID de la categoría es obligatorio")
    @Schema(description = "ID de la categoría", example = "1")
    private Integer idCategoria;

    @Column(name = "id_subcategoria", nullable = false)
    @NotNull(message = "El ID de la subcategoría es obligatorio")
    @Schema(description = "ID de la subcategoría", example = "1")
    private Integer idSubcategoria;

    @Column(name = "id_genero", nullable = false)
    @NotNull(message = "El ID del género es obligatorio")
    @Schema(description = "ID del género", example = "1")
    private Integer idGenero;

    @Column(name = "id_color", nullable = false)
    @NotNull(message = "El ID del color es obligatorio")
    @Schema(description = "ID del color", example = "1")
    private Integer idColor;

    @Column(name = "id_talla", nullable = false)
    @NotNull(message = "El ID de la talla es obligatorio")
    @Schema(description = "ID de la talla", example = "1")
    private Integer idTalla;

    @Column(name = "id_estado", nullable = false)
    @NotNull(message = "El ID del estado es obligatorio")
    @Schema(description = "ID del estado", example = "1")
    private Integer idEstado;

    @Column(name = "id_pedido")
    @Schema(description = "ID del pedido asociado, si aplica", example = "1")
    private Integer idPedido;

    @PrePersist
    protected void onCreate() {
        fechaCreacion = new Date();
        fechaActualizacion = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        fechaActualizacion = new Date();
    }
}
