setup test

1. download docker
2. run terminal in src/main/java/docker/compose/files package : docker-compose -f docker-compose.yaml up
3. check grid console http://localhost:4444/grid/console
4. for scale instance run command: docker-compose scale chrome=5
5. run: mvn -pl selenium-docker clean test

setup jenkins-docker -> https://rangle.io/blog/running-jenkins-and-persisting-state-locally-using-docker-2/
or: 

1. docker image pull jenkins/jenkins:lts
2. docker container run -d -p 8082:8080 \
       -v jenkinsvol1:/var/jenkins_home \
       --name jenkins-local \
       jenkins/jenkins:lts
3. go to localhost:8082 and enter password using command from next step
4. docker container exec \
       [CONTAINER ID or NAME] \
       sh -c "cat /var/jenkins_home/secrets/initialAdminPassword"
5. create admin user : admin/admin       
6. install plugins (maven, github, docker etc.)   
7. for starting after shut down use:
   docker container run -d -p 8082:8080 \
    -v jenkinsvol1:/var/jenkins_home \
    --name jenkinslocal \
    jenkins/jenkins:lts  
    
    
    
    

                    


