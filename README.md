<h1 align="center"> Challenge: LiterAlura - Catálogo de Libros</h1>

<p align="center">
  Un sistema de catálogo de libros que permite buscar obras literarias a través de una API, procesar los datos y almacenarlos en una base de datos para consultas posteriores. Desarrollado como proyecto final de la formación Java y Spring Boot de Alura Latam.
</p>

<hr>

<h2 align="center"> Funcionalidades</h2>

<ul>
  <li><strong>Búsqueda de libros por título:</strong> Consulta directa a la API Gutendex.</li>
  <li><strong>Listar libros registrados:</strong> Muestra todos los libros que han sido guardados en la base de datos.</li>
  <li><strong>Listar autores registrados:</strong> Muestra la información de los autores almacenados.</li>
  <li><strong>Listar autores vivos en un año determinado:</strong> Filtro inteligente para conocer autores de épocas específicas.</li>
  <li><strong>Listar libros por idioma:</strong> Filtro por siglas de idioma (es, en, fr, etc.).</li>
  <li><strong>Listar libros por género:</strong> Filtro por categoría o género del libro (por ejemplo: romance, drama, novela).</li>
</ul>

<hr>

<h2 align="center"> Lógica de Programación y Control</h2>

<p>Para asegurar una experiencia de usuario fluida y evitar que la aplicación falle, se implementaron controles estrictos:</p>

<ul>
  <li><strong>Manejo de Excepciones (try-catch):</strong> Se utiliza para gestionar posibles errores en la conexión con la API Gutendex o fallos inesperados en la persistencia de datos en la base de datos.</li>
  <li><strong>Mensajes Dinámicos al Usuario:</strong> Mediante estructuras <code>if-else</code>, el sistema comunica si:
    <ul>
      <li>Un libro no fue encontrado en la API.</li>
      <li>Un libro ya existe en la base de datos (evitando duplicados).</li>
      <li>No hay autores vivos registrados para el año consultado.</li>
      <li>La lista de libros o autores está vacía antes de intentar mostrarla.</li>
    </ul>
  </li>
  <li><strong>Validación de Entradas:</strong> Control de menús para asegurar que el usuario elija opciones válidas entre las disponibles.</li>
</ul>

<hr>

<h2 align="center"> Tecnologías y Conceptos</h2>

<ul>
  <li><strong>Java:</strong> Lenguaje principal del proyecto.</li>
  <li><strong>Spring Boot:</strong> Framework para agilizar el desarrollo.</li>
  <li><strong>Spring Data JPA:</strong> Para la persistencia de datos y mapeo objeto-relacional (ORM).</li>
  <li><strong>PostgreSQL / H2:</strong> Base de datos utilizada para almacenar libros y autores.</li>
  <li><strong>API Gutendex:</strong> Fuente de datos externa con más de 70,000 libros del Proyecto Gutenberg (sin necesidad de API Key).</li>
  <li><strong>Jackson:</strong> Para el análisis y manipulación de respuestas JSON.</li>
</ul>

<hr>

<h2 align="center"> Pasos de Desarrollo</h2>

<ol>
  <li><strong>Configuración del ambiente:</strong> Inicialización del proyecto con Spring Initializr.</li>
  <li><strong>Consumo de la API:</strong> Creación de la clase para realizar solicitudes HTTP a Gutendex.</li>
  <li><strong>Análisis JSON:</strong> Modelado de datos mediante <code>Records</code> y anotaciones de Jackson.</li>
  <li><strong>Persistencia:</strong> Configuración de entidades y repositorios para la base de datos.</li>
  <li><strong>Interfaz de Usuario:</strong> Menú textual por consola con 6 opciones de interacción.</li>
</ol>

<hr>

<h2 align="center"> Vista Previa del Sistema</h2>

<div align="center">
  <p><strong>Menú principal y opciones de interacción:</strong></p>
  <img width="404" alt="1" src="https://github.com/user-attachments/assets/ffa6039d-c479-4844-a189-2b27907a24e6" />
</div>

<br>

<div align="center">
  <p><strong>Búsqueda de libro por título:</strong></p>
  <img width="423" alt="2" src="https://github.com/user-attachments/assets/7bb5de92-2798-4225-ab41-9c5757f53d5a" />
</div>

<br>

<div align="center">
  <p><strong>Mostrar libros registrados:</strong></p>
  <img width="402" alt="4" src="https://github.com/user-attachments/assets/a601ee41-a0e4-492e-8408-1ea2a5e83f1f" />
</div>

<br>

<div align="center">
  <p><strong>Mostrar autores registrados:</strong></p>
  <img width="430" alt="12" src="https://github.com/user-attachments/assets/b6822014-4007-4ad0-8597-03c5422a920f" />
</div>

<br>

<div align="center">
  <p><strong>Mostrar autores vivos en un determinado año:</strong></p>
  <img width="424" alt="5" src="https://github.com/user-attachments/assets/65dd8917-7b25-4df6-a4b8-15f19b8da55f" />
</div>

<br>

<div align="center">
  <p><strong>Mostrar libros por idioma:</strong></p>
  <img width="429" alt="7" src="https://github.com/user-attachments/assets/3913be48-1203-44b8-8d4a-8b6694c1373c" />
</div>

<br>

<div align="center">
  <p><strong>Mostrar libros por género:</strong></p>
  <img width="397" alt="9" src="https://github.com/user-attachments/assets/1bde5c49-419c-423d-a452-5ea547fd7adb" />
</div>

<br>

<div align="center">
  <p><strong>Saliendo del programa:</strong></p>
  <img width="409" alt="11" src="https://github.com/user-attachments/assets/ca9e297f-f721-474c-aefe-5662c1f59768" />
</div>

<br>

<div align="center">
  <p><strong> Manejo de excepciones y validaciones:</strong></p>
  <img width="422" alt="3" src="https://github.com/user-attachments/assets/59ef59d8-25cb-4a71-a007-ce647d1f84e8" />
  <br><br>
  <img width="423" alt="6" src="https://github.com/user-attachments/assets/6cc689fe-b758-484c-a86d-7d28291e3d9d" />
  <br><br>
  <img width="406" alt="8" src="https://github.com/user-attachments/assets/700ad9a4-f8a0-4a6a-bfa7-b5d092d02680" />
  <br><br>
  <img width="383" alt="10" src="https://github.com/user-attachments/assets/bcbd74b7-72e7-4c48-ae3a-8c23f9833d4e" />
</div>

  
  
  
  
  
  
  
  
  
 
  
  

  
  
</p>
