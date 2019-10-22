import numpy as np
from Population.Population import Population
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import axes3d


class Algorithm(object):
    def __init__(self, file_name, problem):
        self.__iterations = 10
        self.__dimPopulation = 100
        self.__vmax = 10
        self.__vmin = -10
        self.__probability = 0.1
        self.__problem = problem
        self.read_params(file_name)

    def read_params(self, file_name):
        f = open(file_name)
        self.__iterations = int(f.readline())
        self.__dimPopulation = int(f.readline())
        self.__vmax = float(f.readline())
        self.__vmin = float(f.readline())
        self.__probability = float(f.readline())
        f.close()

    def iteration(self, population):
        i1, individ1, i2, individ2 = population.selection()
        individ3 = individ1.crossover(individ2)
        individ3.mutate(self.__probability)
        f1 = individ1.fitness(self.__problem)
        f2 = individ2.fitness(self.__problem)

        f3 = individ3.fitness(self.__problem)
        if (f1 > f2) and (f1 > f3):
            population.set(i1, individ3)
        if (f2 > f1) and (f2 > f3):
            population.set(i2, individ3)
        return population

    def run(self):
        population = Population(self.__dimPopulation, self.__vmax, self.__vmin)
        for i in range(self.__iterations):
            population = self.iteration(population)

        best = [(x.fitness(self.__problem), x) for x in population.get_all()]
        best = sorted(best, key=lambda x: x[0])
        result = best[0]
        fitnessOptim = result[0]
        individualOptim = result[1]

        print('Result: The detected minimum point after %d iterations is f(%3.2f , %3.2f) = %3.2f' %
              (self.__iterations, individualOptim.x, individualOptim.y, fitnessOptim))

        return result

    def f(self, x, y):
        return np.matrix(-0.0001 * (
                ((abs(np.sin(x) * np.sin(y) * np.exp(abs(100 - (np.sqrt(x * x + y * y) / float(np.pi)))))) +
                 1) ** 0.1))

    def statistics1(self):
        fitness = []

        for i in range(30):
            result = self.run()
            fitness.append(result[0])
        foundFitness = np.array(fitness)
        print("The average deviation is %3.2f", foundFitness.mean())
        print("The standard deviation is %3.2f", foundFitness.std())

    def statistics2(self):
        x = np.linspace(-10, 10, 30)
        y = np.linspace(-10, 10, 30)

        X, Y = np.meshgrid(x, y)
        Z = self.f(X, Y)

        ax = plt.axes(projection='3d')
        ax.contour3D(X, Y, Z, 50)
        ax.set_xlabel('x')
        ax.set_ylabel('y')
        ax.set_zlabel('z')

        plt.show()
