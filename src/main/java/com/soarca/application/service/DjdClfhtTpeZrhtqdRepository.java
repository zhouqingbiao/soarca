package com.soarca.application.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soarca.application.domain.DjdClfhtTpeZrhtqd;

public interface DjdClfhtTpeZrhtqdRepository extends JpaRepository<DjdClfhtTpeZrhtqd, Long> {
	List<DjdClfhtTpeZrhtqd> findByFwzlLikeOrderByHtqdsjDesc(String fwzl);

	List<DjdClfhtTpeZrhtqd> findByHtqdsjAfterOrderByHtqdsjDesc(Date htqdsj);
}
