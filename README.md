# AppSl75999886 - Aplicación Android



credenciales

  - **PAC001** / pass123 - Juan García
  - **PAC002** / pass456 - María López  
  - **PAC003** / pass789 - Carlos Rodríguez


### 2. **Menú Principal (BottomNavigation)**
Después de iniciar sesión, la aplicación muestra un menú inferior con dos opciones:

#### Opción 1: Tareas (Todos)
- Muestra: userId, id, title, completed
- Información: Número de tarea, usuario, título y estado

#### Opción 2: Fotos (Albums Pares)

- Muestra: albumId, id, title, thumbnailUrl
- Presentación: LazyRow horizontal con imágenes
- Información: Álbum, ID, título e imagen miniatura

### 3. **Tercera Opción: Salir**
- Cierra la sesión del usuario
- Regresa a la pantalla de login

### Compilar el Proyecto
```bash
./gradlew assembleDebug
```

### Ejecutar en Emulador
```bash
./gradlew installDebug
adb shell am start -n com.example.appsl75999886/.MainActivity
```

---

**Versión**: 1.0  
**Compilada con**: Kotlin 1.9.24 + Android SDK 34
