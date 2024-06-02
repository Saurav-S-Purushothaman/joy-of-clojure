(ns joy-of-clojure.chess)
;; chess game implementation
;; Just starting template

(defn initial-board
  "Initialize a chess board. Each elements represent a square in chess
  and those character represent what is currently at that square.
  These characters can be interpreted as follows:
  r : rook
  n : knight
  b : bishop
  q : queen
  k : king
  - : empty squre

  Small letters mean black piece. Captial letters mean white piece.

  *Args* : nil
  *Return*: vector
  - -"
  []
  [\r \n \b \q \k \b \n \r
   \p \p \p \p \p \p \p \p
   \- \- \- \- \- \- \- \-
   \- \- \- \- \- \- \- \-
   \- \- \- \- \- \- \- \-
   \- \- \- \- \- \- \- \-
   \P \P \P \P \P \P \P \P
   \R \N \B \Q \K \B \N \R])

;; query the squres of the chess board
(def ^:dynamic *file-key* \a)
(def ^:dynamic *rank-key* \0)

(defn- file-component
  [file]
  (- (int file) (int *file-key*)))

(defn- rank-component
  [rank]
  (->> (int *rank-key*)
       (- (int rank))
       (- 8)
       (* 8)))

(defn- index
  [file rank]
  (+ file-component file) (rank-component rank))

(defn lookup
  [board position]
  (let [[file rank] position]
    (board (index file rank))))

(lookup (initial-board) "a1") ;; => \R
