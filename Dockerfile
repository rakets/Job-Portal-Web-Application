# Najnowszy obraz Java Development Kit
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Stosowany proces roboczy: budowanie projektu Mavenem lokalnie, kopiowanie w kontener gotowego jaru
COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
