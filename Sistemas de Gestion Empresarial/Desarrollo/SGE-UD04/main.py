import random

# resultado = {
#     'moneda': {
#
#         'cara': {},
#
#         'cruz': {}
#
#     },
#
#     'dados': {}
# }

cara = {}
cruz = {}
dados = {}

num_random = 0
NUM_EXPERIMENTO = 1_000
print("Start")

for i in range(NUM_EXPERIMENTO):
    caras = 0
    cruces = 0
    dado = 0

    for j in range(10):
        num_random = random.randint(0, 1)
        if num_random == 0:
            caras += 1
        else:
            cruces += 1

    for f in range(3):
        num_random = random.randint(1, 6)
        dado += num_random

    if cara.__contains__(caras):
        cara.update({caras: cara.get(caras) + 1})
    else:
        cara[caras] = caras

    if cruz.__contains__(cruces):
        cruz.update({cruces: cruz.get(cruces) + 1})
    else:
        cara[caras] = caras

    if dados.__contains__(dado):
        dados.update({dado: dados.get(dado) + 1})
    else:
        dados[dado] = dado

    # if resultado.get("moneda").get("cara").__contains__(caras):
    #     resultado.get("moneda").get("cara").update({caras: resultado.get("moneda").get("cara")[caras] + 1})
    # else:
    #     resultado.get("moneda").get("cara")[caras] = caras
    #
    # if resultado.get("moneda").get("cruz").__contains__(cruces):
    #     resultado.get("moneda").get("cruz").update({cruces: resultado.get("moneda").get("cruz")[cruces] + 1})
    # else:
    #     resultado.get("moneda").get("cruz")[cruces] = cruces
    #
    # if resultado.get("dados").__contains__(dado):
    #     resultado.get("dados").update({dado: resultado.get("dados")[dado] + 1})
    # else:
    #     resultado.get("dados")[dado] = dado

cara = dict(sorted(cara.items()))
cruz = dict(sorted(cruz.items()))
dados = dict(sorted(dados.items()))
moneda = {cara, cruz}
resultado = {moneda, dados}

print(resultado)
