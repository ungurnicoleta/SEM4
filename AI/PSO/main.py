# coding=utf-8
from Controller.Controller import Controller
from Swarm.Swarm import Swarm

if __name__ == "__main__":
    # number of particles
    noParticles = 50
    noIterations = 100
    vxmin = -1.5
    vxmax = 4
    vymin = -3
    vymax = 4

    # specific parameters for PSO
    w = 1.0
    c1 = 1.0
    c2 = 2.5
    sizeOfNeighborhood = 20
    population = Swarm(noParticles, vxmax, vxmin, vymax, vymin, sizeOfNeighborhood)
    ctrl = Controller(population, c1, c2, w, noIterations)

    fitnessOptim, individualOptim = ctrl.runAlg()

    print('Result: The detectet minimum point is (%3.2f %3.2f) \n with function\'s value %3.2f' % \
          (individualOptim[0], individualOptim[1], fitnessOptim))
