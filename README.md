# socialmediaapp
Used for managing user's social media account

pull olumide_dev branch and run locally on intelliJ.

the database used in mySQL


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


after login in, a Json web token is generated and added to the response header which can be used for subsequent calls into the servicee. The user can make a post(A POST request)
{
    "user":{
        "id": 5
    },
    "content": "Testing 2 the content for user with id 1"
}
http://localhost:8080/api/posts

to get all posts, using a get request http://localhost:8080/api/posts


to comment on a post(A POST request)
http://localhost:8080/api/comments
{
    "user": {
        "id": 1
    },
    "post": {
        "id": 1
    },
    "comment": "testing comment 2"
}


to like a post(A POST request)
http://localhost:8080/api/likes
{
    "user": {
        "id": 1
    },
    "post": {
        "id": 1
    }
}


to get posts for user
http://localhost:8080/api/posts/user/{{userId}}


to get all comments on a post
http://localhost:8080/api/comments/post/{{postId}}

to get all likes on a post
http://localhost:8080/api/likes/post/{{postId}}






other actions can be made on the user and posts as implemented in the code base
