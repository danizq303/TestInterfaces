import logging
from util import logcfg

def saludo_multiple(principal, *secundarios):
    return (saludo_individual(principal),) + \
           tuple(saludo_individual(n) for n in secundarios) 

def saludo_individual(name):
    saludo = f"Hola, {name}"
    return saludo

def main():
    for s in saludo_multiple("Cristina", 
                              "Irene", 
                              "Mayte",
                              "Manolo"):
        logging.info(f"{s}")

if __name__ == "__main__":
    logcfg(__file__)
    logging.debug("Comienzo de programa")
    main()
    logging.debug("Fin de programa")