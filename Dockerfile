#FROM 元となるイメージを指定
FROM openjdk:14-slim

# ENV 環境変数を設定
    # APP_ROUTE アプリのディレクトリ あとでワーキングディレクトリに指定
    # LANG デフォルトエンコーディングの設定
ENV APP_ROUTE=/rookie_review_tool \
    LANG=en_US.UTF-8

# WORKDIR ワーキングディレクトリの指定
WORKDIR $APP_ROUTE

# COPY コピーコマンド
    # ホストマシンのソースコードをコンテナ内のアプリにコピーする
COPY . /$APP_ROUTE

# RUN イメージビルドの際にコマンドを命令
    # gradle install
RUN ./gradlew clean build
