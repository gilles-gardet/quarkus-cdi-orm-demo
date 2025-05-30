package com.ggardet

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.time.LocalDate

@Entity
@Table(name = "person")
class PersonEntity {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(name = "first_name", nullable = false)
    var firstName: String? = null

    @Column(name = "last_name", nullable = false)
    var lastName: String? = null

    @Column(name = "birth_date")
    val birthDate: LocalDate? = null

    @Column(name = "email", unique = true, nullable = false)
    var email: String? = null

    @Column(name = "phone")
    val phone: String? = null

    @CreationTimestamp
    @Column(name = "created_at")
    val createdAt: Instant = Instant.now()

    @UpdateTimestamp
    @Column(name = "updated_at")
    val updatedAt: Instant = Instant.now()

    @JsonIgnore
    @OneToMany(mappedBy = "person", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.EAGER)
    val addresses: MutableList<AddressEntity> = mutableListOf()

    override fun toString(): String {
        return "Person(id=$id, firstName=$firstName, lastName=$lastName, birthDate=$birthDate, email=$email, phone=$phone, createdAt=$createdAt, updatedAt=$updatedAt, addresses=$addresses)"
    }
}
