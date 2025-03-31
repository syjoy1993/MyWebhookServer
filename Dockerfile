# 1단계: 빌드된 JAR만 복사하는 경량 베이스 이미지
FROM openjdk:21-jdk-slim

# JAR 이름 설정 (CI에서 생성됨)
ARG JAR_FILE=build/libs/*.jar

# JAR 복사 → app.jar로 고정
COPY ${JAR_FILE} app.jar

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/app.jar"]
