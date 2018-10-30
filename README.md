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
- Area
  - Id
  - Priority
  - Created Time
  - Modified Time
  - Name
- User Info
  - Twitter, Facebook Account
  - Local Account
- Top Goods
- Shop catagory
- Shop
- Goods
  - Detail images
- Goods catagory
