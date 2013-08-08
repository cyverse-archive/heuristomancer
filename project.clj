(defproject heuristomancer "0.1.1-SNAPSHOT"
  :description "Clojure library for attempting to guess file types."
  :url "http://www.iplantcollaborative.org"
  :license {:name "BSD"
            :url "http://iplantcollaborative.org/sites/default/files/iPLANT-LICENSE.txt"}
  :profiles {:dev {:resource-paths ["test-data"]}}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.cli "0.2.2"]
                 [org.clojure/tools.logging "0.2.6"]
                 [instaparse "1.2.1"]]
  :plugins [[org.iplantc/lein-iplant-cmdtar "0.1.2-SNAPSHOT"]]
  :aot [heuristomancer.core]
  :main heuristomancer.core
  :repositories [["iplantCollaborative"
                  "http://projects.iplantcollaborative.org/archiva/repository/internal/"]])
