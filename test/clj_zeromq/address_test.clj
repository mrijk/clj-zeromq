(ns clj-zeromq.address-test
  (:use clojure.test
        clj-zeromq.address))

(deftest valid-address
  (testing "Valid address"
    (is (instance? java.net.InetSocketAddress
                   (create-tcp-address "gmail.com:8080")))))

(deftest missing-port
  (testing "Missing port"
    (is (thrown? IllegalArgumentException (create-tcp-address "127.0.0.1")))))

(deftest unknown-host
  (testing "Unknown host"
    (is (thrown? IllegalArgumentException 
                 (create-tcp-address "maurits.rijk:8888")))))

(deftest test-port
  (testing "Port"
    (let [address (create-tcp-address "gmail.com:8080")]
      (is (= 8080 (get-port address))))))

;(deftest to-string-ipv4
;  (testing "String formatting"
;    (let [address (create-tcp-address "gmail.com:8080")]
;      (is (= "tcp://gmail.com:8080" (to-string address))))))
