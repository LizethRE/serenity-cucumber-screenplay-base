#language: es
# Author: LizethRE
Característica: Creación de nuevos empleados en el sistema de OrangeHRM
  YO COMO usuario de OrangeHRM
  QUIERO poder añadir empleados al sistema
  PARA que los nuevos empleados tengan acceso a los recursos

  Antecedentes: Iniciar sesión en OrangeHRM
    Dado que Lizeth esta en la pagina de inicio de sesion de OrangeHRM
    Cuando se autentica en el sistema Admin admin123
    Entonces deberia visualizar la pagina de Dashboard

  @addEmployee @criticalPath
  Esquema del escenario: Creación de un nuevo empleado de manera exitosa
    Dado que Lizeth esta en el modulo PIM
    Cuando va a agregar nuevo empleado
    Y diligencia el formulario de creacion de empleado <id>
    Entonces deberia visualizar el toast con el mensaje Successfully Saved
    Y ser redirigido a la pagina de editar informacion del nuevo empleado <id>
    Ejemplos:
      | id |
      | 1  |
      | 2  |
      | 3  |
      | 4  |