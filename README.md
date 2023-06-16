# YoutubeShare

This application allows the user to:
- View the list of shared videos
- Login/Register
- Share movies you like (only Youtube share button link)

## How to run locally

Install & start docker & docker-compose (DIY, refer to the link: [Docker](https://www.docker.com/))

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

## License

[MIT](https://choosealicense.com/licenses/mit/)
