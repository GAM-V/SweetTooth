# Manual de Usuario para la Aplicación de Gestión de Consultorio Dental "SweetTooth"

## Características Principales del Sistema

La aplicación de gestión de consultorio dental está diseñada para facilitar la administración de un consultorio dental mediante varios módulos funcionales que permiten la gestión de citas, usuarios, empleados, pacientes y pagos. Las características principales incluyen:

- **Gestión de Citas**: Agendar, eliminar y consultar citas.
- **Gestión de Usuarios**: Registrar, modificar, mostrar información y eliminar usuarios.
- **Gestión de Empleados**: Registrar, modificar, mostrar información y eliminar empleados.
- **Gestión de Pacientes**: Registrar, modificar, mostrar información y eliminar pacientes.
- **Gestión de Pagos**: Realizar pagos de servicios.

## Instrucciones para la Configuración Inicial

### Paso 1: Crear la Carpeta de Base de Datos

1. En el directorio del usuario del sistema (ejemplo: `C:\Usuarios\TuUsuario` en Windows, crea una carpeta llamada `DataBaseSweetTooth`.
(Al iniciar el sistema por primera vez, támbien creará automáticamente la carpeta `DataBaseSweetTooth`.
)
2. Dentro de esta carpeta, copia y pega los archivos de la carpeta "Base de datos SweetTooth", que esta dentro del archivo comprimido.

### Paso 2: Iniciar el Sistema por Primera Vez

1. Abre el proyecto en el IDE NetBeans o Visual Studio Code.
2. Ejecuta el archivo `SweetTooth.java` que se encuentra en la ruta `SWEETTOOTH\src\main\java\com\SweetTooth.java`. 
## Modulos y Funcionalidades

### Módulo de Citas

- **Agendar Cita**
  1. Selecciona la opción "Agendar Cita" en el menú principal.
  2. Ingresa los detalles de la cita, incluyendo la fecha, hora, dentista, y el paciente.
  3. Guarda la cita para confirmarla en la base de datos.

- **Eliminar Cita**
  1. Selecciona la opción "Eliminar".
  2. Busca y selecciona un paciente y selecciona la cita que deseas eliminar.
  3. Haz clic en "Eliminar" y confirma la eliminación.

- **Consultar Citas**
  1. Selecciona la opción "Consultar".
  2. Busca y selecciona un paciente y selecciona la cita que deseas consultar.
  3. Haz clic en "Consultar" 

### Módulo de Usuarios

- **Registrar Usuario**
  1. Selecciona la opción "Registrar Usuario" en el menú principal.
  2. Ingresa los datos requeridos del usuario (nombre, rol, etc.).
  3. Haz clic en confirmar

- **Modificar Usuario**
  1. Selecciona la opción "Modificar Usuario".
  2. Busca y selecciona el usuario que deseas modificar.
  3. Realiza los cambios necesarios y haz clic en confirmar

- **Mostrar Información de Usuario**
  1. Selecciona la opción "Mostrar Información de Usuario".
  2. Busca y selecciona el usuario que deseas ver y haga clic en consultar.
  3. Visualiza la información del usuario en pantalla.

- **Eliminar Usuario**
  1. Selecciona la opción "Eliminar Usuario".
  2. Busca y selecciona el usuario que deseas eliminar.
  3. Haz clic en "Eliminar".

### Módulo de Empleados

- **Registrar Empleado**
  1. Selecciona la opción "Registrar Empleado" en el menú principal.
  2. Ingresa los datos requeridos del empleado (nombre, cargo, etc.).
  3. Haz clic en confirmar

- **Modificar Empleado**
  1. Selecciona la opción "Modificar Empleado".
  2. Busca y selecciona el empleado que deseas modificar.
  3. Realiza los cambios necesarios y haga clic en confirmar.

- **Mostrar Información de Empleado**
  1. Selecciona la opción "Mostrar Información de Empleado".
  2. Busca y selecciona el empleado que deseas ver y haga clic en consultar.
  3. Visualiza la información del empleado en pantalla.

- **Eliminar Empleado**
  1. Selecciona la opción "Consultar Empleados".
  2. Busca y selecciona el empleado que deseas eliminar.
  3. Haz clic en "Eliminar" y confirma la eliminación.

### Módulo de Pacientes

- **Registrar Paciente**
  1. Selecciona la opción "Registrar Paciente" en el menú principal.
  2. Ingresa los datos requeridos del paciente (nombre, fecha de nacimiento, etc.).
  3. Haz clic en confirmar

- **Modificar Paciente**
  1. Selecciona la opción "Modificar Pacientes".
  2. Busca y selecciona el paciente que deseas modificar.
  3. Realiza los cambios necesarios y haga clic en confirmar.

- **Mostrar Información de Paciente**
  1. Selecciona la opción "Mostrar Información de Paciente".
  2. Busca y selecciona el paciente que deseas ver.
  3. Haga clic en consultar.

- **Eliminar Paciente**
  1. Selecciona la opción "Eliminar Pacientes".
  2. Busca y selecciona el paciente que deseas eliminar.
  3. Haz clic en "Eliminar" y confirma la eliminación.

### Módulo de Pagos

- **Realizar Pago**
  1. Selecciona la opción "Realizar Pago" en el menú principal.
  2. Ingresa los detalles del pago, incluyendo información de la tarheta, el paciente, el monto y la fecha.
  3. Haga clic en confirmar.

