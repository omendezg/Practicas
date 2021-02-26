FROM registry.access.redhat.com/ubi8/nodejs-10
#directorio de trabajo
WORKDIR /opt/testjs
#Copiamos nuestra app
COPY app.js .
#exponemos el puerto 5000 de nuestra app
EXPOSE 5000
ENV MESSAGE Docker Containers "ARQUITECTO DE APIS Y MICROSERVICIOS 4 GENERACIÓN 2020"
#este comando ejecuta
CMD ["node","app.js"]
