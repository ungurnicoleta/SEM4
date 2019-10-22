# coding=utf-8
from math import sin
from random import random


class Particle(object):

    def __init__(self, vxmax, vxmin, vymax, vymin):
        # f(x,y) x and y are the variables
        # so for our problem the particle has dimension 2

        self.__x = random() * (vxmax - vxmin) + vxmin
        self.__y = random() * (vymax - vymin) + vymin
        self.__fitness = self.calculateFitness()
        self.__velocity = (0, 0)

        # the memory of the particle
        # keep the best combination of variables
        self.__bestPosition = (self.__x, self.__y)
        self.__bestFitness = self.calculateFitness()

    def calculateFitness(self):
        # calculates the fitness for the current particle
        return sin(self.__x + self.__y) + (self.__x - self.__y) * (self.__x - self.__y) + (-1.5 * self.__x) + (2.5 * self.__y) + 1

    def update(self, particle):
        pass

    @property
    def x(self):
        return self.__x

    @x.setter
    def x(self, value):
        self.__x = value

    @property
    def y(self):
        return self.__y

    @x.setter
    def y(self, value):
        self.__y = value

    @property
    def bestPosition(self):
        return self.__bestPosition

    @property
    def bestFitness(self):
        return self.__bestFitness

    @property
    def fitness(self):
        return self.__fitness

    def getVelocity(self):
        return self.__velocity

    def position(self, newPosition):
        self.__x = newPosition[0]
        self.__y = newPosition[1]
        # automatic evaluation of particle's fitness
        self.__fitness = self.calculateFitness()
        # automatic update of particle's memory
        if self.__fitness < self.__bestFitness:
            self.__bestPosition = (self.__x, self.__y)
            self.__bestFitness = self.__fitness

    def velocity(self, newVelocity):
        self.__velocity = newVelocity
