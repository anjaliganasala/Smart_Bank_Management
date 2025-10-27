steps to create project : 
file -> new -> Maven Project -> next ->(org.apache.archetype.webapp) maven-archetype-webapp 1.5 -> guopid (package name) and artifacid ( project name) -> finish-> click Y.

right click on project -> buildpath -> config build path -> libraies  jre sys librrie to update 17 , then go to project facets add Dynamic web project to update 6.0 and java to 17, and go to Targeted Runtime select tomcat apply close these 3 . 


steps for pom.xml :
                  mysql-connector-J ( for database connectivity)
                  spring-context ( for manageing and accessing beans)
                  spring-mvc (for building web applications)
                  spring-orm (for integration b/n the spring and ORM frameworks like Hibernate and JPA to simplify db operations)
                  Hibernate-core (for handles object-relato=ional mapping(ORM) b/n java classes and db tables)
                  
