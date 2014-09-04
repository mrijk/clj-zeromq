(ns clj-zeromq.zmq
  (:use clj-zeromq.socket-base))

(def zmq-sub 1)
(def zmq-subscribe 42)

(defn zmq-init [ioThreads]
  )

;;; ZMQ

(defn create-socket [ctx type]
  (socket-base-create type))

;;; ZMQ.java, class Socket

(defn- setsockopt [socket option value])

(defn- may-raise [socket]
  )

(defn socket-subscribe [socket topic]
  (setsockopt socket zmq-subscribe topic))

(defn socket-connect [socket addr]
  (socket-base-connect socket addr)
  (may-raise socket))

(defn socket-close [socket]
  (socket-base-close socket))

;;;;

(defn create-context [ioThreads]
  (zmq-init ioThreads))

(defn ctx-create-socket [ctx type]
  (create-socket ctx type))
