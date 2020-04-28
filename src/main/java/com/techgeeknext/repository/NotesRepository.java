package com.techgeeknext.repository;

import com.techgeeknext.modal.Notes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NotesRepository extends CrudRepository<Notes, Long>{
}