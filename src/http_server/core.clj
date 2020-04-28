(ns http_server.core
  (:gen-class))

(defn write-hello-world []
  (println "hello world!"))

(defn -main []
  (write-hello-world ))
