#language: es
# Author: LizethRE
Característica: Edición de empleados en el sistema de OrangeHRM
  YO COMO usuario de OrangeHRM
  QUIERO poder editar empleados en el sistema
  PARA gestionar su información

  Antecedentes: Iniciar sesión en OrangeHRM
    Dado que Lizeth esta en la pagina de inicio de sesion de OrangeHRM
    Cuando se autentica en el sistema Admin admin123
    Entonces deberia visualizar la pagina de Dashboard

  @deleteEmployee @criticalPath
  Esquema del escenario: Edición de un empleado de manera exitosa
    Dado que Lizeth esta en el modulo PIM
    Y busca un empleado por nombre <existente>
    Cuando edita su informacion <existente> <nuevo>
    Entonces deberia visualizar el toast con el mensaje Successfully Updated
    Ejemplos:
      | existente | nuevo |
      | 1         | 6     |