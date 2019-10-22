import math
from random import randint


def read_data(path):
    x, y = [], []

    with open(path) as f:
        lines = f.readlines()

        for line in lines:
            tokens = line.split(' ')

            x.append([float(token) for token in tokens[: len(tokens) - 1]])
            y.append(tokens[-1])

    return x, y


def generate_test(x, y, cases=15):
    x_test = []
    y_test = []

    for i in range(0, cases):
        index = randint(0, len(x)-1)

        x_test.append(x[index])
        y_test.append(y[index])

        x.remove(x[index])
        y.remove(y[index])

    return x_test, y_test


def euclidean_distance(set1, set2):
    """ Compute the euclidean distance for two sets of data. """
    if len(set1) != len(set2):
        return 0

    return math.sqrt(sum(d for d in [pow((set1[i] - set2[i]), 2) for i in range(len(set1))]))

