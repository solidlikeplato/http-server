(defproject http_server "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                [org.clojure/core.async "1.1.587"]]
  :min-lein-version "2.0.0"
  :main http_server.core
  :aot [http_server.core]
  :uberjar-name "http_server-0.1.0-SNAPSHOT-standalone.jar"
  :heroku {
           :app-name "http-server"
           :jdk-version "1.8"
           :include-files ["target/http_server-0.1.0-SNAPSHOT-standalone.jar"]
           :process-types { "web" "java -jar target/http_server-0.1.0-SNAPSHOT-standalone.jar" }
           })