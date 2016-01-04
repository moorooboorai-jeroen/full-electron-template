(ns {{namespace}}
  (:require [cljs.nodejs :as node]))

(def electron (node/require "electron"))
(def app (node/require "app"))
(def browser-window (. BrowserWindow electron))

