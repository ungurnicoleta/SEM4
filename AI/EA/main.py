from Algorith.Algorithm import Algorithm
from Problem.Problem import Problem

if __name__ == "__main__":
    problem = Problem("ProblemCoefficients.txt")
    alg = Algorithm("AlgorithmParams.txt", problem)
    alg.run()

    alg.statistics1()
    # alg.statistics2()
