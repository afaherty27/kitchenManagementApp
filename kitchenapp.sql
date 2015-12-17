#Create User role sample table
CREATE TABLE kitchenapp.user_role
(
  user_role_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
 # user_name VARCHAR(15) NOT NULL,
  user_role VARCHAR(15) NOT NULL
);

#create user sample table
CREATE TABLE users
(
  user_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(15) NOT NULL,
  user_pass VARCHAR(15) NOT NULL,
  address VARCHAR(25) NOT NULL,
  phone VARCHAR(25) NOT NULL,
  email VARCHAR(36) NOT NULL,
  role INT NOT NULL/*,
  KEY fk_user_role_id (role_id),
  CONSTRAINT fk_user_role_id FOREIGN KEY (role_id) REFERENCES user_role (user_role_id)*/
);

#creates recipe table
CREATE TABLE recipe
(
  recipe_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  file_path VARCHAR(100) NOT NULL,
  category VARCHAR(15) NOT NULL,
  recipe_name VARCHAR(25) NOT NULL
);

