import asyncio
import logging
import random
from util import logcfg


async def tarea_fabrica_ruedas(entrada_fabrica):
    while True:
        await asyncio.sleep(random.random())
        logging.info("Ruedas fabricadas")
        await entrada_fabrica.put("ruedas")


async def tarea_fabrica_chasis(entrada_fabrica):
    while True:
        await asyncio.sleep(random.random())
        logging.info("Chasis fabricado")
        await entrada_fabrica.put("chasis")


async def tarea_fabrica_motor(entrada_fabrica):
    while True:
        await asyncio.sleep(random.random())
        logging.info("Motor fabricado")
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
