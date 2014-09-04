; Implementation of YQueue.java
; Let Clojure do the memory management

(ns clj-zeromq.yqueue)

(defn create-yqueue
  ""
  [size]
  (list))

(defn front
  ""
  [queue]
  (first queue))

(defn push
  "Adds an element to the back end of the queue."
  [queue val]
  (concat queue (list val)))
