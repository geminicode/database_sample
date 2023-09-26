from eclipse-temurin:17-centos7

LABEL name="sample_app",version="latest"
EXPOSE 8080

ARG APP_DIR=/opt/app

WORKDIR ${APP_DIR}

# COPY sample_app/target/sample_app*.jar ${APP_DIR}/java_app.jar
COPY sample_app/build/libs/sample_app.jar ${APP_DIR}/java_app.jar
COPY start-app.sh ${APP_DIR}/start-app.sh

CMD ["/opt/app/start-app.sh"]
