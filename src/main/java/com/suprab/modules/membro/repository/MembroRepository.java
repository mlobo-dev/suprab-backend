package com.suprab.modules.membro.repository;

import com.suprab.modules.membro.entity.Membro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {

}
