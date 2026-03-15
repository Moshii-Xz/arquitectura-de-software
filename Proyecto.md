# PROYECTO EXPERIENCIA FINAL DE DISEÑO (CAPSTONE DESIGN)

## CURSO ARQUITECTURA DE SOFTWARE

### PROGRAMA DE INGENIERÍA DE SISTEMAS

### UNIMAGDALENA

---

## Título del Proyecto

**Plataforma Digital de Agricultura Inteligente para Pequeños Productores del Magdalena**

---

## Descripción General

En el departamento del Magdalena, pequeños productores agrícolas con extensiones inferiores a cinco (5) hectáreas enfrentan dificultades para optimizar decisiones relacionadas con riego, fertilización y manejo fitosanitario debido a la variabilidad climática, la limitada disponibilidad de datos históricos y el bajo acceso a herramientas digitales especializadas.

En particular, asociaciones de productores rurales de municipios con conectividad intermitente dependen de decisiones empíricas que incrementan:

- El consumo ineficiente de agua.
- Los costos de insumos agrícolas.
- El riesgo de pérdida de cosechas.
- El impacto ambiental por sobreuso de fertilizantes.

Los beneficiarios directos del sistema serán pequeños productores agrícolas con acceso predominante a móviles de gama baja, sitios Web y conectividad limitada.  
Los beneficiarios indirectos incluyen asociaciones agrícolas locales, comercializadores regionales y comunidades que dependen de la producción agrícola para su seguridad alimentaria.

Se requiere diseñar la arquitectura de una plataforma digital que permita:

- Registrar información básica del cultivo.
- Integrar datos climáticos disponibles.
- Generar alertas y recomendaciones simples de acción.
- Operar en condiciones de conectividad intermitente.
- Escalar progresivamente en número de usuarios.

---

## Restricciones

La solución deberá desarrollarse bajo las siguientes restricciones explícitas, que deberán influir en las decisiones arquitectónicas:

### Restricciones Técnicas

- Conectividad intermitente en zonas rurales.
- Uso prioritario desde dispositivos móviles.
- Infraestructura de bajo costo.
- Capacidad limitada de soporte técnico en sitio.

### Restricciones Económicas y Temporales del Proyecto

- La arquitectura deberá diseñarse bajo un escenario de operación de bajo costo, justificando técnicamente que el costo estimado de infraestructura y mantenimiento es compatible con pequeños productores rurales.
- El diseño deberá considerar un equipo de desarrollo limitado (5 integrantes) y un periodo máximo de ejecución correspondiente a no mayor de 4 meses.
- Las decisiones arquitectónicas deberán demostrar equilibrio entre:
  - Costo
  - Tiempo de implementación
  - Atributos de calidad
  - Sostenibilidad tecnológica
- Las restricciones económicas y temporales no podrán comprometer los niveles mínimos aceptables de seguridad, confiabilidad y usabilidad definidos en el proyecto.

### Restricciones Ambientales

- El sistema debe promover el uso eficiente del agua y fertilizantes.
- Debe evitar generar recomendaciones que incrementen impacto ambiental negativo.

### Restricciones Sociales y Culturales

- Interfaz con lenguaje claro y comprensible.
- Bajo nivel de alfabetización digital en algunos usuarios.
- Adaptabilidad al contexto rural.

### Restricciones Normativas y Legales

- Protección de datos personales y productivos.
- Confidencialidad de información agrícola.
- Cumplimiento de principios básicos de seguridad de la información.

### Restricciones de Salud y Seguridad

- Las recomendaciones del sistema no deben poner en riesgo la salud del productor ni del consumidor.
- Debe contemplarse la trazabilidad básica de decisiones críticas.

### Restricciones Éticas

- **No sustitución irresponsable del criterio humano:** El sistema deberá diseñarse como herramienta de apoyo a la decisión y no como sustituto absoluto del juicio del productor.
- **Protección y uso responsable de datos:** La información productiva del agricultor no podrá:
  - Ser compartida sin autorización.
  - Ser utilizada para fines distintos al objetivo declarado del sistema.

El proyecto es abierto y no existe una única solución correcta. Los equipos deberán proponer, comparar y justificar alternativas arquitectónicas considerando atributos de calidad, restricciones del entorno y viabilidad técnica y económica.

---

## Objetivos

### Objetivo General

Diseñar la arquitectura de una plataforma digital para el monitoreo de cultivos y apoyo a la toma de decisiones agrícolas, considerando restricciones técnicas, económicas, ambientales, sociales, normativas y éticas, y asegurando coherencia entre requisitos, decisiones arquitectónicas y atributos de calidad.

### Objetivos Específicos

- Especificar los requisitos funcionales y los atributos de calidad del sistema, formulando escenarios técnicos verificables y delimitando el problema en su contexto real.
- Analizar las restricciones técnicas, económicas, ambientales, sociales, normativas, éticas y temporales que condicionan la viabilidad del sistema y su impacto en las decisiones arquitectónicas.
- Proponer y comparar alternativas arquitectónicas, evaluando sus implicaciones en costo, tiempo, complejidad, sostenibilidad y atributos de calidad.
- Seleccionar y justificar la arquitectura más adecuada mediante criterios técnicos explícitos y análisis de compensaciones (*trade-offs*) entre restricciones y objetivos del sistema.
- Validar la arquitectura definida mediante prototipo funcional, escenarios de calidad e indicadores técnicos medibles que evidencien el cumplimiento de las necesidades y limitaciones del contexto.

