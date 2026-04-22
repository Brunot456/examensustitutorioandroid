# AppSl75999886 - Aplicación Móvil Android en Kotlin



## Características Principales

### 1. **Autenticación de Pacientes (Login)**
- Pantalla de login con campos: código de paciente y contraseña
- 3 pacientes de prueba precargados en la base de datos ROOM:
  - **PAC001** / pass123 - Juan García
  - **PAC002** / pass456 - María López  
  - **PAC003** / pass789 - Carlos Rodríguez
- Validación de credenciales
- Almacenamiento en base de datos SQLite con ROOM

### 2. **Menú Principal (BottomNavigation)**
Después de iniciar sesión, la aplicación muestra un menú inferior con dos opciones:

#### Opción 1: Tareas (Todos)
- Consume: `https://jsonplaceholder.typicode.com/todos`
- Muestra: userId, id, title, completed
- Presentación: LazyColumn vertical
- Información: Número de tarea, usuario, título y estado

#### Opción 2: Fotos (Albums Pares)
- Consume: `https://jsonplaceholder.typicode.com/photos`
- Filtra: Solo muestra fotos con albumId PAR
- Muestra: albumId, id, title, thumbnailUrl
- Presentación: LazyRow horizontal con imágenes
- Información: Álbum, ID, título e imagen miniatura

### 3. **Tercera Opción: Salir**
- Cierra la sesión del usuario
- Regresa a la pantalla de login

## Compilación y Ejecución

### Requisitos
- Android Studio Arctic Fox o superior
- Android SDK 24+
- Java 11+
- Gradle 8.5+

### Compilar el Proyecto
```bash
./gradlew assembleDebug
```

### Generar APK
```bash
./gradlew assembleDebug
```
La APK se genera en: `app/build/outputs/apk/debug/app-debug.apk`

### Ejecutar en Emulador
```bash
./gradlew installDebug
adb shell am start -n com.example.appsl75999886/.MainActivity
```

---

**Versión**: 1.0  
**Compilada con**: Kotlin 1.9.24 + Android SDK 34
