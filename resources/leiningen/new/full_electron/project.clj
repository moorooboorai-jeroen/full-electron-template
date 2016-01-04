(defproject {{name}} "0.1.0-SNAPSHOT"
            :dependencies [[org.clojure/clojure "1.7.0"]
                           [org.clojure/clojurescript "1.7.170"]]
            :plugins [[lein-cljsbuild "1.1.2"]
                      [lein-figwheel "0.5.0-1"]]
            :clean-targets ^{:protect false} ["target"]
            :cljsbuild {
                        :builds [{:id "dev"
                                  :source-paths ["src"]
                                  :figwheel true
                                  :compiler {:main {{namespace}}
                                             :output-to "target/out/main.dev.js"
                                             :output-dir "target/out"
                                             :target :nodejs
                                             :optimizations :none
                                             :source-map true }}
                                 {:id "prod"
                                  :source-paths ["src"]
                                  :compiler {:main {{namespace}}
                                             :output-to "main.js"
                                             :target :nodejs
                                             :optimizations :simple ;; notice this!
                                             }}]}
            :figwheel {})
