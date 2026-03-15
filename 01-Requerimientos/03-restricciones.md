# Restricciones del Sistema

## 1. Restricciones Técnicas

### RT-01: Conectividad Intermitente
- **Descripción:** El sistema debe funcionar en zonas con conexión a internet limitada o intermitente
- **Implicaciones arquitectónicas:**
  - Implementar modo offline con sincronización
  - Cacheo local de datos críticos
  - Minimizar dependencias de servicios externos en tiempo real
  - Estrategia de cola de operaciones pendientes

### RT-02: Dispositivos Móviles de Gama Baja
- **Descripción:** Usuarios acceden principalmente desde smartphones Android de gama baja
- **Implicaciones arquitectónicas:**
  - Aplicación ligera (< 20 MB)
  - Optimización de recursos (memoria, CPU)
  - Interfaz responsive y adaptable
  - Soporte para Android 7.0+ mínimo
  - Considerar Progressive Web App como alternativa

### RT-03: Infraestructura de Bajo Costo
- **Descripción:** Presupuesto limitado para servidores y servicios cloud
- **Implicaciones arquitectónicas:**
  - Uso de servicios gratuitos o de bajo costo
  - Optimización de consultas a servicios externos
  - Arquitectura eficiente en recursos
  - Considerar servicios compartidos o serverless

### RT-04: Capacidad Limitada de Soporte Técnico
- **Descripción:** No hay personal técnico permanente en campo
- **Implicaciones arquitectónicas:**
  - Sistema auto-gestionable
  - Actualizaciones automáticas
  - Monitoreo y alertas proactivas
  - Documentación clara para usuarios
  - Interfaz intuitiva que minimice errores

---

## 2. Restricciones Económicas y Temporales

### RE-01: Presupuesto de Operación
- **Descripción:** Costo mensual de infraestructura debe ser asequible para productores rurales
- **Meta:** < $50 USD/mes para infraestructura completa
- **Implicaciones:**
  - Hosting compartido o serverless
  - Base de datos gratuita o de bajo costo
  - APIs con tier gratuito
  - Sin licencias costosas

### RE-02: Equipo Limitado
- **Descripción:** Equipo de 5 integrantes
- **Roles:**
  - 1 Líder técnico / Arquitecto
  - 1 Analista de requisitos
  - 1 Diseñador de datos
  - 1 Desarrollador principal
  - 1 Responsable de validación y calidad
- **Implicaciones:**
  - Tecnologías conocidas por el equipo
  - Evitar complejidad innecesaria
  - Reutilización de componentes existentes

### RE-03: Tiempo de Desarrollo
- **Descripción:** Máximo 4 meses para desarrollo completo
- **Cronograma sugerido:**
  - Mes 1: Requisitos y diseño arquitectónico
  - Mes 2: Desarrollo del núcleo del sistema
  - Mes 3: Desarrollo de funcionalidades complementarias
  - Mes 4: Pruebas, validación y ajustes
- **Implicaciones:**
  - Desarrollo ágil e iterativo
  - MVP (Minimum Viable Product) primero
  - Priorización estricta de funcionalidades

### RE-04: Equilibrio Costo-Tiempo-Calidad
- **Descripción:** Las decisiones deben balancear:
  - Costo de implementación y operación
  - Tiempo de desarrollo
  - Atributos de calidad (seguridad, confiabilidad, usabilidad)
  - Sostenibilidad tecnológica a largo plazo

---

## 3. Restricciones Ambientales

### RA-01: Uso Eficiente de Recursos Naturales
- **Descripción:** El sistema debe promover prácticas sostenibles
- **Requisitos:**
  - Recomendaciones que optimicen uso de agua
  - Sugerencias de fertilización precisa (evitar excesos)
  - Alertas sobre prácticas que generen impacto negativo

### RA-02: Impacto Ambiental Negativo
- **Descripción:** Prohibición de recomendaciones que dañen el ecosistema
- **Requisitos:**
  - Validación de recomendaciones por expertos
  - No sugerir sobreexplotación de suelos
  - Promover biodiversidad cuando sea posible

---

## 4. Restricciones Sociales y Culturales

### RS-01: Lenguaje Claro y Comprensible
- **Descripción:** Interfaz en español simple, sin tecnicismos innecesarios
- **Requisitos:**
  - Vocabulario adaptado a contexto rural
  - Iconografía universal
  - Instrucciones paso a paso
  - Mensajes de error comprensibles

### RS-02: Alfabetización Digital Limitada
- **Descripción:** Usuarios con bajo nivel de experiencia tecnológica
- **Requisitos:**
  - Navegación intuitiva
  - Flujos simples y lineales
  - Tutoriales interactivos
  - Confirmaciones claras antes de acciones críticas
  - Opciones de ayuda contextual

