FROM mysql:8.1.0

LABEL "Project"="Liass Project"
LABEL "Author"="Thierno FALL"

ENV MYSQL_ROOT_PASSWORD="root"
ENV MYSQL_DATABASE="ProjetLiasseFiscale"


ADD db_backup.sql docker-entrypoint-initdb.d/db_backup.sql