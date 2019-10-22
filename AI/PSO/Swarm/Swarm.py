# coding=utf-8
from random import randint, random

from Particle.Particle import Particle


class Swarm(object):
    def __init__(self, dimension, vxmax, vxmin, vymax, vymin, nrOfNeighbours):
        self.__particles = [Particle(vxmax, vxmin, vymax, vymin) for i in range(dimension)]
        self.__neighbours = self.selectNeighBours(nrOfNeighbours)

    def selectNeighBours(self, nrOfNeighbours):
        neighbors = []
        for i in range(len(self.__particles)):
            localNeighbor = []
            for j in range(nrOfNeighbours):
                x = randint(0, len(self.__particles) - 1)
                while x in localNeighbor:
                    x = randint(0, len(self.__particles) - 1)
                localNeighbor.append(x)
            neighbors.append(localNeighbor.copy())
        return neighbors.copy()


    def getBestNeighbours(self):
        bestNeighbors = []
        for i in range(len(self.__particles)):
            bestNeighbors.append(self.__neighbours[i][0])
            for j in range(1, len(self.__neighbours[i])):
                if self.__particles[bestNeighbors[i]].fitness > self.__particles[self.__neighbours[i][j]].fitness:
                    bestNeighbors[i] = self.__neighbours[i][j]
        return bestNeighbors.copy()

    def updateVelocity(self, bestNeighbours, w, c1, c2):
        # update the velocity for each particle
        for i in range(len(self.__particles)):
            particleVelocity = self.__particles[i].getVelocity()
            newVelocityX = w * particleVelocity[0]
            newVelocityX = newVelocityX + c1 * random() * (self.__particles[bestNeighbours[i]].x - self.__particles[i].x)
            newVelocityX = newVelocityX + c2 * random() * (self.__particles[i].bestPosition[0] - self.__particles[i].x)

            newVelocityY = w * particleVelocity[1]
            newVelocityY = newVelocityY + c1 * random() * (self.__particles[bestNeighbours[i]].y - self.__particles[i].y)
            newVelocityY = newVelocityY + c2 * random() * (self.__particles[i].bestPosition[1] - self.__particles[i].y)

            newVelocity = (newVelocityX, newVelocityY)
            self.__particles[i].velocity(newVelocity)

    def updatePosition(self):
        for i in range(len(self.__particles)):
            x = self.__particles[i].x + self.__particles[i].getVelocity()[0]
            y = self.__particles[i].y + self.__particles[i].getVelocity()[1]

            newPosition = (x, y)
            self.__particles[i].position(newPosition)

    def getLen(self):
        return len(self.__particles)

    def getIndex(self, i):
        return self.__particles[i]
