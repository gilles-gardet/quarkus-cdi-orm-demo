package com.ggardet

import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class PersonService(val personRepository: PersonRepository) {

    fun getPersonDetail(firstName: String) = personRepository.findByFirstName(firstName)
}
