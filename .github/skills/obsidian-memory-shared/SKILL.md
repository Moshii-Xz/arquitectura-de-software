---
name: obsidian-memory-shared
description: Configura automáticamente un sistema de memoria compartida en Obsidian, creando la estructura de carpetas por niveles (crudo, canónico, curado) y los archivos de ejemplo necesarios para empezar a organizar el conocimiento de asistentes de IA.
---

# Habilidad: Configurar memoria compartida en Obsidian

Eres un asistente experto en organización del conocimiento. Tu tarea es configurar un vault de Obsidian con un sistema de memoria de 3 niveles, tal como se define en la guía de ShoafSystems.
| Tier | What goes here | Examples |
|------|---------------|---------|
| Tier 1: Raw bot memory | Logs, daily notes, drafts, raw outputs | agent-a/logs/2024-01-01.md, chat exports, session notes |
| Tier 2: Shared canonical pages | Durable facts about people, companies, projects, decisions | a person's role, a project's status, a decision record |
| Tier 3: Wiki sources + compiled | Curated syntheses worth keeping long-term | architecture notes, playbooks, research summaries |

Rule: raw observations go in Tier 1. Durable facts go in Tier 2. Curated knowledge goes in Tier 3.

## Instrucciones

Cuando el usuario invoque esta habilidad, debes seguir estos pasos secuencialmente:

### 1. Verificar el vault destino
Pregunta al usuario la ruta absoluta de su vault de Obsidian (la carpeta que contiene sus notas). Si no la proporciona, asume que el directorio actual es la raíz del vault.

### 2. Crear la estructura de carpetas
Dentro del vault, crea las siguientes carpetas (usa comandos del sistema operativo o crea los archivos directamente):
vault/
├── logs/ # Nivel 1: registros diarios
├── memory/ # Nivel 1: memoria en bruto (imports)
├── working/ # Nivel 1: borradores en progreso
└── shared/ # Nivel 2: hechos canónicos
├── people/
├── companies/
├── projects/
└── decisions/
wiki/
├── sources/ # Nivel 3: fuentes y referencias
└── compiled/ # Nivel 3: conocimiento curado final
tools/ # (opcional) scripts de ayuda

text

### 3. Crear archivos de ejemplo (opcional pero recomendado)
Dentro de `vault/shared/people/` crea un archivo `_template_persona.md` con este contenido:
```markdown
---
tipo: persona
estado: activo
---
# {{Nombre}}

## Rol

## Contexto relevante

## Relaciones

## Decisiones en las que participó
Dentro de vault/shared/decisions/ crea _template_decisión.md:

markdown
---
tipo: decision
fecha: {{YYYY-MM-DD}}
estado: propuesta | aceptada | obsoleta
---
# {{Título de la decisión}}

## Contexto

## Decisión

## Consecuencias

## Alternativas consideradas