# install the following
java17  
maven  
docker

# docker 
if wsl update is needed run powershell in administrator mode and run "wsl --update"

# docker rabbit mq
docker run -it -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.10-management-alpine
access the rabbitMQ management page localhost:15672 guest/guest
add exchange and route then bind them together

# apache components documentation
https://camel.apache.org/components/3.20.x/index.html  
when using a component, please add the <i>SPRING BOOT AUTO-CONFIGURATION</i> in the pom file


# apache camel notes
routeId is the name of the route  
