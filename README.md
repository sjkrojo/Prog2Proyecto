# Sistema de Gestión de Sucursales de Grupo Bimbo

Este proyecto aborda un serio problema logístico en el envío de datos a las sucursales de Grupo Bimbo ubicadas en las ciudades de Leticia, Villavicencio, Pasto, Nariño y Caracas, Venezuela. Los costos de envío no coinciden con los informados por las sucursales, presentando un exceso de hasta el 700% en lugar del 200% esperado.

## Descripción del Sistema

El sistema de información desarrollado es una herramienta de gestión que abarca las siguientes funcionalidades:

- Manejo de inventario: Cada sucursal tiene un inventario diferente de productos. Se implementa un sistema de manejo de personal para colaboradores.
- Operaciones CRUD: Se proporciona la capacidad de crear, leer, actualizar y eliminar registros de productos y colaboradores.
- Cálculo de costos: Se requiere calcular el costo total del inventario y compararlo con el exceso del 700% para informar a la gerencia sobre la cantidad de dinero adicional que está ingresando, considerando la posibilidad de lavado de dinero.
- Generación de informes: El sistema debe generar informes en formato PDF que incluyan los inventarios de todas las sucursales, así como gráficas que muestren la diferencia entre las ganancias reales y las esperadas para cada sucursal.

## Relaciones entre productos y colaboradores

Los productos vendidos deben estar relacionados con el colaborador que realizó la venta correspondiente.

## Gráficas de ganancias

Se requiere generar gráficas que muestren las ganancias esperadas para cada sucursal en comparación con las ganancias reales.

## Cálculo de diferencia de ganancias

La diferencia de ganancias se calcula multiplicando el costo unitario por el 200% y el 700%, y luego restando los resultados para determinar las ganancias reales que deberían obtenerse.

## Contribución

¡Agradecemos las contribuciones al proyecto! Si deseas contribuir, por favor sigue las pautas de contribución descritas en [CONTRIBUTING.md](enlace-a-contributing.md).

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo [LICENSE.md](enlace-a-licencia.md) para obtener más detalles.

## Contacto

Para cualquier consulta o pregunta sobre el proyecto, puedes contactarnos a través del correo electrónico contacto@ejemplo.com.


