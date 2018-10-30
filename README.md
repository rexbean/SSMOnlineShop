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

| Name        | Type    | Not Null | Auto Increament| Default|
|-------------|---------|----------|----------------|--------|
|area_id      |int(2)   |  true    | true           |        |
|area_name    |char(200)|  true    | false          |        |
|priority     |int(2)   |  true    | false          | 0      |
|created_time |datatime |  false   | false          | NULL   |
|modified_time|datatime |  false   | false          | NULL   |

 - Primary Key : area_id
 - Unique: area_name
 - ENGINE = InnoDB AUTO_INCRAEMENT = 1 DEFAULT CHARSET = utf8;
 - \* ENGINE
   + InnoDB : In this engine, it will lock a row
   + MYISAM : In this engine, it will lock whole table, but has high read speed.
 - \* Why use datatime instead of timestamp?
   + Datatime has a wider range than the timestamp. 
   + Datatime can represent 1/1/1000 00:00:00 - 12/31/9999 23:59:59 
   + Timestamp can not represent the time before 1970 or after 2037
   + Timestamp will auto adapt to the time zone
- User Info
  - Twitter, Facebook Account
  - Local Account
- Top Goods
- Shop catagory
- Shop
- Goods
  - Detail images
- Goods catagory
