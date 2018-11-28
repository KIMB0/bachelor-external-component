FROM anapsix/alpine-java

RUN mkdir /var/dnikma

COPY ./out/artifacts/dnikma_jar/dnikma.jar /var/dnikma

WORKDIR /var/dnikma

ENTRYPOINT ["java", "-jar", "dnikma.jar"]