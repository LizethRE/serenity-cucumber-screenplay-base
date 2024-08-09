#language: es
# Author: LizethRE
Característica: Busqueda de empleados en el sistema de OrangeHRM
  YO COMO usuario de OrangeHRM
  QUIERO poder buscar empleados en el sistema
  PARA gestionar su información

  Antecedentes: Iniciar sesión en OrangeHRM
    Dado que Lizeth esta en la pagina de inicio de sesion de OrangeHRM
    Cuando se autentica en el sistema Admin admin123
    Entonces deberia visualizar la pagina de Dashboard

  @searchEmployee @criticalPath
  Esquema del escenario: Busqueda de empleado existente por nombre
    Dado que Lizeth esta en el modulo PIM
    Cuando busca un empleado por ID <id>
    Entonces deberia obtener resultados
    Ejemplos:
      | id |
      | 1  |
      | 2  |
      | 3  |
      | 4  |

  @searchEmployee @alternatePath
  Esquema del escenario: Busqueda de empleado no existente por nombre
    Dado que Lizeth esta en el modulo PIM
    Cuando busca un empleado por ID <id>
    Entonces deberia visualizar el toast con el mensaje No Records Found
    Ejemplos:
      | id |
      | 5  |