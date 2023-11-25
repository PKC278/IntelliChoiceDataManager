# 基础镜像
FROM  openjdk:17

COPY ruoyi-admin/target/ruoyi-admin.jar /ruoyi/ruoyi-admin.jar

WORKDIR /ruoyi

EXPOSE 8080

CMD ["java", "-jar", "ruoyi-admin.jar"]
