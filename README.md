
# Project Title

this project represents a SpringBoot api that exposes three services:
  * one that allows to register a user
  * a second one that displays all the users' details
  * a thrid one that displays the details of a registered user

In this project i used h2 as my embedded database to save data and get data using postman requests, 


## API Reference

#### Get user

```http
  GET /api/users/${username}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `username`      | `string` | **Required**. username of user to fetch |

#### Post user

```http
  POST /api/users/add
```
```
{
    "username": "Melanie",
    "birthdate": "10/01/2000",
    "country": "France",
    "phone": "0707070707",
    "gender": "F"
}
```

## Exceptions
A user can be added if he has all of this criterias:
  * is an adult
  * is a french resident
  * birthdate/country/username are not null


## Test

### Postman
We can test our API with Postman to see if we can post and get
a user. We can also test that our exceptions return what we want.
We need to test all the aspects of the project to make sure that
everything is working like it is supposed to.

### Unit test
The unit tests are supposed to test every method inside the code
and make sure that each one of them is working and give the expected
result. 

### Integration test
The unit test is supposedto test all the aspects that we check with
Postman. We need to make sure that the API is working locally and
with a user

