use('admin');
db.createUser(
  {
    user: "funuser",
    pwd: "funpassword",
    roles:[
      {
        role:"userAdminAnyDatabase",
        db:"admin"
    }
    ]
    }
  )