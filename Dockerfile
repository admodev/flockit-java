FROM node:alpine

WORKDIR ./spa

COPY package.json ./
COPY package-lock.json ./
COPY ./ ./src

WORKDIR ./src

RUN npm install

CMD ["npm", "run", "start"]