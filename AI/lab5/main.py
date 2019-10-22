from Algorithm.GeneticP import GPAlgorithm

if __name__ == '__main__':
    algorithmGP = GPAlgorithm("slice_localization_data/slice_localization_data.csv", 10)
    algorithmGP.run()
