#Set the base image for creating the react application
FROM node:20-alpine AS build
WORKDIR /app
COPY package*.json ./
# install dependencies
RUN npm install
# copy the rest of the files to the working directory
COPY . .
# expose the port of the client for the container to listen
EXPOSE 5173
# Run the app
RUN npm run build
CMD ["npm", "run", "dev"]