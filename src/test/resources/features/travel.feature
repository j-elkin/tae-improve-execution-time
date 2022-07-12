#language: es

Característica: Buscar tiquetes de avión
  Como turista
  Quiero buscar y comprar tiquetes de avión
  Para disfrutar de mis vacaciones

  @vacation
  Esquema del escenario: buscar vuelos en clase turista
    Dado que John busca vuelos con las siguientes condiciones
      | <Origen> | <Destino> | <FechaSalida> | <FechaRegreso> | <CantidadPasajeros> |
    Cuando John selecciona los vuelos
    ##Entonces Sandra deberia ver el mensaje <MensajeCuentaActivada>

    Ejemplos:
      | Origen   | Destino | FechaSalida | FechaRegreso | CantidadPasajeros |
      | Medellin | Lima    | 20-08-2022  | 09-09-2022   | 3                 |