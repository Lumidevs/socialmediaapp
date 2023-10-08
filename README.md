# socialmediaapp
Used for managing user's social media account

pull olumide_dev branch and run locally.

The user creates an account using the payload
{
    "username": "test",
    "email": "test@email.com",
    "profilePicture": "pp1",
    "password":"test"
}
http://localhost:8080/api/users/create

after creating the account, the user can login using the payload 
{
    "username":"test",
    "password":"test"
}
http://localhost:8080/api/users/login


after login in,s ia Json web token is generated and added to the response header which can be used for subsequent calls into the servicee. The user can make a post
{
    "user":{
        "id": 5
    },
    "content": "Testing 2 the content for user with id 1"
}
http://localhost:8080/api/posts


other actions can be made on the user and posts as implemented in the code base
