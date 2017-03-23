http://docs.spring.io/spring-boot/docs/1.5.2.RELEASE/reference/htmlsingle/
http://docs.spring.io/spring-boot/docs/1.5.2.RELEASE/reference/html/common-application-properties.html
http://docs.jboss.org/hibernate/jpa/2.1/api/javax/persistence/

=================================================
1. Init project by Spring boot initialize plugin.
2. Add oracle jdbc dependency.
3. Add config properties. (application.properties)
4. Create profile configuration.

=================================================
Spring Data JPA Repository
http://docs.spring.io/spring-data/jpa/docs/1.5.2.RELEASE/reference/html/jpa.repositories.html

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

Get
http://localhost:8181/my-service/log/findLogByInterfaceLike?interface=13
http://localhost:8181/my-service/log/queryByInterfaceNameLike?interface=13
http://localhost:8181/my-service/log/nativeQueryByInterfaceNameLike?interface=13

=================================================
SPRING DATA REST
http://docs.spring.io/spring-data/rest/docs/2.6.1.RELEASE/reference/html/
Spring Data REST builds on top of Spring Data repositories
Expose repositories, jpa entity data via REST API

=================================================
Spring security - BASIC
2 content: Authentication + Authorization

1.
default get from properties file

2. override
@Configuration
@EnableWebSecurity -> do not load default from properties
@EnableGlobalMethodSecurity(prePostEnabled = true) -> enable @PreAuthorize
@PreAuthorize("hasRole('ROLE_ADMIN')") = @Secured("ROLE_ADMIN")

@PreAuthorize -> use in each request, each link, before create, update records in handler
=================================================
Validation (Constraints validation and event validation)

I. Constraint validations
1. Using JPA Constraints
2. Constraint validation -> @ControllerAdive, @ExceptionHandler, @ResponseStatus

=> finally,
1. Define custom handler for validation
2. Using JPA constraints or custom class to validate, logging, auditing and throw our custom handler for validation
3. Control our exceptions after catching and raise defined http code and message

