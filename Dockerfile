FROM node
EXPOSE 3000

COPY . /home/node/app

WORKDIR /home/node/app/hello-world

RUN npm install -g

CMD ["node", "app.js"]