### RS-03: Adaptabilidad al Contexto Rural
- **Descripción:** El sistema debe respetar y adaptarse a prácticas locales
- **Requisitos:**
  - Considerar calendario agrícola local
  - Unidades de medida comunes en la región
  - Flexibilidad para adaptar a cultivos específicos del Magdalena

---

## 5. Restricciones Normativas y Legales

### RN-01: Protección de Datos Personales
- **Descripción:** Cumplimiento con Ley 1581 de 2012 (Colombia) - Habeas Data
- **Requisitos:**
  - Consentimiento informado para recolección de datos
  - Política de privacidad clara
  - Derecho a consulta, actualización y rectificación
  - Derecho a eliminación de datos
  - Cifrado de información sensible

### RN-02: Confidencialidad de Información Agrícola
- **Descripción:** Los datos productivos son sensibles comercialmente
- **Requisitos:**
  - No compartir datos entre productores sin autorización
  - Anonimización para análisis agregados
  - Autenticación y autorización robustas

### RN-03: Seguridad de la Información
- **Descripción:** Principios básicos de seguridad (CIA: Confidentiality, Integrity, Availability)
- **Requisitos:**
  - Comunicaciones cifradas (HTTPS)
  - Contraseñas seguras
  - Backup periódico de datos
  - Logs de auditoría para acciones críticas

---

## 6. Restricciones de Salud y Seguridad

### RSS-01: Recomendaciones Seguras
- **Descripción:** Las sugerencias del sistema no deben poner en riesgo la salud
- **Requisitos:**
  - Validación de recomendaciones por expertos agrónomos
  - Disclaimers apropiados
  - Información sobre uso seguro de productos químicos
  - Alertas sobre prácticas peligrosas

### RSS-02: Trazabilidad de Decisiones Críticas
- **Descripción:** Registro de recomendaciones importantes para auditoría
- **Requisitos:**
  - Log de alertas enviadas
  - Historial de recomendaciones por cultivo
  - Registro de acciones tomadas por el usuario
  - Posibilidad de rastrear causas de problemas

---

## 7. Restricciones Éticas

### RE-01: Herramienta de Apoyo, No Sustituto
- **Descripción:** El sistema es apoyo a la decisión, el productor tiene la última palabra
- **Requisitos:**
  - Recomendaciones como sugerencias, no órdenes
  - Explicación del razonamiento detrás de recomendaciones
  - Opciones para que el usuario registre sus propias decisiones
  - Disclaimer claro sobre limitaciones del sistema

### RE-02: Uso Responsable de Datos
- **Descripción:** La información del productor se usa exclusivamente para el objetivo declarado
- **Requisitos:**
  - Prohibición de venta de datos a terceros
  - Uso de datos solo para funcionalidad del sistema
  - Transparencia total sobre qué datos se recopilan y por qué
  - Consentimiento explícito para cualquier uso secundario

### RE-03: No Discriminación
- **Descripción:** El sistema debe ser accesible para todos los productores sin exclusión
- **Requisitos:**
  - Sin barreras económicas prohibitivas
  - Considerar accesibilidad para personas con discapacidades
  - No favorecer a ciertos tipos de cultivos o productores

---

## 8. Matriz de Impacto de Restricciones

| ID | Restricción | Impacto en Arquitectura | Prioridad | Dificultad |
|----|-------------|------------------------|-----------|------------|
| RT-01 | Conectividad intermitente | Alto | Crítica | Alta |
| RT-02 | Dispositivos gama baja | Alto | Crítica | Media |
| RT-03 | Bajo costo infraestructura | Alto | Crítica | Media |
| RT-04 | Soporte técnico limitado | Medio | Alta | Media |
| RE-01 | Presupuesto operación | Alto | Crítica | Alta |
| RE-02 | Equipo limitado | Medio | Alta | Media |
| RE-03 | 4 meses desarrollo | Alto | Crítica | Alta |
| RA-01 | Uso eficiente recursos | Medio | Alta | Baja |
| RS-01 | Lenguaje claro | Medio | Alta | Baja |
| RS-02 | Baja alfabetización digital | Alto | Crítica | Media |
| RN-01 | Protección datos | Alto | Crítica | Media |
| RE-01 | No sustitución humana | Bajo | Media | Baja |

---

## 9. Restricciones No Negociables

Las siguientes restricciones son **obligatorias** y no pueden ser comprometidas:

1. **Seguridad de datos personales** (RN-01)
2. **Funcionamiento offline básico** (RT-01)
3. **Presupuesto de operación bajo** (RE-01)
4. **Tiempo de desarrollo de 4 meses** (RE-03)
5. **Usabilidad para baja alfabetización digital** (RS-02)
6. **Recomendaciones seguras y validadas** (RSS-01)
