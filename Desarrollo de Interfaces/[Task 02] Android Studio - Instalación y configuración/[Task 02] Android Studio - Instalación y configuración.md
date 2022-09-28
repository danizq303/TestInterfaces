# [Task 02] Android Studio - Instalación y configuración

Alumno: Daniel Izquierdo Bonilla

## Instalacion Android Studio y Configuracion
- Abriremos el instalador.

![](i1.png)

- Le daremos a siguiente hasta llegar a la siguiente pantalla.

![](i2.png)

- Le daremos a "Install"

- Abriremos Android Studio y le daremos a Next.

![](i3.png)

- Seleccionaremos "Standard" y le daremos a Next.

![](i4.png)

- Seleccionaremos el tema que prefiramos y le daremos a Next.

![](i5.png)

- Le daremos a Next.

![](i6.png)

- Aceptaremos los acuerdos de licencia y le daremos a Finish.

![](i7.png)

- Le daremos a Finish.

![](i8.png)

- Abriremos Android Studio

- Seleccionaremos "Customize"

![](c1.png)

- Iremos al menu de Buld, Execution, Deployment -> Compiler y marcaremos la opcion mostrada. (Sirve para maximizar todos los recursos y disponibles y así maximizar el rendimiento de Android Studio).

![](c2.png)

- Iremos al menu de Editor -> File Types y en la opcion de "Ignored Files and Folders" añadiremos "thumbs.db". (Esto sirve para elminar las imágenes en caché de nuestro proyecto).

![](c3.png)

- Iremos al menu de Appearence & Behavior -> System Setting -> Memory Settings y cambiaremos la memoria que dedicamos al IDE a 4096. (La finalidad de esta configuración es permitir a Android Studio usar hasta 4096MB de ram).

![](c4.png)

- Le daremos a aplicar y en la ventana que nos aparezca le daremos a Yes.

![](c5.png)

- Le daremos a la rueda de abajo a la izquierda y seleccionaremos "Edit Custom VM Options".

![](c6.png)

- Escribiremos los siguientes parametros.
```
-Xmx8192
-Xms4096
```
El comando xmx es el maximo de ram que se destinará a Android Studio y el xms el minimo de ram reservada para Android Studio.

![](c7.png)

## Instalacion Bluestacks y Configuracion
- Seleccionaremos "Instalar Ahora".

![](b1.png)

- Abriremos Ajustes -> Avanzado y activaremos el puente ADB. (El objetivo de esto es poder ejecutar las aplicaciones de Android Studio a través de BlueStacks).

![](b2.png)

## Integrar Android Studio con Git
- En el menu de inicio le daremos a Get from VCS.

![](g1.png)

- Pegaremos la url del repositorio y le daremos a "Clone".

![](g2.png)

- Automaticamente nos cargará el proyecto que hemos clonado.

![](g3.png)

- Prueba de que el proyecto se ha ejecutrado correctamente.

![](g4.png)