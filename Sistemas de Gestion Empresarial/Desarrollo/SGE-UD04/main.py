import random

resultado = {
    'moneda': {

        'cara': {},

        'cruz': {}

    },

    'dados': {}
}
num_random = 0

for i in range(1_000_000):
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

    if resultado.get("moneda").get("cara").__contains__(caras):
        resultado.get("moneda").get("cara").update({caras: resultado.get("moneda").get("cara")[caras] + caras})
    else:
        resultado.get("moneda").get("cara")[caras] = caras

    if resultado.get("moneda").get("cruz").__contains__(cruces):
        resultado.get("moneda").get("cruz").update({cruces: resultado.get("moneda").get("cruz")[cruces] + cruces})
    else:
        resultado.get("moneda").get("cruz")[cruces] = cruces

    if resultado.get("dados").__contains__(dado):
        resultado.get("dados").update({dado: resultado.get("dados")[dado] + dado})
    else:
        resultado.get("dados")[dado] = dado

print(resultado)
