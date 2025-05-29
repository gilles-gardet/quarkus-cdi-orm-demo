package com.ggardet

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class PersonRepository: PanacheRepository<PersonEntity> {

    fun findByFirstName(firstName: String): PersonEntity? {
        return find("firstName", firstName).firstResult()
    }
}
