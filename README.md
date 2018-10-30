# onlineShopSSM
A online shop website using SSM &amp; SpringBoot


## Configuartion
- New Project -> Maven -> Create from archetype -> maven-archetype-webapp -> Group Id, Artifical Id
- Config Tomcat:
  - Run -> Edit configuration -> new Tomcat Server -> local -> add build -> Name.war

## Design
### Module
#### Front End
- Show top goods list
- Show shop catagory list
- Show area info
- Show shop info
  - List
  - Search
  - Detail
- Show Goods info
  - List
  - Search
  - Detail
  
#### Vendor
- Maintain local account
- Maintain Twitter, Facebook Account
- Maintain shop Info
- Authentication
- Maintain shop catagory

#### Administrator
- Maintain top goods
- Maintain shop catagory
- Maintain area
- Authentication
- Shop management
- User management
### Entity
#### Area

| Name        | Type    | Not Null | Auto Increment| Default|
|-------------|---------|----------|----------------|--------|
|area_id      |int(2)   |  true    | true           |        |
|area_name    |char(200)|  true    | false          |        |
|priority     |int(2)   |  true    | false          | 0      |
|created_time |datatime |  false   | false          | NULL   |
|modified_time|datatime |  false   | false          | NULL   |

 - Primary Key : area_id
 - Unique: area_name
 - ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;
 * ENGINE
   + InnoDB : In this engine, it will lock a row
   + MYISAM : In this engine, it will lock whole table, but has high read speed.
 * Why use datatime instead of timestamp?
   + Datatime has a wider range than the timestamp. 
   + Datatime can represent 1/1/1000 00:00:00 - 12/31/9999 23:59:59 
   + Timestamp can not represent the time before 1970 or after 2037
   + Timestamp will auto adapt to the time zone
#### User Info

| Name        | Type        | Not Null | Auto Increment | Default|
|-------------|-------------|----------|----------------|--------|
|user_id      |int(2)       |  true    | true           |        |
|username     |varchar(32)  |  true    | false          |        |
|avatar       |varchar(1024)|  false   | false          |        |
|email        |varchar(1024)|  false   | false          |        |
|gender       |varchar(10)  |  false   | false          |        |
|status       |boolean      |  true    | false          | false  |
|user_type    |int(2)       |  true    | false          | 0      |
|created_time |datatime     |  false   | false          | NULL   |
|modified_time|datatime     |  false   | false          | NULL   |

- Primary Key : user_id
#### Wechat Account

|     Name        | Type         | Not Null | Auto Increment | Default|
|-----------------|--------------|----------|----------------|--------|
|wechat_account_id| int(10)      |  true    | true           |        |
|user_id          | int(10)      |  true    | false          |        |
|open_id          | varchar(1024)|  true    | false          |        |
|created_time     | datetime     |  false   | false          | NULL   |

  - Primary Key : wechat_account_id
  - Foregin Key : user_id => tb_user_info: user_id
  - Unique : open_id
#### Local Account

|     Name        | Type         | Not Null | Auto Increment | Default|
|-----------------|--------------|----------|----------------|--------|
|local_account_id | int(10)      |  true    | true           |        |
|user_id          | int(10)      |  true    | false          |        |
|username         | varchar(128) |  true    | fasle          |        |
|password         | varchar(128) |  true    | false          |        |
|created_time     | datetime     |  false   | false          | NULL   |
|modified_time    | datetime     |  false   | false          | NULL   |

  - Primary Key : local_account_id
  - Foregin Key : user_id => tb_user_info : user_id
  - Unique : username
  

#### Headline

|     Name        | Type         | Not Null | Auto Increment | Default|
|-----------------|--------------|----------|----------------|--------|
|id               | int(100)     |  true    | true           |        |
|name             | varchar(1000)|  true    | false          | NULL   |
|link             | varchar(2000)|  true    | fasle          |        |
|image            | varchar(2000)|  true    | false          |        |
|priority         | int(2)       |  false   | false          | NULL   |
|status           | boolean      |  true    | false          | false  |
|created_time     | datetime     |  false   | false          | NULL   |
|modified_time    | datetime     |  false   | false          | NULL   |

  - Primary Key: id
#### Shop Catagory

|     Name          | Type         | Not Null | Auto Increment | Default|
|-------------------|--------------|----------|----------------|--------|
|shop_catagory_id   | int(11)      |  true    | true           |        |
|shop_catagory_name | varchar(100) |  true    | false          | ''     |
|shop_catagory_desc | varchar(2000)|  false   | fasle          | ''     |
|shop_catagory_image| varchar(2000)|  false   | false          | NULL   |
|priority           | int(2)       |  false   | false          | 0      |
|created_time       | datetime     |  false   | false          | NULL   |
|modified_time      | datetime     |  false   | false          | NULL   |
|parent_id          | int(11)      |  false   | false          |        |

  - Primary Key : shop_catagory_id
  - Foregin Key : parent_id => tb_shop_catagory : shop_catagory_id
  

####  Shop

|     Name       | Type         | Not Null | Auto Increment | Default|
|----------------|--------------|----------|----------------|--------|
|shop_id         | int(10)      |  true    | true           |        |
|owner_id        | int(10)      |  true    | false          |        |
|area_id         | int(5)       |  false   | false          | NULL   |
|shop_catagory_id| int(11)      |  false   | false          | NULL   |
|shop_name       | varchar(256) |  true    | false          | ''     |
|shop_desc       | varchar(1024)|  false   | false          | NULL   |
|shop_addr       | varchar(200) |  false   | false          | NULL   |
|phone           | varchar(128) |  false   | false          | NULL   |
|shop_img        | varchar(2000)|  false   | false          | NULL   |
|priority        | int(2)       |  false   | false          | 0      |
|status          | int(2)       |  true    | false          | 0      |
|advice          | varchar(255) |  false   | false          | NULL   |
|created_time    | datetime     |  false   | false          | NULL   |
|modified_time   | datetime     |  false   | false          | NULL   |

  - Primary Key : shop_id
  - Foregin Key 
      - owner_id => tb_user_info : user_id
      - area_id => tb_area : area_id
      - shop_catagory_id => tb_shop_catagory : shop_catagory_id
  

- Goods
  - Detail images
- Goods catagory
