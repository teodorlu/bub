(ns teodorlu.bub.cmd.from-lines
  (:require
   [clojure.pprint :as pprint]
   [clojure.string :as str]))

;; Install this script from Github with:
;;
;;     bbin install io.github.teodorlu/bub --latest-sha --as ,,from-lines --main-opts '["-m" "teodorlu.bub.cmd.from-lines/-main"]'
;;
;; Install this script from a local directory with:
;;
;;     bbin install . --as ,,from-lines --main-opts '["-m" "teodorlu.bub.cmd.from-lines/-main"]'
;;
;; Usage examples:
;;
;;     $ ls -p | grep -v / | xargs wc -l | ,,from-lines | ,,thread-last '(map str/trim)' '(map #(str/split % #" +"))' '(map reverse)' '(map vec)' '(into {})'
;;     {"README.md" "46", "bb.edn" "1", "deps.edn" "1", "total" "48"}

(defn -main [& _args]
  (pprint/pprint
   (into []
         (str/split-lines (slurp *in*)))))

(when (= *file* (System/getProperty "babashka.file"))
  (apply -main *command-line-args*))
