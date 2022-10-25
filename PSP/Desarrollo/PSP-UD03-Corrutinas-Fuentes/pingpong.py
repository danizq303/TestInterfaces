import asyncio
import logging
from util import logcfg


async def pinger(ping, pong):
    # Ejecutar la tarea de pinger y esperar a que ponger ponga el mensaje en la cola pong para que ponger pueda leerlo
    # y así poder continuar con la ejecución de la tarea de pinger indefinidamente

    while True:
        msg = 'ping'
        logging.info(msg)
        await ping.put(msg)
        msg = await pong.get()
        logging.info(msg + ' recibido')


async def ponger(ping, pong):
    # Ejecutar la tarea de ponger y esperar a que pinger ponga el mensaje en la cola ping para que pinger pueda leerlo
    # y así poder continuar con la ejecución de la tarea de ponger indefinidamente

    while True:
        msg = await ping.get()
        logging.info(msg + ' recibido')
        msg = 'pong'
        logging.info(msg)
        await pong.put(msg)


async def main():
    # Crear las colas ping y pong y las tareas pinger y ponger y ejecutarlas durante 10 segundos

    ping = asyncio.Queue()
    pong = asyncio.Queue()
    tasks = [pinger(ping, pong), ponger(ping, pong)]
    await asyncio.wait(tasks, timeout=10)


if __name__ == '__main__':
    logcfg(__file__)
    logging.info('Inicio')
    asyncio.run(main())
    logging.info('Fin')
