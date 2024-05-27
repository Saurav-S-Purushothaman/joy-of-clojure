(ns joy-of-clojure.foo
  (:gen-class))

;; This namespace contains most random code.
;; Do not take this seriously
;; Everything written in here is stupid
;; Author : Saurav S Purushothaman <saurav.kudajadri@gmail.com>

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

;; NOTE: Whem making fixed size values, always use recur
;; Otherwise use lazy sequence. Rule of thumb, I suppose!


(defn lazy-seq-fibinocci
  "Genereates fibinocci series using lazy sequences"
  ([] (concat [0 1] (lazy-seq-fibinocci 0 1)))
  ([n] (take n (lazy-seq-fibinocci)))
  ([a b]
   (lazy-seq
    (cons (+ a b) (lazy-seq-fibinocci b (+ a b))))))
