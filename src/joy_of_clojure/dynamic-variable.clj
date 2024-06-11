(ns joy-of-clojure.dynamic-variable)

;; Dynamic variables in clojure Dynamic variables are thread
;; bound. Meaning each thread can have different value for the same
;; dynamic variable.

(def ^:dynamic *dynamic-var* :this)

(defn print-dynamic-var!
  "Prints the value of the binding dynamic-var"
  []
  (println *dynamic-var*))

;; Change and print the value of dynamic var.
(defn change-and-print-dynamic-var
  []
  (binding [*dynamic-var* :that]
    (println *dynamic-var*)))


(print-dynamic-var!)
(change-and-print-dynamic-var)
