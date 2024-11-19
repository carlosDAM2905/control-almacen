# 🏬 Control de Almacén

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

> **Estado del proyecto:** 🚧 **EN CONSTRUCCIÓN** 🚧

Sistema de gestión de almacenes desarrollado en Java, utilizando Hibernate como framework ORM y MySQL como base de datos. Este proyecto permite administrar empleados, productos y ubicaciones, además de realizar consultas sobre el inventario.

---

## 🌟 **Características**

- 📋 **Gestión de empleados**: Registro, actualización y eliminación de datos.
- 📦 **Gestión de productos**: Alta, modificación y eliminación de productos.
- 📊 **Consultas de inventario**: Visualización de productos y ubicaciones.
- 🔄 **En desarrollo**:
  - Generación de reportes.
  - Implementación de interfaz gráfica con JavaFX.

---

## 🛠️ **Tecnologías utilizadas**

- **Lenguaje:** Java ☕
- **Framework ORM:** Hibernate 🏗️
- **Base de datos:** MySQL 🗄️
- **Gestión de dependencias:** Maven 📦
- **IDE recomendado:** IntelliJ IDEA 💻

---

## 📂 **Estructura del proyecto**


```plaintext
gestion_almacen/
├── .idea/                         # Archivos de configuración de IntelliJ IDEA
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example/
│   │   │       ├── app/           # Lógica principal de la aplicación
│   │   │       ├── dao/           # Clases de acceso a datos (DAO)
│   │   │       ├── entity/        # Clases que representan entidades (Empleado, Producto, etc.)
│   │   │       ├── logic/         # Lógica de negocio
│   │   │       ├── ui/            # Interfaz de usuario
│   │   │       ├── util/          # Utilidades auxiliares
│   │   │       └── esquema/       # Esquemas de base de datos
│   │   └── resources/             # Archivos de configuración (hibernate.cfg.xml, etc.)
│   ├── test/
│   │   ├── java/
│   │   │   └── com.example/       # Clases de prueba
├── target/                        # Archivos compilados por Maven
├── .gitignore                     # Archivos y carpetas ignorados por Git
├── gestion_almacen.iml            # Archivo de configuración del proyecto en IntelliJ IDEA
├── pom.xml                        # Archivo de configuración de Maven



# ⚙️ Instalación y configuración

## Requisitos previos

- **Java 17** o superior.
- Un servidor **MySQL** activo.
- **Maven** para la gestión de dependencias.

---

## Pasos para ejecutar el proyecto

### 1. Clona el repositorio:
```bash
git clone https://github.com/carlosDAM2905/control-almacen.git

## 2. Configura la base de datos:

Crea una base de datos llamada `control_almacen`:

```sql
CREATE DATABASE control_almacen;

## 3. Configura las credenciales:

Edita el archivo `hibernate.cfg.xml` y ajusta las credenciales de la base de datos:

```xml
<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/control_almacen</property>
<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password">tu_contraseña</property>

## 4. Ejecuta el proyecto:

1. Abre el proyecto en **IntelliJ IDEA** o tu IDE favorito.
2. Ejecuta la clase `Main` para iniciar la aplicación.

---

## 🛠️ En desarrollo:

- [ ] Implementar interfaz gráfica con JavaFX.
- [ ] Generar reportes dinámicos.
- [ ] Mejorar el manejo de errores y validaciones.

