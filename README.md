# Todolist with Spring Boot

Project developer in course by @[Rocketseat](https://rocketseat.com.br), learning language Java with Spring boot.

This is a simple todo list with JWT validation.

## Testing this API

- **CREATING A USER**:

Using this route `POST`

```prompt
https://jacksonsr45-todolist.onrender.com/api/v1/users
```

Send a `JSON`:

```json
{
  "name": "You Name",
  "username": "username",
  "email": "email@gmail.com",
  "password": "YourPassword"
}
```

- **LOGIN**:

```prompt
https://jacksonsr45-todolist.onrender.com/api/v1/auth/login
```

Send a `JSON`

```json
{
  "username": "username",
  "password": "password"
}
```

Response this is a `token`

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImphY2tzb25zcjQ1IiwiZXhwIjoxNjk3MjIxMjEyfQ.l2uaRbawuvKdO0W4AwcPn_gpp3_xcI5o9ovo1gwNiw0"
}
```

- **CREATE UPDATE AND GET TASKS**:

By this routes is required sent a `Authorization Bearer` with your `token` get in login.

**POST**

```prompt
https://jacksonsr45-todolist.onrender.com/api/v1/tasks
```

Send with `JSON`

```json
{
  "title": "Primary Task",
  "description": "Task by test",
  "startAt": "2023-11-14T00:00:00",
  "endAt": "2024-11-01T00:00:00",
  "steps": [],
  "progress": "init",
  "priority": ""
}
```

**GET**

```prompt
https://jacksonsr45-todolist.onrender.com/api/v1/tasks
```

This route receive a response

```json
[
  {
    "id": "bb51bbd4-05c2-4220-82d3-1bd5e6ff7e66",
    "description": "Task by test",
    "title": "Primary Task",
    "startAt": "2023-11-14T00:00:00",
    "endAt": "2024-11-01T00:00:00",
    "steps": [],
    "progress": "init",
    "priority": "",
    "userId": "2ec37c68-bd96-4ed5-a5b8-3dd5980da06e",
    "createdAt": "2023-10-13T13:21:55.205577",
    "updatedAt": "2023-10-13T13:21:55.205623"
  }
]
```

**PUT**

```prompt
https://jacksonsr45-todolist.onrender.com/api/v1/tasks/id-to-task-here
```

example:

```prompt
https://jacksonsr45-todolist.onrender.com/api/v1/tasks/bb51bbd4-05c2-4220-82d3-1bd5e6ff7e66
```

Send a `JSON` with value to update

```json
{
  "title": "Title updated"
}
```

This receive a response

```json
{
  "id": "bb51bbd4-05c2-4220-82d3-1bd5e6ff7e66",
  "description": "Task by test",
  "title": "Title updated",
  "startAt": "2023-11-14T00:00:00",
  "endAt": "2024-11-01T00:00:00",
  "steps": [],
  "progress": "init",
  "priority": "",
  "userId": "2ec37c68-bd96-4ed5-a5b8-3dd5980da06e",
  "createdAt": "2023-10-13T13:21:55.205577",
  "updatedAt": "2023-10-13T13:21:55.205623"
}
```
