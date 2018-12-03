# bachelor-external-component
This is a external component ment to be running in a Docker container

## Setup
You have to have Docker to run this component.

Start by building the image by writing the following in the terminal:
```docker build -t sentence-reverser .```

Then you can run a container containing the new image by writing in the terminal:
```docker run -e "SENTENCE=Your string to reverse" -e "WEBHOOKURL=Your webhook URL" sentence-reverser ```

Now you should see the string printed out reversed.
This is a external component meant to be running in a Docker container

## Update 03-12-2018
The image is now in a Docker repository on Docker Hub and you can run it without building this app. Just write in the terminal:

```docker run -e "SENTENCE=Your string to reverse" -e "WEBHOOKURL=Your webhook URL" kimsen1992/sentence-reverser```
