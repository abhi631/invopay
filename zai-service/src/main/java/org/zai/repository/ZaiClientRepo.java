package org.zai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zai.models.Client;
@Repository
public interface ZaiClientRepo extends JpaRepository<Client, Long> {


}
