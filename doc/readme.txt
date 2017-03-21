http://docs.spring.io/spring-boot/docs/1.5.2.RELEASE/reference/htmlsingle/
http://docs.spring.io/spring-boot/docs/1.5.2.RELEASE/reference/html/common-application-properties.html
http://docs.jboss.org/hibernate/jpa/2.1/api/javax/persistence/

=================================================
1. Init project by Spring boot initialize plugin.
2. Add oracle jdbc dependency.
3. Add config properties. (application.properties)
4. Create profile configuration.

=================================================
Spring Data JPA

Get log, logdetail
http://localhost:8181/my-service/log-detail/3425
http://localhost:8181/my-service/log/24484

insert log
{
  "interfaceName": "interface name 5"
}

{
  "interfaceName": "interface name 6",
  "logDetails": [
    {
      "erreur": "error message 2"
    }
  ]
}

insert logdetail
{
  "erreur": "error message 3"
}

update log
{
  "id": 24484,
  "interfaceName": "interface name 6",
  "datetrait": 1490089853676,
  "logDetails": [
    {
      "id": 3420,
      "erreur": "error message 2"
    }
  ]
}


=================================================
Spring DATA REST
Create log
Create log detail
Update log
Update log detail
