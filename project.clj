(defproject heuristomancer "0.1.0-SNAPSHOT"
  :description "Clojure library for attempting to guess file types."
  :url "http://www.iplantcollaborative.org"
  :license {:name "BSD"
            :url "http://iplantcollaborative.org/sites/default/files/iPLANT-LICENSE.txt"}
  :profiles {:dev {:resource-paths ["test-data"]}}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [instaparse "1.1.0"]])
