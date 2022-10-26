import logging
from util import logcfg


def saludo_multiple(principal, *secundarios):
    return (saludo_individual(principal),) + tuple(saludo_individual(s) for s in secundarios)


def saludo_individual(name):
    saludo = f"Hola, {name}"
    return saludo


def suma(*args):
    return sum(args)


def altura(plantas, altitud=700):
    return plantas * 3 + altitud


def main():
    for saludo in saludo_multiple("Juan", "Pedro", "Ana"):
        logging.info(saludo)

    logging.info(suma(1, 2, 3, 4, 5))


if __name__ == "__main__":
    logcfg(__file__)
    logging.debug("Iniciando")
    main()
    logging.debug("Finalizando")