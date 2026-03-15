# Stakeholders del Sistema

## 1. Identificación de Stakeholders

### Stakeholders Primarios

#### 1.1. Pequeños Productores Agrícolas
- **Rol:** Usuario final principal
- **Interés:** Mejorar decisiones de cultivo, optimizar recursos, aumentar rentabilidad
- **Necesidades:**
  - Interfaz simple e intuitiva
  - Recomendaciones claras y accionables
  - Funcionamiento sin conexión constante
  - Bajo costo de uso
- **Nivel de influencia:** Alto
- **Nivel de participación:** Diario

#### 1.2. Asociaciones Agrícolas Locales
- **Rol:** Organización de productores, intermediario
- **Interés:** Mejorar producción colectiva, capacitación, acceso a mercados
- **Necesidades:**
  - Seguimiento de múltiples productores
  - Reportes consolidados
  - Herramienta de capacitación
- **Nivel de influencia:** Medio-Alto
- **Nivel de participación:** Semanal

### Stakeholders Secundarios

#### 2.1. Comercializadores Regionales
- **Rol:** Compradores de producción
- **Interés:** Calidad y disponibilidad de productos
- **Necesidades:**
  - Previsión de cosechas
  - Trazabilidad básica
- **Nivel de influencia:** Medio
- **Nivel de participación:** Ocasional

#### 2.2. Entidades Gubernamentales
- **Rol:** Reguladores, promotores del desarrollo rural
- **Interés:** Desarrollo agrícola sostenible, seguridad alimentaria
- **Necesidades:**
  - Cumplimiento normativo
  - Datos agregados (anónimos) para políticas públicas
- **Nivel de influencia:** Medio
- **Nivel de participación:** Esporádico

#### 2.3. Proveedores de Insumos Agrícolas
- **Rol:** Suministradores de fertilizantes, semillas, herramientas
- **Interés:** Venta de productos, asesoría técnica
- **Necesidades:**
  - Información de demanda
  - Canal de comunicación con productores
- **Nivel de influencia:** Bajo-Medio
- **Nivel de participación:** Ocasional

### Stakeholders Técnicos

#### 3.1. Equipo de Desarrollo
- **Rol:** Diseñadores y desarrolladores del sistema
- **Interés:** Construir solución técnicamente viable y mantenible
- **Necesidades:**
  - Requisitos claros
  - Recursos técnicos adecuados
  - Tiempo suficiente para desarrollo
- **Nivel de influencia:** Alto
- **Nivel de participación:** Continuo (4 meses)

#### 3.2. Equipo de Soporte Técnico
- **Rol:** Mantenimiento y asistencia a usuarios
- **Interés:** Sistema estable, fácil de mantener
- **Necesidades:**
  - Documentación clara
  - Sistema con baja complejidad
  - Herramientas de monitoreo
- **Nivel de influencia:** Medio
- **Nivel de participación:** Continuo (post-implementación)

#### 3.3. Expertos Agrónomos
- **Rol:** Asesores técnicos en agricultura
- **Interés:** Validación de recomendaciones del sistema
- **Necesidades:**
  - Que las recomendaciones sean técnicamente correctas
  - Posibilidad de ajustar parámetros
- **Nivel de influencia:** Medio-Alto
- **Nivel de participación:** En fase de validación

## 2. Matriz de Stakeholders

| Stakeholder | Poder | Interés | Estrategia |
|------------|-------|---------|------------|
| Pequeños Productores | Alto | Alto | Gestionar de cerca |
| Asociaciones Agrícolas | Medio-Alto | Alto | Gestionar de cerca |
| Equipo de Desarrollo | Alto | Alto | Gestionar de cerca |
| Expertos Agrónomos | Medio-Alto | Alto | Mantener satisfechos |
| Comercializadores | Medio | Medio | Mantener informados |
| Entidades Gubernamentales | Medio | Medio | Mantener informados |
| Equipo de Soporte | Medio | Alto | Mantener satisfechos |
| Proveedores de Insumos | Bajo-Medio | Medio | Monitorear |

## 3. Conflictos Potenciales entre Stakeholders

### Conflicto 1: Simplicidad vs. Funcionalidad Avanzada
- **Stakeholders:** Productores (simplicidad) vs. Asociaciones/Expertos (más funciones)
- **Resolución:** Priorizar simplicidad con opción de funciones avanzadas opcionales

### Conflicto 2: Privacidad de Datos vs. Análisis Agregado
- **Stakeholders:** Productores (privacidad) vs. Entidades Gubernamentales (datos)
- **Resolución:** Anonimización de datos, consentimiento explícito

### Conflicto 3: Costo de Desarrollo vs. Funcionalidades
- **Stakeholders:** Financiadores (bajo costo) vs. Usuarios (más funciones)
- **Resolución:** Desarrollo por fases, MVP primero

## 4. Requisitos por Stakeholder

### De los Productores
- Interfaz en español, lenguaje claro
- Notificaciones simples y oportunas
- Funcionamiento offline
- Sin costo o muy bajo costo

### De las Asociaciones
- Panel de seguimiento grupal
- Reportes exportables
- Gestión de múltiples usuarios

### Del Equipo de Desarrollo
- Tecnologías conocidas y documentadas
- Arquitectura escalable
- Tiempo realista de 4 meses

### De Expertos Agrónomos
- Recomendaciones basadas en evidencia científica
- Transparencia en algoritmos de decisión
- Posibilidad de personalización por región/cultivo
