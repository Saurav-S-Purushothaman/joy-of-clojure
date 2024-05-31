(ns joy-of-clojure.small-syntax
  (:gen-class))

;; This namespace contains detaials about several clojure functions
;; which are not used often by me or taken for granted

;; `for` and `doseq` does something similar
;; but `for` returns lazy-sequence and `doseq` is for generatting
;; side effects. Also doseq returns nil.

(for [x [:a :b], y (range 5) :when (odd? y)]
  [x y])

;; => ([:a 1] [:a 3] [:b 1] [:b 3])

(doseq [x [:a :b], y (range 5) :when (odd? y)]
  (prn [x y]))
