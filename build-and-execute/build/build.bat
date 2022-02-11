call "build-service-registry.bat
echo %CD%
docker build --no-cache -t service-registry .

cd ..\build-and-execute\build\
call "build-api-gateway.bat"
echo %CD%
docker build --no-cache -t api-gateway .

cd ..\build-and-execute\build\
call "build-java-app.bat"
echo %CD%
docker build --no-cache -t java-spring-reactive-service .

cd ..\python-flask-service
echo %CD%
docker build --no-cache -t python-flask-service .