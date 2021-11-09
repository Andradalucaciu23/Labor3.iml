package com.uni.repository;

import com.uni.model.Person;

public class PersonRepository extends InMemoryRepository<Person> {

    public PersonRepository(){
        super();
    }

    /**
     * returneaza persoana editata
     * @param entity
     * @return personUpdate
     */

    @Override
    public Person update(Person entity) {
        Person personUpdate = this.repoList.stream().filter(person -> person.getVorname() == entity.getVorname()).findFirst().orElseThrow();
        personUpdate.setNachname(entity.getNachname());

        return personUpdate;
    }

    /**
     * @param entity
     * @return super.save(entity)
     */

    @Override
    public Person save(Person entity) {
        return super.save(entity);
    }
}
