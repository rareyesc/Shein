# Shein

Sistema de inventario compuesto por varios microservicios creados con Spring Boot y Java 17. Cada módulo aborda una parte del dominio del e‑commerce.

## Estructura del proyecto

- **micro_productos**: gestión de productos y subida de imágenes a S3
- **micro_pedido**: manejo de órdenes de compra
- **micro_correopedido**: envío de notificaciones por correo
- **micro_genero**, **micro_categoria**, **micro_subcategoria**, **micro_color**, **micro_talla**: catálogos auxiliares
- **micro_estado**: estados de un pedido

Cada servicio es un proyecto Maven independiente incluido en el POM padre.

| Servicio | Puerto |
| --- | --- |
| micro-categorias | 8090 |
| micro-color | 8091 |
| micro-correopedido | 8092 |
| micro-estado | 8093 |
| micro-genero | 8094 |
| micro-pedido | 8095 |
| micro-productos | 8096 |
| micro-subcategoria | 8097 |
| micro-talla | 8098 |

## Variables de entorno

Copia el archivo `.env.example` a `.env` y completa los valores de tus credenciales:

```bash
cp .env.example .env
```

**Importante:** asegúrate de no subir el archivo `.env` al repositorio para evitar exponer datos sensibles.

Antes de iniciar los microservicios carga las variables en la terminal para que Spring Boot pueda leerlas:

```bash
set -a
source .env
set +a
```

## Compilación y ejecución

1. Compila todos los módulos desde la raíz del proyecto:
   ```bash
   mvn clean package
   ```
2. Ejecuta el microservicio que necesites, por ejemplo el de productos:
   ```bash
   mvn -pl micro_productos spring-boot:run
   ```
