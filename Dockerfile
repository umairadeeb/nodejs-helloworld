FROM node
EXPOSE 3000

COPY . /home/node/app

CMD ["node", "app.js"]