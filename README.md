<!DOCTYPE html>
<html>
   <body>
      <h1>Basic command for selenoid</h1>
      <p>.\cm.exe selenoid-ui status</p>
      <p>.\cm.exe selenoid status</p>
      <p>docker kill -s HUP selenoid</p>
      <p>docker logs -f selenoid</p>
      <p>docker run -d --name selenoid-ui --link selenoid -p 8080:8080 aerokube/selenoid-ui --selenoid-uri=http://selenoid:4444</p>
      <p>.\cm.exe selenoid start</p>
      <p>.\cm.exe selenoid-ui start</p>
   </body>	
</html>
