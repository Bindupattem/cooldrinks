FROM openjdk:17

WORKDIR /app

COPY src/CoolDrinksMenu.java .

RUN javac CoolDrinksMenu.java

CMD ["java", "CoolDrinksMenu"]
