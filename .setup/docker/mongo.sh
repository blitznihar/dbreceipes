docker run -p 27017:27017 --name mongov -v /Volumes/D/Workspace/Docker/vol/mongo:/data/db -d mongo:latest
docker exec -i -t mongov bash
mongo
use admin
db.createUser({user: 'admin', pwd: 'password', roles: [{role: 'userAdminAnyDatabase', db: 'admin'}]});
