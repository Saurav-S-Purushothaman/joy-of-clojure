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

;; NOTE: When making fixed size values, always use recur
;; Otherwise use lazy sequence. Rule of thumb, I suppose!


(defn lazy-seq-fibinocci
  "Genereates fibinocci series using lazy sequences"
  ([] (concat [0 1] (lazy-seq-fibinocci 0 1)))
  ([n] (take n (lazy-seq-fibinocci)))
  ([a b]
   (lazy-seq
    (cons (+ a b) (lazy-seq-fibinocci b (+ a b))))))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Specs starts here

(s/def ::is-vector (s/coll-of number? :kind vector?))
(s/def ::is-number number?)

;; Specs ends here


;; binary search with tail call recursion
(defn binary-search
  "Binary search in clojure with tail call recursion"
  [arr target]
  (loop [left 0 right (count arr)]
    (if (> left right)
      -1
      (let [mid (quot (+ left right) 2)
            mid-val (nth arr mid)]
        (cond
          (= target mid-val) mid
          (> target mid-val) (recur (inc mid) right)
          :else (recur left (dec mid)))))))


;; this code should fail essentially.


(defn binary-search-type-safe
  "Binary search in clojure but with type safety"
  [arr target]
  (if (and (s/valid? ::is-vector arr)
           (s/valid? ::is-number target))
    (loop [left 0 right (count arr)]
      (if (> left right)
        -1
        (let [mid (quot (+ left right) 2)
              mid-val (nth arr mid)]
          (cond
            (= target mid-val) mid
            (> target mid-val) (recur (inc mid) right)
            :else (recur left (dec mid))))))
    (throw (Exception. "Input datatype mismatches. Please check"))))


;; this code essentially fails, with the type check
(comment
  (def my-vec '(1 2 3 4 123 12331 123123))
  (binary-search-type-safe my-vec 2))
