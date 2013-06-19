(ns heuristomancer.core
  (:use [clojure.java.io :only [reader]]
        [heuristomancer.loader :only [load-parsers]])
  (:require [instaparse.core :as insta]))

(def ^:private default-sample-size
  "The default sample size to use."
  1000)

(defn sip
  "Loads up to a maximum number of characters from anything that clojure.java.io/reader can
   convert to a reader."
  [in limit]
  (with-open [r (reader in)]
    (let [buf (char-array limit)
          len (.read r buf 0 limit)]
      (String. buf 0 len))))

(defn format-matches
  "Determines whether a format matches a sample from a file."
  [sample [_ identifier-fn]]
  (not (insta/failure? (identifier-fn sample))))

(def formats (load-parsers))

(defn identify-sample
  "Attempts to identify the type of a sample."
  [sample]
  (ffirst (filter (partial format-matches sample) formats)))

(defn identify
  "Attempts to identify the type of a sample obtained from anything that clojure.java.io/reader
   can convert to a reader."
  ([in]
     (identify in default-sample-size))
  ([in sample-size]
     (identify-sample (sip in sample-size))))
