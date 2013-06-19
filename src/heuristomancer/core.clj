(ns heuristomancer.core)

(def ^:private default-sample-size
  "The default sample size to use."
  1000)

(defn sip
  [in sample-size])

(defn)

(defn identify
  ([in]
     (identify in default-sample-size))
  ([in sample-size]
     (identify-string (sip in sample-size))))
