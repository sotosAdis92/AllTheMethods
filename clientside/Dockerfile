#Set the base image for creating the react application
FROM node:20-alpine

# create a user with permissions to run the app
# -S => create a system user
# -G => add the user to a group
# This is done to avoid running the app as root
# If the app is run as root, any vulnerability in the app can be exploited to gain access to the host system
# it is good practice to run the app as non-root user
RUN addgroup app && -S -G app app

#Set user to run the application
USER app

#Set the working directory to /app
WORKDIR /app

COPY package*.json ./

# The next three lines of code can be a little overkill but they are permission statements to just be safe
USER root
RUN chown -R app:app .
USER app
# end of permission statements

# install dependencies
RUN npm install

# copy the rest of the files to the working directory
COPY . .



