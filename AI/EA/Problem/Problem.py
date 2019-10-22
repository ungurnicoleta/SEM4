from math import sin, exp, sqrt

import math


class Problem(object):

    def __init__(self, file_name):
        self.__paramA = -0.0001
        self.__paramB = 100
        self.__paramC = 1
        self.__paramD = 0.1
        self.load_data(file_name)

    def load_data(self, file_name):
        file = open(file_name)
        self.__paramA = float(file.readline())
        self.__paramB = float(file.readline())
        self.__paramC = float(file.readline())
        self.__paramD = float(file.readline())
        file.close()

    def calculate(self, x, y):
        return self.__paramA * (
                    ((abs(sin(x) * sin(y) * exp(abs(self.__paramB - (sqrt(x * x + y * y) / float(math.pi)))))) +
                     self.__paramC) ** self.__paramD)

