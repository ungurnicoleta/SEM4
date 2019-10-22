from knn import KNearestNeighborsClassifier
from util import read_data, generate_test

if __name__ == "__main__":
    set_path = "column_3C.dat"
    x, y = read_data(set_path)
    x_test, y_test = generate_test(x, y, cases=30)

    classifier = KNearestNeighborsClassifier()

    # add the training data
    classifier.fit(x, y)

    # number of correctly 'predicted' moves
    hit = 0
    k = 10  # number of neighbors

    print("===================================================")
    print("Starting prediction using set: %s with length: %d" % (set_path, len(x)))
    print("Number of neighbors to choose from: %d" % k)
    print("===================================================")

    # run the test case
    for i in range(0, len(x_test)):
        result = classifier.predict(x_test[i], k)
        if result == y_test[i]:
            hit += 1  # the prediction was correct

        print('=> predicted=' + repr(result) + ', actual=' + repr(y_test[i]))

    # print the accuracy for the current run
    print("===================================================")
    print("Accuracy: %f%%" % ((float(hit) / len(x_test)) * 100))
