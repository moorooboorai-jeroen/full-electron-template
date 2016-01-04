(ns leiningen.new.full-electron
  (:require [clojure.string :as string]
            [clojure.java.io :as io]
            [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "full-electron"))

;; Thanks David Nolen for inspiration on this one,
;; see https://github.com/swannodette/ejecta-cljs-template/blob/master/src/leiningen/new/ejecta_cljs.clj#L7-L8
(defn camelize [s]
  (let [segments (string/split s #"-")
        trailing-camels (apply str (map #(apply str (.toUpperCase (str (first %))) (rest %)) (rest segments)))]
    (string/join [(.toLowerCase (first segments)) trailing-camels])))

(defn copy-file [source-path dest-path]
  (io/copy (io/file source-path) (io/file dest-path)))

(def proj-dir (io/file (System/getProperty "leiningen.original.pwd")))

(defn binary [file]
  ;; @TODO: Fix hard coded 'path' shizzle.
  (io/input-stream (io/resource (string/join "/" ["leiningen" "new" "full_electron" file]))))

(defn full-electron
  "A working skeleton application allowing for live coding, packaging and
  installing Electron based desktop applications."
  [name & other-options]
  (let [data {:name      name
              :sanitized (name-to-path name)
              :camelized (camelize name)
              :namespace (string/join [name ".core"])
              :appname   (string/join [(camelize name) "App"])}]
    (main/info "Generating fresh 'lein new' full-electron project.")
    (->files data
             ["README.md" (render "README.md" data)]
             ["project.clj" (render "project.clj" data)]
             ["package.json" (render "package.json" data)]
             ["build-config.json" (render "build-config.json" data)]
             ["index.html" (render "index.html" data)]
             ["src/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["assets/osx/installer.png" (binary "assets/osx/installer.png")]
             ["assets/osx/mount.icns" (binary "assets/osx/mount.icns")]
             ["assets/win/icon.ico" (binary "assets/win/icon.ico")]
             )
    ))
