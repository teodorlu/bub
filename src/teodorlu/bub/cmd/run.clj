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

(defn -main [& args]
  (let [value (edn/read *in*)
        function (eval (read-string (str/join " " args)))]
    (pprint/pprint (function value))))

(when (= *file* (System/getProperty "babashka.file"))
  (apply -main *command-line-args*))
