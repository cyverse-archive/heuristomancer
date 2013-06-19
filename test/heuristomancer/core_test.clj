(ns heuristomancer.core-test
  (:use [clojure.test]
        [heuristomancer.core]
        [heuristomancer.loader :only [resource-reader]]))

(defn- parse-test-file
  "Parses a test file and returns the result."
  [path]
  (with-open [r (resource-reader path)]
    (identify r)))

(defn- test-file-type-identification
  "Verifies that a file type is identified correctly."
  [[path expected]]
  (testing (str path " identified as " expected)
    (is (= expected (parse-test-file path)))))

(def ^:private tests
  [["foo.csh"            :csh]
   ["foo.tcsh"           :tcsh]
   ["foo.sh"             :sh]
   ["foo.bash"           :bash]
   ["foo.pl"             :perl]
   ["foo.py"             :python]
   ["dna-quote.ace"      :ace]
   ["dna-colon.ace"      :ace]
   ["peptide-quote.ace"  :ace]
   ["peptide-colon.ace"  :ace]
   ["protein-quote.ace"  :ace]
   ["protein-colon.ace"  :ace]
   ["sequence-quote.ace" :ace]
   ["sequence-colon.ace" :ace]
   ["test.ace"           :ace]])

(deftest file-type-identification
  (dorun (map test-file-type-identification tests)))
