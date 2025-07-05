# Shein

Sistema de inventario compuesto por varios microservicios creados con Spring Boot y Java 17. Cada módulo aborda una parte del dominio del e‑commerce.

## Estructura del proyecto

- **micro_productos**: gestión completa de productos e inventario, además de la subida de imágenes a S3.
- **micro_pedido**: manejo de órdenes de compra y persistencia de pedidos.
- **micro_correopedido**: envío de notificaciones de confirmación por correo.
- **micro_genero**: catálogo de géneros para clasificar productos.
- **micro_categoria**: categorías principales de la tienda.
- **micro_subcategoria**: subdivisiones de cada categoría.
- **micro_color**: colores disponibles para los productos.
- **micro_talla**: tallas de prendas y calzado.
- **micro_estado**: estados que puede tener un pedido.

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

## Funcionamiento general

Cada microservicio es una aplicación Spring Boot independiente que expone una API REST.
Todos comparten una base de datos MySQL llamada **e_commerce** y usan `springdoc-openapi`
para generar documentación interactiva. El microservicio de productos también
almacena imágenes en un bucket de S3 configurado mediante variables de entorno.
Puedes ejecutar los servicios de forma individual o en conjunto, según lo que
necesites probar.

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
2. Ejecuta el microservicio que necesites desde la terminal (por ejemplo el de
   productos):
   ```bash
   mvn -pl micro_productos spring-boot:run
   ```

   > **Nota:** si inicias un servicio haciendo clic en `Run` sobre la clase
   > `MicroXApplication` dentro de tu IDE, las variables definidas en `.env` no
   > se cargarán y Spring Boot fallará al obtener la configuración de la base de
   > datos o de AWS. Abre una terminal, carga las variables con `source .env` y
   > ejecuta el comando anterior para evitar ese problema.

Si prefieres iniciar los servicios directamente desde IntelliJ IDEA, instala el complemento EnvFile y configúralo en cada "Run Configuration" para cargar el archivo .env automáticamente. Con ello podrás usar el botón Run sin preocuparte por las variables de entorno.

## Documentación

Una vez iniciado un servicio abre tu navegador en
`http://localhost:<puerto>/swagger-ui/index.html` para
explorar su API. Ahí encontrarás todas las operaciones y modelos disponibles
para ese microservicio. Repite el proceso para cada módulo cambiando el puerto
correspondiente.

## Solución de problemas

Si al ejecutar `mvn -pl micro_x spring-boot:run` aparece un mensaje como
`Could not obtain connection to query metadata` y la aplicación se detiene,
generalmente se debe a que no se pudo conectar con MySQL. Revisa lo siguiente:

1. **MySQL activo:** valida que el servicio esté corriendo en `localhost:3306` y
   que la base `e_commerce` exista. Puedes probarlo desde la terminal con:
   ```bash
   mysql -u "$DB_USERNAME" -p"$DB_PASSWORD" -e "SELECT 1;"
   ```
2. **Variables de entorno en la misma terminal:** ejecuta `printenv DB_USERNAME`
   para confirmar que las variables se cargaron antes de iniciar el
   microservicio.
3. **Puerto diferente:** si tu servidor MySQL usa otro puerto o host, ajusta la
   propiedad `spring.datasource.url` en el archivo
   `src/main/resources/application.properties` del servicio correspondiente.

Con la base de datos accesible y las variables definidas, Spring Boot debería
iniciar sin problemas.
