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

(fibinocci 10)
