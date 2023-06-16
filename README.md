# YoutubeShare

## Introduction

This application allows the user to:
- View the list of shared videos
- Login/Register
- Share movies you like (only Youtube share button link)

## Prerequisites
- Docker & docker-compose: Install & start docker & docker-compose (DIY, refer to the link: [Docker](https://www.docker.com/))

## How to run locally

Start the application locally

First, server
```bash
# Clone youtubeshare-server:
$ git clone https://github.com/HoangHoa99/YoutubeShare.git

# Go into the repository
cd YoutubeShare/youtubeshare/

# Create .env file
$ touch .env

# Add config variable
$ vi .env

#
# Add the following variable
# Create your own Google API key and replace with this below position
#
# GOOGLE_API_KEY=[your-api-key-here]
# GOOGLE_API_HOST=https://www.googleapis.com/youtube/v3/videos?part=snippet
#

# Run the app
$ docker-compose up
```

Second, client
```bash
# Clone youtubeshare-client:
$ git clone https://github.com/HoangHoa99/YoutubeShare-client.git

# Go into the repository
cd YoutubeShare-client

# Build a docker image
$ docker build . -t youtubeshare-client

# Find your built docker-image by running this command
$ docker images

# Start your docker-image
$ docker run -p 4200:4200 [your-docker-image-id || youtubeshare-client]
```
Open the browser and access [http://localhost:4200](http://localhost:4200) to view the application

## Usage

1. View the shared video list
![Main page](https://github.com/HoangHoa99/YoutubeShare/assets/40349029/f984748c-b625-43e7-90cd-f2ed0745014b)

2. Login/Register function
![Login/Register](https://github.com/HoangHoa99/YoutubeShare/assets/40349029/417be1bc-e30f-4fd0-9e2e-2c6ba638bd8e)

3. Share a movie or logout
![Share a movie/Logout](https://github.com/HoangHoa99/YoutubeShare/assets/40349029/fa22d8d5-d137-4df5-9f8c-ff6834a7e9c5)

4. Share a movie via video URL
![Share a movie](https://github.com/HoangHoa99/YoutubeShare/assets/40349029/c0374511-6871-4296-a451-bc39b86934bb)
