# OpenJDK 11 이미지 가져오기
FROM openjdk:11

# 애플리케이션 JAR 파일을 컨테이너의 /app 디렉터리에 복사
# 예시에서는 빌드된 JAR 파일이 target/ 디렉터리에 있다고 가정
COPY ./target/yourapp.jar /app/app.jar

# 컨테이너가 실행될 때 JAR 파일을 실행하도록 설정
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# 애플리케이션이 사용하는 포트를 노출 (예: 8080)
EXPOSE 8080