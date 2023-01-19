

( JAVA SPRING-BOOT ) Learn Code API
-
JAVA Spring Boot Learn Code API

## Features

-   Login 
-   Register
-   Code Compile
-   Study Get / Set




## Contributing

Contributions are always welcome!

To get started, please take a look at the 'Issues' tab, where you will find open issues that exist with the project. If you see one that interests you, simply create a branch and submit a PR for review and approval.


# EXAMPLES


### AUTH

- USER REGISTER
```JSON
//localhost:8080/api/auth/register -> POST

//REQUEST
//BODY 
{
"username":"furkancosgun",
"password":"furkan123",
"email":"furkan51cosgun@gmail.com"
}

//RESPONSE
{
"id": 1,
"username": "furkancosgun",
"email": "furkan51cosgun@gmail.com"
}
```

- USER LOGIN
```JSON
//localhost:8080/api/auth/login -> POST

//REQUEST
//BODY 
{
"username":"furkancosgun",
"password":"furkan123"
}

//RESPONSE
{
"id": 1,
"username": "furkancosgun",
"email": "furkan51cosgun@gmail.com"
}
```



----


### LESSON

- SAVE LESSON
```JSON
//localhost:8080/api/lessons -> POST

//REQUEST
//BODY
{
"title":"TITLE",
"subTitle":"SUB TITLE",
"content":"BLA BLA",
"language":"py"
}

//RESPONSE
{
"title": "TITLE",
"subTitle": "SUB TITLE",
"content": "BLA BLA",
"language": "py",
"id": 1
}
```

- GET ALL LESSONS
```JSON
//localhost:8080/api/lessons ->GET

//RESPONSE
[{
"title": "TITLE",
"subTitle": "SUB TITLE",
"content": "BLA BLA",
"language": "py",
"id": 1
}]
```

- GET SELECTED LESSON
```JSON
//localhost:8080/api/lessons/1 ->GET

//RESPONSE
{
"title": "TITLE",
"subTitle": "SUB TITLE",
"content": "BLA BLA",
"language": "py",
"id": 1
}
```

- GET SEARCHED LESSON
```JSON
//localhost:8080/api/lessons/search?p="HERE PARAMETERS" -> GET REQUEST

//LIKE THIS
//localhost:8080/api/lessons/search?p=TI

//RESPONSE
[{
"title": "TITLE",
"subTitle": "SUB TITLE",
"content": "BLA BLA",
"language": "py",
"id": 1
}]
```
---
### CODE COMPILE
```JSON
//localhost:8080/api/compile ->POST

//REQUEST
//BODY
{
"language":"python",
"code":"for i in range(0,10):\n print(i)"
}

//RESPONSE
{
"language": "python",
"code": "\n0\n1\n2\n3\n4\n5\n6\n7\n8\n9"
}
```
