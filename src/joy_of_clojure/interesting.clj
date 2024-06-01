(ns joy-of-clojure.interesting)
;; this namespace contains interesting programs/functions

(defn l->rfix
  "Function that solves math equations,evaluated left to right"
  ([a op b] (op a b))
  ([a op1 b op2 c] (op2 c (op1 b a)))
  ([a op1 b op2 c op3 d] (op3 d (op2 c (op1 b a)))))

(defn r->lfix
  "Function that solves math equations,evaluated left to right"
  ([a op b] (op a b))
  ([a op1 b op2 c] (op1 a (op2 b c)))
  ([a op1 b op2 c op3 d] (op1 a (op2 b (op3 c d)))))

(r->lfix 1 + 2)          ;; => 3
(r->lfix 1 + 2 + 3)      ;; => 6
(r->lfix 1 + 2 + 3 + 4)  ;; => 10

(l->rfix 1 + 2)          ;; => 3
(l->rfix 1 + 2 + 3)      ;; => 6
(l->rfix 1 + 2 + 3 + 4)  ;; => 10

;; Creating precedence for operands
(def order {+ 0 - 0 * 1 / 1})

(defn infix3 [a op1 b op2 c]
  "Function that converts prefix notation to infix notation and
  evaluates the mathematical expression"
  (if (> (get order op1) (get order op2))
    (l->rfix a op1 b op2 c)
    (r->lfix a op1 b op2 c)))

(infix3 10 * 2 + 3)  ;; => 23
(infix3 10 + 2 * 3)  ;; => 16

;; this is the source of the '+' operator
;; you can get it by running this command in the repl
(source +)
;; how cool is that!!!!


(defn +
  "Returns the sum of nums. (+) returns 0. Does not auto-promote
  longs, will throw on overflow. See also: +'"
  {:inline (nary-inline 'add 'unchecked_add)
   :inline-arities >1?
   :added "1.2"}
  ([] 0)
  ([x] (cast Number x))
  ([x y] (. clojure.lang.Numbers (add x y)))
  ([x y & more]
   (reduce1 + (+ x y) more)))
