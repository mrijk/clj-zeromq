(ns clj-zeromq.core
  (:use clj-zeromq.zmq))

(def ctx (create-context 1))

(defn listen-to-logstash
  "" 
  []
  (let [s (ctx-create-socket ctx zmq-sub)]
    (socket-subscribe s "")
    (socket-connect s "tcp://127.0.01:5555")
    (socket-close s)))
    
(listen-to-logstash)
