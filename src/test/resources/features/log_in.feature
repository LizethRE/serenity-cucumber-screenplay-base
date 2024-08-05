#language: es
# Author: LizethRE
Característica: Inicio de Sesión en OrangeHRM
  YO COMO usuario de OrangeHRM
  QUIERO ingresar al sistema
  PARA realizar la gestión de recursos humanos

  Antecedentes: Navegar a la pagina de Inicio de Sesión
    Dado que Maria esta en la pagina de inicio de sesion de OrangeHRM

  @logIn @criticalPath
  Escenario: Inicio de sesión exitoso
    Cuando se autentica en el sistema Admin admin123
    Entonces deberia visualizar la pagina de Dashboard

  @logIn @alternatePath
  Esquema del escenario: Inicio de sesión fallido con credenciales incorrectas
    Cuando se autentica en el sistema <username> <password>
    Entonces deberia visualizar la alerta con el mensaje Invalid credentials
    Y permanecer en la pagina de Inicio de Sesion
    Ejemplos:
      | username | password |
      | Root     | admin123 |
      | Admin    | admin124 |

  @logIn @alternatePath
  Esquema del escenario: Inicio de sesión fallido con campos vacíos
    Cuando se autentica en el sistema <username> <password>
    Entonces deberia visualizar la alerta de campo requerido
    Y permanecer en la pagina de Inicio de Sesion
    Ejemplos:
      | username | password |
      | Root     | N/a      |
      | N/a      | admin124 |
      | N/a      | N/a      |