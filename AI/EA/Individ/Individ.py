from math import sin, exp, sqrt
from random import randint

import math


class Individ(object):

    def __init__(self, x, y):
        self.__x = x
        self.__y = y

    def fitness(self, problem):
        f = problem.calculate(self.__x, self.__y)
        return f

    def mutate(self, probability):
        alpha = randint(0, 1)
        self.__x = self.__x + alpha * probability
        self.__y = self.__y + alpha * probability

    def crossover(self, individ):
        alpha = randint(0, 1)
        x = self.__x + alpha * (self.__x - individ.x)
        y = self.__y + alpha * (self.__y - individ.y)
        return Individ(x, y)

    @property
    def x(self):
        return self.__x

    @property
    def y(self):
        return self.__y
