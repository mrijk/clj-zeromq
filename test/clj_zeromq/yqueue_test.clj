(ns clj-zeromq.yqueue-test
  (:use clojure.test
        clj-zeromq.yqueue))

(deftest front1
  (testing "Test front"
    (let [queue (create-yqueue 5)]
      (is (= 13 (push queue 13))))))

