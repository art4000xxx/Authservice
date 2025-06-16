# AuthService

Простой сервис авторизации на **Spring Boot**, реализующий проверку пользователей по логину и паролю с возвратом их разрешений.

## 📌 Описание

Сервис обрабатывает `GET`-запросы на:
/authorize?user=<ИМЯ_ЮЗЕРА>&password=<ПАРОЛЬ_ЮЗЕРА>

Возвращает список разрешений (`READ`, `WRITE`, `DELETE`) для валидных пользователей. Поддерживает:

- валидацию входных данных,
- кастомную обработку ошибок.

## ⚙️ Основные возможности

- **Авторизация**: Проверяет логин и пароль, возвращает разрешения.
- **Обработка ошибок**:
  - `HTTP 400` — неверные данные (пустой логин или пароль),
  - `HTTP 401` — неизвестный пользователь.
- **Продвинутая версия**:
  - Принимает объект `User` с валидацией через `@Valid`,
  - Поддерживает кастомный `HandlerMethodArgumentResolver`.

## 🛠️ Технологии

- Java 17  
- Spring Boot 3.3.4  
- Lombok — уменьшение бойлерплейта  
- Spring Validation — проверка данных  
- Maven — управление зависимостями  

## 🚀 Установка и запуск

```bash
# 1. Клонируйте репозиторий
git clone https://github.com/art4000xxx/Authservice.git

# 2. Перейдите в директорию проекта
cd Authservice

# 3. Соберите и запустите приложение
mvn clean install
mvn spring-boot:run
 Примеры запросов
http://localhost:8080/authorize?user=admin&password=admin123
→ ["READ", "WRITE", "DELETE"]
http://localhost:8080/authorize?user=user&password=user123
→ ["READ"]
Неверные данные:

400: User name or password is empty

Неизвестный пользователь:

401: Unknown user <username>
Автор: art4000xxx

