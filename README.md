# Compilador

Compilador usando ANTLR4 La gramatica definida esta en el archivo `Demo.g4` Si se desea hacer algun cambio a la gramatica se tiene que re compilar usando el comando `java -jar ../lib/antlr.jar Demo.g4 -package compiler.parser -o ../src/compiler/parser -no-listener -visitor Demo.g4` 

## Recomendaciones

Muchos de los metodos de compilar tiene ciertos fallos en Windows se recomienda el uso de un sistema operativo `Linux` para evitar problemas.
Es necesario tener instalado dentro del IDE TestNG para el correcto funcionamiento de las pruebas

## Problemas

Una vez clonado el proyecto se veran ciertos errores. Estos se solucionan importanto los jar que se encuentras en las librerias `lib` de cada uno de los proyectos. Una vez solucionado esos problemas se debe activar en el java project `Parser` la opcion de permitir compartir los external jars
