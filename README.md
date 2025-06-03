# 🐾 PetCare App

Aplicación móvil desarrollada en **Android con Kotlin** utilizando **Jetpack Compose**. El objetivo es brindar una solución moderna e intuitiva para usuarios que buscan productos para sus mascotas, permitiéndoles explorar productos destacados, gestionar sus favoritos y autenticarse mediante una API externa.

---

## 📱 Características principales

- ✅ **Onboarding** animado con carrusel visual
- 🔐 **Login** con autenticación usando API REST (`dummyjson.com`)
- 🛒 **Visualización de productos** destacados (mocked o traídos desde el backend)
- ❤️ **Agregar/Remover favoritos** con persistencia local (Room)
- 🧭 **Navegación estructurada** con `NavController` y rutas dinámicas
- 🌐 **Integración con Retrofit** para consumo de APIs REST
- 💾 **Persistencia con Room** para favoritos
- 🧠 **Arquitectura basada en MVVM** con ViewModels y repositorios

---

## 🧱 Tecnologías y librerías

- **Kotlin** - Lenguaje principal
- **Jetpack Compose** - UI declarativa moderna
- **Room** - Persistencia local
- **Retrofit** - Consumo de APIs
- **Hilt** - Inyección de dependencias
- **Material 3** - Interfaz basada en los principios modernos de Google
- **Coroutines & Flow** - Lógica asíncrona y gestión de estado reactivo

---

## 🧪 Cómo ejecutar el proyecto

1. Cloná este repositorio:
   ```bash
   git clone https://github.com/tu_usuario/petcare-app.git
   cd petcare-app
Asegurate de tener:

Android Studio Hedgehog o superior

JDK 17

Un emulador o dispositivo físico con conexión a internet

En AndroidManifest.xml, asegurate de tener permisos de red:

xml
Copy
Edit
<uses-permission android:name="android.permission.INTERNET" />
Corré la app desde Android Studio.

🔐 Credenciales de prueba
Utilizá este usuario para probar el login con la API:

makefile
Copy
Edit
Username: emilys
Password: emilyspass
Fuente: https://dummyjson.com/users

### 📁 Estructura del proyecto

ar.edu.ort.trabajopractico/
├── components/              # Composables reutilizables (botones, cards, etc.)
├── core/                   # Utilidades generales o clases base (si las hubiera)
├── data/                   # Modelos, DAOs, API y DTOs
│   ├── api/                # Interfaces de Retrofit y cliente HTTP
│   └── local/              # Room: DAOs, entidades y base de datos
├── di/                     # Módulos de Hilt para inyección de dependencias
├── navigation/             # Navegación: rutas, NavGraph, helpers
├── repository/             # Repositorios que encapsulan la lógica de acceso a datos
├── screens/                # Pantallas de la app (onboarding, login, home, etc.)
├── ui.theme/               # Temas, colores, tipografía y estilos de UI
├── viewmodels/             # ViewModels con lógica de estado y comunicación con repos
├── AppTrabajoPractico.kt   # Composable raíz con configuración general (Scaffold)
├── MainActivity.kt         # Entry point de la app
├── MainActivityViewModel.kt# ViewModel general para control de barras o rutas
├── MainNavActions.kt       # Acciones de navegación encapsuladas
└── MainRouteNavGraph.kt    # Definición de la navegación principal (NavHost)




🎯 Backlog (próximas mejoras)
Registro de nuevos usuarios

Recuperación de contraseña

Carrito de compras funcional

Detalle por producto

Swipe real del carrusel de onboarding

Testing unitario y UI con JUnit + Compose Test

👨‍👩‍👧‍👦 Equipo de desarrollo
Proyecto realizado en el marco de la cátedra de Desarrollo de Aplicaciones Móviles - ORT Argentina

Matthew McCrea Steele

Azul Pavlotsky

Micaela Cuello

🏁 Conclusión
PetCare representa una base sólida para proyectos con arquitectura moderna, aprovechando las ventajas de Jetpack Compose, Retrofit y Room. Su estructura modular permite escalar fácilmente funcionalidades y adaptarse a necesidades reales de usuarios finales.
