import random

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
        cruz[cruces] = cruces

    if dados.__contains__(dado):
        dados.update({dado: dados.get(dado) + 1})
    else:
        dados[dado] = dado


cara = dict(sorted(cara.items()))
cruz = dict(sorted(cruz.items()))
dados = dict(sorted(dados.items()))
moneda = {'cara': cara, 'cruz': cruz}
resultado = {'moneda': moneda, 'dados': dados}

print(resultado)
