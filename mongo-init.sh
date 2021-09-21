mongosh ./tmp/create-mongo-user.js
mongoimport --jsonArray --db restaurantdb --collection restaurant --file ./tmp/sampledata-restaurant.json