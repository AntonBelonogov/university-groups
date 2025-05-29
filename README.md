# university-groups

## Краткая информация

Web приложение для работы со студентами и группами.
Приложение состоит из нескольких модулей:

- Backend:
    - Java 17
    - Spring Boot
    - Spring Data
    - Thymeleaf
    - Lombok
    - OpenApi (Swagger)
>Используемый порт: 8080

- Frontend:
    - Vue
    - Vite
>Используемый порт: 5173

- Database:
    - MySQL

Поддерживается запуск как отдельных компонентов, так и через `Docker Compose`.

## Backend API

При запуске приложения url для просмотра OpenAPI (Swagger) будет находится по адресу:
```
http://localhost:8080/v3/api-docs
```

Реализован CRUD для сущностей Student и Group
Для POST запросов используется DTO

StudentInputDto
```json
{
  "fio": ""
}
```
>Обязательное соответствие регулярному выражению:
`^[А-ЯЁ][а-яё]+ [А-ЯЁ][а-яё]+( [А-ЯЁ][а-яё]+)?$`

GroupInputDto
```json
{
  "groupName": ""
}
```
>Обязательное соответствие регулярному выражению:: `^\\d{2}-\\d{2}$`
## Запуск приложения
### С использованием Docker-a

- Иметь на компьютере Docker Desktop
- Перейти в папку всего проекта, где расположен файл `docker-compose.yaml` и запустить команду `docker-compose up -d`
- После этого docker сам скачает все образы которые ему нужны и развернет их

>Если образы не скачиваются то нужно перейти в настройки Docker Desktop.
Settings -> Docker Engine и вставить JSON:
 ```json
 {
  "builder": {
    "gc": {
      "defaultKeepStorage": "20GB",
      "enabled": true
    }
  },
  "experimental": false,
  "registry-mirrors": [
    "https://mirror.gcr.io",
    "https://daocloud.io",
    "https://c.163.com/",
    "https://registry.docker-cn.com"
  ]
}
```
После этого образы будут загружаться
### Без Docker-a
#### Backend
1. Убедись, что MySQL запущен локально. По умолчанию настройки:
```yaml
host: localhost
port: 3306
database: students_db
user: root
password: root
```

> При необходимости — измени эти параметры в `application.properties`.

В проекте использовать глобальную команду:
```bash
mvn spring-boot:run
```
Или если имеется `.jar` файл, то можно использовать команду
 ```bash
java -jar target/university-groups-0.0.1-SNAPSHOT.jar
 ```

#### Frontend
Необходимо установить зависимости:
```bash
npm install
```

Запустить dev-сервер находясь в папке проекта
```bash
npm run dev
```

Приложение будет доступно по адресу:
```
http://localhost:5173
```