from random import random, randint

from Individ.Individ import Individ


class Population(object):

    def __init__(self, count, vmax, vmin):
        self.__individuals = []
        self.create_individuals(count, vmax, vmin)

    def create_individuals(self, count, vmax, vmin):
        individuals = []
        for j in range(count):
            x = random() * (vmax - vmin)
            y = random() * (vmax - vmin)
            individuals.append(Individ(x, y))
        self.__individuals = individuals[:]

    def set(self, index, value):
        self.__individuals[index] = value

    def get_all(self):
        return self.__individuals[:]

    def selection(self):
        i1 = randint(0, len(self.__individuals) - 1)
        i2 = randint(0, len(self.__individuals) - 1)
        individ1 = self.__individuals[i1]
        individ2 = self.__individuals[i2]
        return i1, individ1, i2, individ2
