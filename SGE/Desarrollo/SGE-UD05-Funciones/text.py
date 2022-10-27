
#     Tarea que simula la fabricación de un juego de ruedas. Se trata de un bucle infinito en el que espera un tiempo
#     aleatorio entre 0 y 1 segundo y envía "ruedas" a la cola entrada_fabrica
#     Tarea que simula la fabricación de chasis. Es un bucle infinito que espera un tiempo aleatorio entre 0 y 1 segundo
#     y envía "chasis" a la cola entrada_fabrica
#     Tarea que simula la fabricación de motor. Es un bucle infinito que espera un tiempo aleatorio entre 0 y 1 segundo
#     y envía "motor" a la cola de entrada de la fábrica
#     Tarea que simula la fábrica. Es un bucle infinito que va leyendo de la cola entrada_fabrica y va almacenando en
#     variables internas el número de juegos de ruedas, el número de chasis y el número de motores. Tras leer de la cola
#     , puede ocurrir que pueda completar un coche (si hay al menos un chasis, un juego de ruedas y un motor). Si es así
#     , espera un tiempo aleatorio entre 0 y 1 segundo, imprime en el log "Coche fabricado" y pone "coche" en la cola
#     salida_fabrica. Por supuesto, la fabricación de un coche implica reducir los contadores de ruedas, chasis y motor,
#     Tarea que simula un concesionario
#     La corrutina main que crea las otras tareas, espera 30 segundos y cancela las que ha creado. Es un bucle infinito
#     que lee de la cola salida_fabrica e imprime "Coche en concesionario". No es preciso que espere tiempo


import asyncio
import logging
import random
from util import logcfg


async def tarea_fabrica_ruedas(entrada_fabrica):
    while True:
        await asyncio.sleep(random.random())
        await entrada_fabrica.put("ruedas")


async def tarea_fabrica_chasis(entrada_fabrica):
    while True:
        await asyncio.sleep(random.random())
        await entrada_fabrica.put("chasis")


async def tarea_fabrica_motor(entrada_fabrica):
    while True:
        await asyncio.sleep(random.random())
        await entrada_fabrica.put("motor")


async def tarea_fabrica(entrada_fabrica, salida_fabrica):
    ruedas = 0
    chasis = 0
    motor = 0
    while True:
        item = await entrada_fabrica.get()
        if item == "ruedas":
            ruedas += 1
        elif item == "chasis":
            chasis += 1
        elif item == "motor":
            motor += 1
        if ruedas >= 4 and chasis >= 1 and motor >= 1:
            await asyncio.sleep(random.random())
            logging.info("Coche fabricado")
            await salida_fabrica.put("coche")
            ruedas -= 4
            chasis -= 1
            motor -= 1


async def tarea_concesionario(salida_fabrica):
    while True:
        item = await salida_fabrica.get()

        if item == "coche":
            logging.info("Coche en concesionario")


async def main():
    logcfg(__file__)

    entrada_fabrica = asyncio.Queue()
    salida_fabrica = asyncio.Queue()
    await asyncio.gather(
        tarea_fabrica_ruedas(entrada_fabrica),
        tarea_fabrica_chasis(entrada_fabrica),
        tarea_fabrica_motor(entrada_fabrica),
        tarea_fabrica(entrada_fabrica, salida_fabrica),
        tarea_concesionario(salida_fabrica),
    )
    await asyncio.sleep(30)
    logging.info("Cancelando tareas")
    for task in asyncio.all_tasks():
        task.cancel()


if __name__ == "__main__":
    asyncio.run(main())
