(ns teodorlu.bub.cmd.thread-first
  (:require
   [clojure.edn :as edn]
   [clojure.pprint :as pprint]))

;; Install this script from Github with:
;;
;;     bbin install io.github.teodorlu/bub --latest-sha --as ,, --main-opts '["-m" "teodorlu.bub.cmd.thread-first/-main"]'
;;
;; Install this script from a local directory with:
;;
;;     bbin install . --as ,,thread-first --main-opts '["-m" "teodorlu.bub.cmd.thread-first/-main"]'
;;
;; Usage examples:
;;
;;     $ echo "HEI" | ,,thread-first str/lower-case '(str/replace #"e" "o")'
;;     "hoi"
;;
;;     $ echo 1 | ,,thread-first inc inc inc inc
;;     5

(defn -main [& args]
  (let [f-code
        `(fn [x#]
           (-> x# ~@(map read-string args)))]
    (pprint/pprint
     ((eval f-code)
      (edn/read *in*)))))

(when (= *file* (System/getProperty "babashka.file"))
  (apply -main *command-line-args*))
