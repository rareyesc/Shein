package shein.micro_subcategoria.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "subcategoria")
@Data
@Schema(description = "Entidad que representa una subcategoría")
public class Subcategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único de la subcategoría", example = "1")
    private Integer idSubcategoria;

    @Column(name = "nombre_subcategoria", nullable = false)
    @NotBlank(message = "El nombre de la subcategoría es obligatorio")
    @Schema(description = "Nombre de la subcategoría", example = "Zapatos Deportivos")
    private String nombreSubcategoria;

    @Column(name = "id_categoria", nullable = false)
    @NotNull(message = "El ID de la categoría es obligatorio")
    @Schema(description = "ID de la categoría a la que pertenece", example = "1")
    private Integer idCategoria;
}
