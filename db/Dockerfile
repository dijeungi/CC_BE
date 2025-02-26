FROM mysql:8.0

COPY ./cc_db.sql /docker-entrypoint-initdb.d
ENV MYSQL_ROOT_PASSWORD=ccroot
ENV MYSQL_DATABASE=cc
ENV MYSQL_HOST=%