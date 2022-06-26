# rookie_review_tool_be

## 若手エンジニア向けコミュニティツール_BE

## 使用技術
### BE
* Java
* SpringBoot
* SpringSecurity

### DB
* MySql
* MyBatis

### Session Store
* Redis

### Test
* JUnit

### infrastructure
* GithubActions
* docker
* AWS

## 起動方法
* イメージのビルド  
```$ docker-compose build```

* コンテナの作成  
```$ docker-compose up -d```

* 立ち上がったコンテナを確認  
```$ docker ps -a```

* 起動したコンテナにログイン（コンテナ名は上記で確認したもの）  
```$ docker exec -it コンテナ名 bash -p``` or ```$ docker exec -it コンテナID bash -p``` 
