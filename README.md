# bachelor-external-component
This is a external component ment to be running in a Docker container

## Setup
You have to have Docker to run this component.

Start by building the image by writing the following in the terminal:
```docker build -t sentence-reverser .```

Then you can run a container containing the new image by writing in the terminal:
````docker run -e "SENTENCE=Your string to reverse" -e "WEBHOOKURL=Your webhook URL" sentence-reverser ````

Now you should see the string printed out reversed.