package com.ggardet

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class PersonRepository : PanacheRepository<PersonEntity> {

    fun findByFirstName(firstName: String) = find("firstName", firstName).firstResult()
}
