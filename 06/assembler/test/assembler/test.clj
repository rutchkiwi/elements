(ns assembler.test
  (:require [clojure.test :refer :all]
            [assembler.core :as core]))



(deftest maxL
  (let [binary (core/-main "/Users/viktor/dev/nand2tetris/projects/06/max/MaxL.asm")]
    (is (= "0000000000000000" (first binary)))
    (is (= (count "0000000000000000") (count (first binary))))
    (is (= "1111110000010000" (second binary)))
    (is (= ["0000000000000000"
            "1111110000010000"
            "0000000000000001"
            "1111010011010000"
            "0000000000001010"
            "1110001100000001"
            "0000000000000001"
            "1111110000010000"
            "0000000000001100"
            "1110101010000111"
            "0000000000000000"
            "1111110000010000"
            "0000000000000010"
            "1110001100001000"
            "0000000000001110"
            "1110101010000111"]
           binary))))
