package tn.enicarthage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enicarthage.Model.User;

public interface UserRepository extends JpaRepository<User,String> {

}
