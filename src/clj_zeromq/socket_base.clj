(ns clj-zeromq.socket-base
  (:use clj-zeromq.tcp-listener))

;;; Sub.java

(defn create-sub []
  )

;;; SocketBase.java

(defn socket-base-create [type]
  (create-sub))

(defn socket-base-close [socket])

(defn- check-protocol [protocol]
  (if (not= protocol "tcp")
    (throw (UnsupportedOperationException. protocol)))
)

(defn- add-tcp-listener [addr]
  (let [listener (create-tcp-listener)]
    (tcp-listener-set-address listener addr)
    ))

(defn socket-base-connect [socket addr]
  (let [uri (java.net.URI. addr)
        protocol (.getScheme uri)
        address (.getAuthority uri)]
    (check-protocol protocol)
    (if (= protocol "tcp")
      (add-tcp-listener address))))


