# challengeConversor
solucion challenge conversor de unidades

El presente trabajo está realizado en eclipse

consta de tres formularios locados en package "guis"

frmPrincipal

![image](https://user-images.githubusercontent.com/122403395/226208670-27624c22-cd7c-4621-a8ac-dc6f34daab07.png)

donde podemos acceder al frmMoneda

![image](https://user-images.githubusercontent.com/122403395/226208710-9da6469f-6912-4ab5-a9ba-550bb909eff2.png)

o el frmTemperatura

![image](https://user-images.githubusercontent.com/122403395/226208821-27e9dbd6-4659-47a7-9524-8427e256f316.png)

NOTAS / MEJORAS : 

1°)
el formulario para conversión de monedas, utiliza un método simplificado

primero convierte el monto origen "DE" a dolar y posteriormente lo convierte a la moneda destino "A"

2°) el campo JtextField, está configurado para aceptar sólo números y puntos,

necesita agregar una máscara ya que pueden agregarse varios puntos, lo cual dá errores,

otra solución es realizar un tratamiento de las exepciones
