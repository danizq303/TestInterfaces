import random
from pprint import pprint

import matplotlib.pyplot as plt


def main():
    cara = {}
    cruz = {}
    dados = {}

    num_experimento = 100_000
    num_tiradas_moneda = 10
    num_tiradas_dado = 3

    # Inicializar Diccionarios a 0
    for i in range(num_tiradas_moneda + 1):
        cara[i] = 0
        cruz[i] = 0

    for i in range(3, 6 * num_tiradas_dado + 1):
        dados[i] = 0

    # Realizar Experimento
    for i in range(num_experimento):
        caras = 0
        cruces = 0
        dado = 0

        for j in range(num_tiradas_moneda):
            num_random = random.randint(0, 1)
            if num_random == 0:
                caras += 1
            else:
                cruces += 1

        for f in range(num_tiradas_dado):
            num_random = random.randint(1, 6)
            dado += num_random

        cara[caras] += 1
        cruz[cruces] += 1
        dados[dado] += 1

    # Add diccionarios a resultado
    moneda = {'cara': cara, 'cruz': cruz}
    resultado = {'moneda': moneda, 'dados': dados}
    pprint(resultado)

    # Mostrar Figura Caras
    plt.figure()
    claves_cara = resultado["moneda"]["cara"].keys()
    valores_cara = resultado["moneda"]["cara"].values()

    plt.plot(claves_cara, valores_cara)
    plt.title("Monedas: Cara")
    plt.xlabel("Veces Volteadas")
    plt.ylabel("Ocurrencias")
    plt.show()

    # Mostrar Figura Cruces
    plt.figure()
    claves_cruz = resultado["moneda"]["cruz"].keys()
    valores_cruz = resultado["moneda"]["cruz"].values()

    plt.plot(claves_cruz, valores_cruz)
    plt.title("Monedas: Cruz")
    plt.xlabel("Veces Volteadas")
    plt.ylabel("Ocurrencias")
    plt.show()

    # Mostrar Figura Dados
    plt.figure()
    claves_dados = resultado["dados"].keys()
    valores_dados = resultado["dados"].values()

    plt.plot(claves_dados, valores_dados)
    plt.title("Dados")
    plt.xlabel("Puntuacion")
    plt.ylabel("Ocurrencias")
    plt.show()


if __name__ == '__main__':
    main()
