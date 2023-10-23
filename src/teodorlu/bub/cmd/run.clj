(ns teodorlu.bub.cmd.run
  (:require
   [clojure.edn :as edn]
   [clojure.pprint :as pprint]
   [clojure.string :as str]))

;; Install this script from Github with:
;;
;;     bbin install io.github.teodorlu/bub --latest-sha --as ,,
;;         --main-opts '["-m" "teodorlu.bub.cmd.run/-main"]'
;;
;; Install this script from a local directory with:
;;
;;     bbin install . --as ,,
;;         --main-opts '["-m" "teodorlu.bub.cmd.run/-main"]'
;;
;; Usage examples:
;;
;;     $ echo 1 | ,, inc
;;     2
;;
;;     $ echo 10 | ,, '(partial * 10)'
;;     100
;;
;;     $ echo 3 | ,, inc inc inc
;;     6

(defn -main [& args]
  (pprint/pprint
   (reduce (fn [value fn-str]
             ((eval (read-string fn-str))
              value))
           (edn/read *in*)
           args)))

(when (= *file* (System/getProperty "babashka.file"))
  (apply -main *command-line-args*))
