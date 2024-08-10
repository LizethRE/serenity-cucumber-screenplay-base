# Proyecto Automatización Web
Proyecto base para la automatización de pruebas de aplicaciones web utilizando Serenity BDD, Cucumber y el patrón Screenplay.

## Contenido
* [Prerrequisitos](#prerrequisitos)
* [Instalación](#instalación)
* [Estructura del Proyecto](#estructura-del-proyecto)
* [Ejecución de Pruebas](#ejecución-de-pruebas)
* [Reportería](#reportería)
* [Licencia](#licencia)

## Prerrequisitos
* Java JDK 17 o superior
* IDE (Intellij o Eclipse)

## Instalación
Clona el repositorio:
```shell
git clone https://github.com/LizethRE/serenity-cucumber-screenplay-base.git
```
```shell
cd serenity-cucumber-screenplay-base
```

## Estructura del Proyecto
```Gherkin
src
├── main
│   └── java (com.base.certification)     # Estructura del Patrón Screenplay
│       └── abilities                     # Habilidades
│       └── model                         # Objectos de negocio
│       └── questions                     # Aserciones o verificaciones de las pruebas
│       └── tasks                         # Acciones de alto nivel (grupo de interaciones)
│       └── userinterfaces                # Mapeo de elementos de las paginas
└── test
    ├── java (com.base.certification)     
    │   └── runners                      # Ejecutores de las prueba
    │   └── stepdefinitions              # Definiciones de los pasos a nivel Given, When, Then, ...
    └── resources                        
        └── data                         # Data requerida para las pruebas
        └── features                     # Archivos Feature en lenguaje Gherkin
```

## Ejecución de Pruebas
### Ejecutar todo el proyecto
```shell
./gradlew clean test
```

### Ejecutar por runner
```shell
./gradle clean test --tests "com.base.certification.runners.nombreRunner"
```

## Reportería
El reporte se genera en la ruta `target/site/serenity/`, archivo principal `index.html`

## Licencia
Open source project.


