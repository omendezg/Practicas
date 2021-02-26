FROM node:12.18.1
 
WORKDIR /app
 
COPY package.json package.json
COPY package-lock.json package-lock.json
 
RUN npm install

RUN npm install --save express

COPY mock.js .

EXPOSE 8000
 
CMD [ "node", "mock.js" ]