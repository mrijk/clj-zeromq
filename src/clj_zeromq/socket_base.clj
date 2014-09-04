(ns clj-zeromq.socket-base)

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

(defn- add-tcp-listener [addr])

(defn socket-base-connect [socket addr]
  (let [uri (java.net.URI. addr)
        protocol (.getScheme uri)]
    (check-protocol protocol)
    (if (= protocol "tcp")
      (add-tcp-listener addr))))


