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

Si usas **PowerShell**, puedes lograr el mismo efecto leyendo el archivo `.env` y
asignando cada par clave=valor a variables de entorno de la sesión. El script
omite las líneas que empiezan con `#` o aquellas en blanco:

```powershell
Get-Content .env |
  Where-Object { $_.Trim() -ne '' -and -not $_.Trim().StartsWith('#') } |
  ForEach-Object {
    $kv = $_ -split '=', 2
    $key = $kv[0].Trim()
    $val = $kv[1].Trim()
    # Asigna la variable de entorno en el scope del proceso actual
    Set-Item -Path "Env:$key" -Value $val
  }
```
Luego valida que las variables hubieran quedado cargadas correctamente:

```powershell
Get-ChildItem Env:DB_USERNAME,Env:DB_PASSWORD,Env:CLOUD_AWS_ACCESS_KEY,Env:CLOUD_AWS_SECRET_KEY,Env:CLOUD_AWS_REGION,Env:AWS_S3_BUCKET
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
