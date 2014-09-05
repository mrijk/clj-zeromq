(ns clj-zeromq.tcp-listener
  (:use clj-zeromq.address))

;;; TcpListener.java

(defn create-tcp-listener []
  )

(defn tcp-listener-set-address [listener addr]
  (let [address (create-tcp-address addr)
        handle (java.nio.channels.ServerSocketChannel/open)
        socket (.socket handle)]
    (.configureBlocking handle false)
    (.setReuseAddress socket true)
    (.bind socket address 100)))
