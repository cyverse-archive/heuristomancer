(ns heuristomancer.core-test
  (:use [clojure.test]
        [heuristomancer.core]
        [heuristomancer.loader :only [resource-reader]]))

(defn- parse-test-file
  [path]
  (with-open [r (resource-reader path)]
    (identify r)))

(defn- test-file-type-identification
  [[path expected]]
  (testing (str path " identified as " expected)
    (is (= expected (parse-test-file path)))))

(def ^:private tests
  [["foo.csh" :csh]
   ["foo.pl"  :perl]])

(deftest file-type-identification
  (dorun (map test-file-type-identification tests)))
