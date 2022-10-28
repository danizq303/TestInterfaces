import asyncio
import logging
from util import logcfg


async def pinger(ping, pong):
    while True:
        await asyncio.sleep(1)
        mensaje = "Ping"
        logging.info("Mandando ping")
        await ping.put(mensaje)
        await pong.get()
        logging.info("Pong recibido")


async def ponger(ping, pong):
    while True:
        await ping.get()
        logging.info("Ping recibido")
        await asyncio.sleep(1)
        mensaje = "Pong"
        logging.info("Mandando pong")
        await pong.put(mensaje)


async def main():
    ping = asyncio.Queue()
    pong = asyncio.Queue()

    tasks = [pinger(ping, pong), ponger(ping, pong)]

    await asyncio.wait(tasks)


if __name__ == '__main__':
    logcfg(__file__)
    asyncio.run(main())