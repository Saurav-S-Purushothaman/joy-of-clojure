;; this file contains most random code.
;; Do not read this
;; Everything written in here is stupid

;; Creating fibinocci series in functional style

(defn fibinocci
  "Generate fibinocci series upto the given number n"
  [n]
  (->> [0 1]
       (iterate (fn [[a b]] [b (+ a b)]))
       (map first)
       (take n)
       rest))

;; There is also another way to create fibinocci series in clojure.
;; Using lazy sequences.

;; NOTE: Whem making fixed size values, always user recur
;; Otherwise


(defn lazy-seq-fibinocci
  "Genereates fibinocci series using lazy sequences"
  ([] (concat [0 1] (lazy-seq-fibinocci 0 1)))
  ([a b]
   (lazy-seq
    (cons (+ a b) (lazy-seq-fibinocci b (+ a b))))))
