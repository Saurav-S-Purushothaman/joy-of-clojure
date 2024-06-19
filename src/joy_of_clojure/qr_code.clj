(ns joy-of-clojure.qr-code
  (:require [clj.qrgen :as qr]
            [clojure.java.io :as io]))

(qr/as-fi (qr/from "https://www.google.com")
            "/User/sauravaspurushothamanQRCode.png")

(def data (qr/as-bytes (qr/from "https://google.com" :size [250 250] :image-type qr/PNG)))

(defn save-image [byte-array filename]
  (with-open [w (clojure.java.io/output-stream filename)]
    (.write w byte-array)))

(save-image data "image.png")
