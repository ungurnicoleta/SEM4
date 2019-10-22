# coding=utf-8

class Controller(object):
    def __init__(self, population, c1, c2, w, nrOfIterations):
        self.__population = population
        self.__c1 = c1
        self.__c2 = c2
        self.__w = w
        self.__nrOfIterations = nrOfIterations

    def iteration(self, w):
        bestNeighbours = self.__population.getBestNeighbours()

        self.__population.updateVelocity(bestNeighbours, w, self.__c1, self.__c2)
        self.__population.updatePosition()

    def runAlg(self):
        for i in range(self.__nrOfIterations):
            self.iteration(self.__w/(i+1))

        best = 0
        for i in range(self.__population.getLen()):
            if self.__population.getIndex(i).fitness < self.__population.getIndex(best).fitness:
                best = i

        fitnessOptim = self.__population.getIndex(best).fitness
        individualOptim = (self.__population.getIndex(best).x, self.__population.getIndex(best).y - 1)

        return fitnessOptim, individualOptim
