package com.soarca.application.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soarca.application.domain.TlClfhtTpeZrhtqd;

public interface TlClfhtTpeZrhtqdRepository extends JpaRepository<TlClfhtTpeZrhtqd, Long> {
	List<TlClfhtTpeZrhtqd> findByFwzlLikeOrderByHtqdsjDesc(String fwzl);

	List<TlClfhtTpeZrhtqd> findByHtqdsjAfterOrderByHtqdsjDesc(Date htqdsj);
}
