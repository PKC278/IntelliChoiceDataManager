## 部署后台数据管理系统

1. 进入项目文件夹

   ```shell
   cd RuoYi-Vue
   ```

### 后端部署

1. 安装jdk11或更高版本

2. 安装maven依赖

   ```shell
   mvn install
   ```

3. 在ruoyi-admin/src/main/resources/application-druid.yml文件第9-11行修改mysql地址以及用户名和密码

   在ruoyi-admin/src/main/resources/application.yml文件第73行修改redis地址

4. 编译jar包

   ```shell
   mvn clean package -Dmaven.test.skip=true
   ```

5. 将jar包推送到服务器

####  直接运行

1. 运行jar包

   ```shell
   java -jar ruoyi-admin.jar
   ```
   
#### 使用Docker Compose部署

1. 将Dockerfile推送到服务器
2. 修改Dockerfile中第4行jar包路径
3. 构建Docker镜像

    ```shell
    docker build --pull --rm -f "Dockerfile" -t intellichoice_ruoyi:latest "."
    ```

4. 进入网站文件夹

   ```shell
   cd /Gaokao_WebSite
   ```
   
5. 启动docker容器

   ```shell
   docker compose  -f "docker-compose.yml" up -d --build ruoyi
   ```

### 前端部署

1. 进入前端文件夹

   ```shell
   cd ruoyi-ui
   ```

2. 本机安装node 18或以上版本

3. 安装依赖

   ```shell
   npm install
   ```

4. 构建生产环境

   ```shell
   npm run build:prod
   ```

   注意：如果报错ERR_OSSL_EVP_UNSUPPORTED，请先运行以下命令导入环境变量

   ```shell
   export NODE_OPTIONS=--openssl-legacy-provider
   ```

5. 将dist文件夹推送到服务器

6. 使用web服务程序托管dist文件夹中的静态网页，如nginx，并将/prod-api路径指向后端地址，以下是nginx的配置文件示例

   ```nginx
   server {
     listen 80; # 监听端口
     listen 443 ssl http2;
     listen [::]:443 ssl http2;
   
     server_name ; # 域名
   
     # 重定向到HTTPS，强制使用HTTPS访问
     if ($scheme != "https") {
         return 301 https://$server_name$request_uri;
     }
   
     # HTTPS服务器配置
     ssl_certificate /etc/nginx/ssl/cert.pem;
     ssl_certificate_key /etc/nginx/ssl/key.pem;
   
     # SSL会话缓存参数
     ssl_session_cache shared:SSL:10m;
     ssl_session_timeout 10m;
     ssl_protocols TLSv1 TLSv1.1 TLSv1.2;
     ssl_prefer_server_ciphers on;
     ssl_ciphers ECDH+AESGCM:ECDH+AES256:ECDH+AES128:DH+3DES:!ADH:!AECDH:!MD5;
   
     location ~ /\.(?!well-known) {
         deny all;
     }
     # 配置代理路径
     location / {
         root /ruoyi-ui/dist;
         try_files $uri $uri/ /index.html;
         index index.html index.htm;
     }
   	# 配置后端路径
     location /prod-api {
         proxy_set_header Host $http_host;
         proxy_set_header X-Real-IP $remote_addr;
         proxy_set_header REMOTE-HOST $remote_addr;
         proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
         # 后端地址
         proxy_pass http://localhost:8081/;
     }
   
     error_page 500 502 503 504 /50x.html;
     location = /50x.html {
         root html;
     }
   }
   ```
