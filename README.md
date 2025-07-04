# Shein
Inventario para Shein

## Variables de entorno
Para ejecutar los microservicios es necesario definir varias variables de entorno. Se incluye el archivo `.env.example` como plantilla.

1. Copia este archivo y crea uno llamado `.env` en la raíz del proyecto:
   
   ```bash
   cp .env.example .env
   ```

2. Edita `.env` y reemplaza los valores de ejemplo con tus credenciales reales.
3. Antes de iniciar los servicios, carga las variables en tu terminal:

   ```bash
   set -a
   source .env
   set +a
   ```

De esta forma Spring Boot tomará las variables al arrancar cada microservicio.
