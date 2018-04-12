package com.pydevdb.application.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pydevdb.application.domain.LaClfhtTpeZrhtqd;

public interface LaClfhtTpeZrhtqdRepository extends JpaRepository<LaClfhtTpeZrhtqd, Long> {
	List<LaClfhtTpeZrhtqd> findByFwzlLikeOrderByHtqdsjDesc(String fwzl);

	List<LaClfhtTpeZrhtqd> findByHtqdsjAfterOrderByHtqdsjDesc(Date htqdsj);
}
