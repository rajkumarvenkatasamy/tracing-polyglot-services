docker network create tracing-polyglot-services

docker-compose -f docker-compose-1.yml up -d
timeout /T 10 /NOBREAK

docker-compose -f docker-compose-2.yml up -d
timeout /T 10 /NOBREAK

docker-compose -f docker-compose-3.yml up -d
timeout /T 10 /NOBREAK

docker-compose -f docker-compose-4.yml up -d