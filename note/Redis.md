# Redis
## Definition
- Redis is a distributed memory cache server and use it to do the search operations decrease the time of using database.
- It is a key-value storage system, 
- Types: String, List, Set, Sorted Set... 
- Operations: Push, Pop, Add, Remove, Union, Intersect  <= Atomic : can be Multithread in parallel
- Sort
- Persistency
  - RDB: easy to lost
  - AOF:
  
## Configuration
- Add dependency in maven of [jedis](https://mvnrepository.com/artifact/redis.clients/jedis)
- Config the [spring-dao.xml](../src/main/resources/spring/spring-dao.xml)
- Write classes  
- Change code:
```java
  @AutoWired
  private JdeisUti.Keys jedisKeys;
  @AutoWired
  private JedisUtil.Strings jedisStrings;
  
  private static String AREALISTKEY = "areaList"
  
  public List<Area> getAreaList(){
      String key = AREALISTKEY;
      List<Area> arealist = null;
      ObjectMapper mapper = new ObjectMapper();
      if(!jedisKeys.exists(key)){
         areaList = areaDao.queryArea();
         String jsonString;
         try{
            jsonString = mapper.writeValueAsString(areaList);
         } catch(Exception e){
              e.printStackTrace();
              logger.error(e.getMessage());
              throw new AreaOperationException(e.getMessage();
         }
         jedisStrings.set(key, jsonString);
      } else {
          String jsonString = jedisStrings.get(key);
          JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, Area.class);
          try{
              areaList = mapper.readValue(jsonString, javaType);
          }catch(Excpetion e){
              e.printStackTrace();
              logger.error(e.getMessage());
              throw new AreaOperationException(e.getMessage();
          }
      }
      return areaList;
  }
```
