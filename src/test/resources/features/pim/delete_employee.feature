#language: es
# Author: LizethRE
Característica: Eliminación  de empleados en el sistema de OrangeHRM
  YO COMO usuario de OrangeHRM
  QUIERO poder eliminar empleados en el sistema
  PARA gestionar los empleados

  Antecedentes: Iniciar sesión en OrangeHRM
    Dado que Lizeth esta en la pagina de inicio de sesion de OrangeHRM
    Cuando se autentica en el sistema Admin admin123
    Entonces deberia visualizar la pagina de Dashboard

  @deleteEmployee @criticalPath
  Esquema del escenario: Eliminación de un empleado de manera exitosa
    Dado que Lizeth esta en el modulo PIM
    Y busca un empleado por nombre <id>
    Cuando elimina el empleado <id>
    Entonces deberia visualizar el toast con el mensaje Successfully Deleted
    Ejemplos:
      | id |
      | 1  |