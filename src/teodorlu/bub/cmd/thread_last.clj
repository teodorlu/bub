(ns teodorlu.bub.cmd.thread-last
  (:require
   [clojure.edn :as edn]
   [clojure.pprint :as pprint]))

;; Install this script from Github with:
;;
;;     bbin install io.github.teodorlu/bub --latest-sha --as ,,thread-last --main-opts '["-m" "teodorlu.bub.cmd.thread-last/-main"]'
;;
;; Install this script from a local directory with:
;;
;;     bbin install . --as ,,thread-last --main-opts '["-m" "teodorlu.bub.cmd.thread-last/-main"]'
;;
;; Usage examples:
;;
;;     $ echo 1 | ,,thread-last inc inc inc inc
;;     5
;;
;;     $ bb -e '(repeatedly 20 rand)' | ,,thread-last sort '(drop 4)' '(drop-last 4)' '(reduce +)'
;;     4.3241752879471305

(defn -main [& args]
  (let [f-code
        `(fn [x#]
           (->> x# ~@(map read-string args)))]
    (pprint/pprint
     ((eval f-code)
      (edn/read *in*)))))

(when (= *file* (System/getProperty "babashka.file"))
  (apply -main *command-line-args*))
