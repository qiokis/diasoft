package ru.qioki.diasoft.repository;

import org.springframework.data.repository.CrudRepository;
import ru.qioki.diasoft.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
