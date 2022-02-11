FROM openjdk:8u312

ENV APP_NAME=service-registry
ADD /build/distributions/${APP_NAME}-boot-*.zip ${APP_NAME}.zip
RUN unzip ${APP_NAME}.zip -d /tmp/${APP_NAME} && mv /tmp/${APP_NAME}/${APP_NAME}* /${APP_NAME}
WORKDIR /${APP_NAME}
CMD ["sh", "-c", "bin/${APP_NAME}", "--spring.config.additional-location=file:/${APP_NAME}/config/application.properties"]