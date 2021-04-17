(ns assembler.core
  (:gen-class)
  (:require [clojure.java.io :as io]
            [clojure.string :as cs]))

(def c-codes {"0"   "101010"
              "1"   "111111"
              "-1"  "111010"
              "D"   "001100"
              "A"   "110000"
              "!D"  "001101"
              "!A"  "110001"
              "-D"  "001111"
              "-A"  "110011"
              "D+1" "011111"
              "A+1" "110111"
              "D-1" "011111"
              "A-1" "110010"
              "D+A" "000010"
              "D-A" "010011"
              "A-D" "000111"
              "D&A" "000000"
              "D|A" "010101"})

(def d-codes {"null" "000"
              "M"    "001"
              "D"    "010"
              "MD"   "011"
              "A"    "100"
              "AM"   "101"
              "AD"   "110"
              "AMD"  "111"})

(defn parser [l]
  ())

(defn parse-c [l]
  (let [[dest calc] (cond
                      (cs/includes? l "=")
                      (cs/split l #"=|;")

                      :default
                      (cs/split l #""))
        a (cs/includes? calc "M")]
    (printf "C instruction. %s\n" l)
    (str
      "111"
      "0"                                           ;a
      (c-codes calc)
      ""
      (d-codes dest)
      ""
      "000")))

(defn -main
  [& args]
  (let [lines (line-seq (io/reader (first args)))]
    (println (count lines))
    (doall (for [l lines
                 :let [line2 (-> l (cs/replace #"/.*" "") (cs/trim))]
                 :when (not-empty line2)]
             (do
               (println l)
               (if (cs/starts-with? l "@")
                 ; A instruction
                 ; write as binary
                 "0000000000000000"
                 ; C instruction
                 (parse-c l)))))))

(println (cs/join "\n" (-main "../max/MaxL.asm")))