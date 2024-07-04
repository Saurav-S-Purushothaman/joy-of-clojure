(ns joy-of-clojure.qr-code
  (:require [clj.qrgen :as qr]
            [clojure.java.io :as io]))

(qr/as-fi (qr/from "https://www.google.com")
            "/User/sauravaspurushothamanQRCode.png")

(def data (qr/as-bytes (qr/from "https://google.com" :size [250 250] :image-type qr/PNG)))

(defn save-image [byte-array filename]
  (with-open [w (clojure.java.io/output-stream filename)]
    (.write w byte-array)))


(defn byte-array-to-image [byte-array]
  (try
    (with-open [input-stream (java.io.ByteArrayInputStream. byte-array)]
      (javax.imageio.ImageIO/read input-stream))
    (catch Exception e
      (println "Error converting byte array to image:" (.getMessage e)))))

(def test (byte-array-to-image data))



(save-image data "image.png")
