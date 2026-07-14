#FROM node:20-alpine AS builder
#WORKDIR /app
#COPY package*.json ./
#RUN npm install
#COPY . .
#RUN npm run build
#EXPOSE 5173
#CMD ["npm", "run", "preview", "--", "--host"]

#stage 1: build stage
FROM node:20-alpine AS builder
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

#stage 2: serve stage
FROM nginx:stable-alpine
COPY --from=builder /app/dist /urs/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]