# spark-dataframe


## <a name="Problema"></a>Planteamiento del problema

![problema: ](/home/jairo/proyecto-cencoScotiabank/proyectos-oapi/java/spark-dataframe-example/assets/problema.png)


## <a name="Arquitectura"></a>Arquitectura

![arquitectura: ](/home/jairo/proyecto-cencoScotiabank/proyectos-oapi/java/spark-dataframe-example/assets/arquitectura.png)



### <a name="Model"></a>Model
En esta parte agregue el modelo de Person que se utiliza para crear los objetos de la solucion


### <a name="Mothers"></a>Mothers
Utilice estos Mother como ayuda para crear los objetos random y de manera generica.


### <a name="Service"></a>Service
Aqui encontraremos una interfaz y su respectiva implementacion conformada con un companion object y asi fuera mas facil acceder a las funciones que se encargan de tener disponible toda la informacion.

### <a name="Package"></a>Package
Aqui agrege algunas contantes que utilice durante la logica

### <a name="SparkDataFRame"></a>SparkDataFrame
Esta es la clase principal donde se debe ejecutar y es la que se encarga de levantar la aplicacion y respectiva logica.


# Validar implementacion:
### <a name="Salidas"></a>Salidas: 

las salidas la deje en la exportacion de un archivo en formato Json el cual pueden ver en la siguiente ruta, cada ejecucion cuenta con un idExecution unico para que esta informacion no sea sobreescrita.

![salidas: ](/home/jairo/proyecto-cencoScotiabank/proyectos-oapi/java/spark-dataframe-example/assets/salidas.png)

### <a name="Logs"></a>Logs: 

Tambien pueden validar a nivel de logs el resultado impreso del df5. 

![df5: ](/home/jairo/proyecto-cencoScotiabank/proyectos-oapi/java/spark-dataframe-example/assets/df5.png)


# Otras posibles soluciones: 
Bueno en mi caso particular, lo he trabajado con: 
 `spark.read.table("<catalog-name>.<schema-name>.<table-name>")` para leerlo atravez de un query a una base de datos.
 
Tambien lo he trabajo haciendo lectura desde un Documento `CSV` y `TXT` con :`spark.read.format("csv").load("ruta del archivo")`

Pero tuve un inconveniente Personal el cual me tomo mucho tiempo en resolver y esto me llevo a tomar la desicion de crearlo con Los Mother a objetos navitos de Scala. 


## <a name="links"></a>Links

- Spark: https://spark.apache.org/docs/latest/sql-programming-guide.html
- Scala: https://www.scala-lang.org/download/2.13.0.html