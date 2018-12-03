FROM anapsix/alpine-java

RUN mkdir /var/sentence-reverser

COPY ./out/artifacts/sentence_reverser_jar/sentence-reverser.jar /var/sentence-reverser

WORKDIR /var/sentence-reverser

ENTRYPOINT ["java", "-jar", "sentence-reverser.jar"]