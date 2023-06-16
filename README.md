# YoutubeShare

This application allows the user to:
- View the list of shared videos
- Login/Register
- Share movies you like (only Youtube share button link)

## How to run locally

1. Install & start docker & docker-compose (DIY, refer to the link: [Docker](https://www.docker.com/))
2. Clone client and server repo
- Client repo: [youtubeshare-client](https://github.com/HoangHoa99/YoutubeShare-client.git)
- Server repo: [youtubeshare-server](https://github.com/HoangHoa99/YoutubeShare.git)
3. Start the application locally

a. Start youtubeshare-server:
Compact disc to the root file of youtubeshare-server

Create a .env file with this command
```bash
touch .env
```
Open the .env file and add this config
```text
# ===============================
# GG API KEY
# ===============================
GOOGLE_API_KEY=your-api-key-here
GOOGLE_API_HOST=https://www.googleapis.com/youtube/v3/videos?part=snippet
```
Register your own Google API key follow to this link: [Create Youtube API key](https://rapidapi.com/blog/how-to-get-youtube-api-key/)

Run this command bellow
```bash
docker-compose up
```

b. Start youtubeshare-client:
Compact disc to the root file of youtubeshare-client

Run this command bellow
```bash
docker build . -t youtubeshare-client
```

Find your built docker-image by running this command
```bash
docker images
```

Start your docker-image
```bash
docker run -p 4200:4200 [your-docker-image-id || youtubeshare-client]
```

c. Open the browser and access [http://localhost:4200](http://localhost:4200) to view the application

## License

[MIT](https://choosealicense.com/licenses/mit/)