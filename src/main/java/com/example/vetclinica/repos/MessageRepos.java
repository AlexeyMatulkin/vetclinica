package com.example.vetclinica.repos;

import com.example.vetclinica.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepos extends CrudRepository<Message, Long> {

    List<Message> findByTag(String tag);

}
