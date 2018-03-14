# study
## wss(server and client)
#### websocket server
+ tomcat8
+ JavaEE 7
+ [ServerEndpoint](https://github.com/wanmbv/study/blob/master/WebSocket.java)
#### websocket client
+ [java websocket](https://github.com/TooTallNate/Java-WebSocket)
+ [js WebSocket](https://github.com/wanmbv/study/blob/master/WebSocket.js)

#### tomcat ssl
    keytool -genkey -alias tomcat -keyalg RSA -keystore F:\tomcat.keystore -validity 36500
+ tomcat server.xml配置
> <Connector port="443" protocol="HTTP/1.1" SSLEnabled="true"
               maxThreads="150" scheme="https" secure="true"
               clientAuth="false" sslProtocol="TLS" keystoreFile="F:/tomcat.keystore" keystorePass="密码"/>
+ [wss java client](https://github.com/TooTallNate/Java-WebSocket/blob/master/src/main/example/SSLClientExample.java)
