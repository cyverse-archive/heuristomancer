(ns heuristomancer.core-test
  (:use [clojure.test]
        [heuristomancer.core]
        [heuristomancer.loader :only [resource-reader]]))

(defn- parse-test-file
  [path]
  (with-open [r (resource-reader path)]
    (identify r)))

(deftest perl-test
  (testing "Perl script identification"
    (is (= :perl (parse-test-file "foo.pl")))))
