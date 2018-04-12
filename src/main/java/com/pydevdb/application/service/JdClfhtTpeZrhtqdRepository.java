package com.pydevdb.application.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pydevdb.application.domain.JdClfhtTpeZrhtqd;

public interface JdClfhtTpeZrhtqdRepository extends JpaRepository<JdClfhtTpeZrhtqd, Long> {
	List<JdClfhtTpeZrhtqd> findByFwzlLikeOrderByHtqdsjDesc(String fwzl);

	List<JdClfhtTpeZrhtqd> findByHtqdsjAfterOrderByHtqdsjDesc(Date htqdsj);
}