---

## Proceso de diseño de Ingeniería

### Condiciones de Desarrollo

- **Proceso de desarrollo:** Seleccionar metodología de desarrollo (Justificar).
- **Base de datos:** Definida por el equipo, debidamente justificada según restricciones técnicas y económicas.
- **Paradigma:** Orientado a Objetos.
- El diseño deberá considerar explícitamente restricciones de costo, tiempo, conectividad y sostenibilidad.

### Composición del Grupo

- Equipos de cinco (5) estudiantes.
- Asignación obligatoria de roles. Por ejemplo:
  - Líder técnico / Arquitecto
  - Analista de requisitos
  - Diseñador de datos
  - Desarrollador principal
  - Responsable de validación y calidad
- Se deberá presentar cronograma y distribución de responsabilidades.

---

## Productos Esperados

### Documento de Requerimientos

- Contexto del problema.
- Identificación de stakeholders.
- Diagramas de casos de uso.
- Especificación de requerimientos (ISO/IEC/IEEE 29148:2018).
- Plan, cronograma y presupuesto de desarrollo.
- Atributos de calidad formulados como escenarios medibles.
- Restricciones técnicas, económicas, sociales, normativas y éticas explícitas.

---

## Documento Comparación y Selección de Arquitectura

El equipo deberá demostrar el proceso de diseño mediante la comparación breve de dos alternativas arquitectónicas y la justificación de la seleccionada.

### 1. Alternativas Propuestas

Describir dos alternativas viables, indicando:

- Estilo arquitectónico.
- Idea general de estructura.
- Ventaja principal.
- Desventaja principal.

### 2. Tabla Comparativa (obligatoria)

Presentar una única tabla con los siguientes criterios mínimos:

- Costo relativo (alto / medio / bajo)
- Tiempo de implementación
- Escalabilidad
- Seguridad
- Complejidad técnica

Asignar una ponderación simple (ej: 1–5) y calcular un puntaje final.

### 3. Decisión Justificada

Explicar brevemente:

- Qué alternativa se selecciona.
- Qué criterios fueron determinantes.

### Análisis de Trade-offs

- Cómo influyeron las restricciones (económicas, técnicas, sociales).
- Qué se gana y qué se sacrifica con cada alternativa.
- Qué restricciones influyeron más en la decisión.
- Cómo se equilibraron costo, tiempo y atributos de calidad.

---

## Documento Diseño Arquitectónico Final

### Consideraciones

- Declarar explícitamente el estilo elegido.
- Explicar por qué responde mejor a:
  - Restricciones económicas.
  - Restricciones técnicas.
  - Atributos de calidad prioritarios.
- Indicar qué alternativa fue descartada y por qué.

### Modelo de datos

- Diagrama de clases.
- Diagrama de base de datos.

### Diseño de interfaces

- Wireframes o mockups.
- Navegación principal.
- Coherencia con la arquitectura.

### Componentes de la arquitectura

- Diagrama de componentes.
- Diagrama de paquetes.

### Despliegue

- Diagrama de despliegue.

### Registro de Decisiones Arquitectónicas

- Selección de metodología de desarrollo.
- Selección de estilo arquitectónico.
- Elección de tipo de base de datos.
- Estrategia de manejo de conectividad.

---

## Documento Final

Incluye todo lo anterior, la evidencia de la implementación (repositorio) y validación.

---

## Implementación del Prototipo (50%)

### Alcance mínimo esperado

- Implementar mínimo el 60% de los casos de uso priorizados.
- Al menos un flujo completo crítico.
- No se evalúa cantidad de pantallas.
- Se evalúa coherencia arquitectónica.

### Evidencias obligatorias

- Código organizado según la arquitectura definida.
- Separación clara de componentes.
- Uso coherente del modelo de dominio.
- Capturas o demostración funcional.

---

## Validación técnica

### Evaluación de Atributos de Calidad

- Seleccionar mínimo 5 atributos.
- Para cada atributo:
  - Escenario definido.
  - Prueba realizada.
  - Resultado observado.
  - Cumple / No cumple.
  - Explicación técnica.

### Impacto Comparativo

Análisis entre situación inicial vs sistema propuesto.

### Validación del Diseño frente a Restricciones Definidas

Tabla sugerida:

| Restricción | Tipo | Decisión Arquitectónica Asociada | Evidencia en Implementación | Resultado |
|------------|------|----------------------------------|-----------------------------|-----------|
| xxx        | xxx  | xxx                              | xxxx                        | Cumple / No Cumple |

---

## Evaluación

### Componentes

| Componente | Descripción | Ponderación |
|----------|------------|-------------|
| Especificación | Requisitos, restricciones, modelos y atributos de calidad | 60 |
| Comparación Arquitectura | Selección y justificación | 30 |
| Diseño software | Modelado y coherencia | 90 |
| Implementación | Construcción y validación | 100 |

**Total: 280 puntos**

---

## Criterios de Evaluación Asociados al SO2 (ABET)

| Indicador de Desempeño | Evidencia |
|----------------------|-----------|
| Define necesidades y restricciones | Documento de requisitos |
| Diseña solución con justificación | Diagramas y decisiones |
| Implementa y valida | Prototipo y evaluación |