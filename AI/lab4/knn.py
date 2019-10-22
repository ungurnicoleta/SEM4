import operator

from util import euclidean_distance


class KNearestNeighborsClassifier(object):
    def __init__(self):
        self.train_x = []
        self.train_y = []

    def fit(self, train_x, train_y):
        """ Sets the training data. """
        self.train_x = train_x
        self.train_y = train_y

    def __get_neighbors(self, data, k):
        distances = []

        for i in range(len(self.train_x)):
            dist = euclidean_distance(data, self.train_x[i])
            distances.append((self.train_x[i] + [self.train_y[i]], dist))

        distances.sort(key=operator.itemgetter(1))

        # return the first k neighbors with the smallest
        # distance
        neighbors = [distances[i][0] for i in range(k)]

        return neighbors

    def predict(self, data, k):
        neighbors = self.__get_neighbors(data, k)

        count_each = {}

        for i in range(0, len(neighbors)):
            response = neighbors[i][-1]
            count_each[response] = count_each.get(response, 0) + 1

        sorted_count = sorted(count_each.items(), key=operator.itemgetter(1), reverse=True)

        return sorted_count[0][0]
