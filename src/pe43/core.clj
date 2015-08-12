(ns pe43.core
  (:gen-class))


(defn pandigital0-9? [number]
  (let [numstring (str number)]
    (if (= 10 (count numstring))
      (loop [i 0]
        (when (.contains numstring (str i))
          (if (= i 9)
            true
            (recur (inc i))))))))

(defn has-weird-property? [number]
  (let [numstring (str number)]
    (and (= 0 (mod (. Integer parseInt (subs numstring 1 4)) 2))
         (= 0 (mod (. Integer parseInt (subs numstring 2 5)) 3))
         (= 0 (mod (. Integer parseInt (subs numstring 3 6)) 5))
         (= 0 (mod (. Integer parseInt (subs numstring 4 7)) 7))
         (= 0 (mod (. Integer parseInt (subs numstring 5 8)) 11))
         (= 0 (mod (. Integer parseInt (subs numstring 6 9)) 13))
         (= 0 (mod (. Integer parseInt (subs numstring 7 10)) 17)))))


(defn -main
  [& args]
  

;  Test function calls
 (println (pandigital0-9? 1406357289))
 (println (has-weird-property? 1406357289))
 

   (def total 0)
   (loop [i 1023456789]
     (if (and (pandigital0-9? i) (has-weird-property? i))
       (do (println i) (def total (+ total i)) (recur (inc i)))
       (if (< i 9876543211)
         (recur (inc i))
         (println total))))
   )
