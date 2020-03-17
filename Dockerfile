FROM openjdk:11

ARG APP_HOME=/opt/json-presenter
ARG APP_JAR=presenter.jar

ENV TZ=Europe/Moscow\
    HOME=$APP_HOME \
    JAR=$APP_JAR

EXPOSE 8888
WORKDIR $HOME
COPY build/libs/presenter-*.jar $HOME/$JAR
ENTRYPOINT java $JAVA_OPTS -jar $JAR