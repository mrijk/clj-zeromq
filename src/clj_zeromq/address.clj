(ns clj-zeromq.address)

(defn- get-all-by-name
  ""
  [name]
  (try 
    (java.net.InetAddress/getAllByName name)
    (catch java.net.UnknownHostException e 
      (throw (IllegalArgumentException. e)))))

(defn- inet6-address?
  ""
  [address]
  (instance? java.net.Inet6Address address))

(defn- find-first-inet-address
  ""
  [name ipv4only]
  (first (filter #(not (and ipv4only (inet6-address? %))) 
                 (get-all-by-name name))))

(defn- resolve-name
  ""
  [name ipv4only]
  (let [delimiter (.lastIndexOf name ":")]
    (if (< delimiter 0)
      (throw (IllegalArgumentException. name))
      (let [addr (subs name 0 delimiter)
            port (read-string (subs name (inc delimiter)))]
        [port (find-first-inet-address addr ipv4only)]))))

(defn create-tcp-address
  ""
  [address]
  (let [[port addr] (resolve-name address false)]
    (java.net.InetSocketAddress. addr port)))

(defn get-port
  ""
  [address]
  (.getPort address))

(defn to-string
  ""
  [address]
  (let [hostaddress (.getHostAddress (.getAddress address))
        port (get-port address)]
    (if (inet6-address? address)
      (str "tcp://[" hostaddress "]:" port)
      (str "tcp://" hostaddress ":" port))))
