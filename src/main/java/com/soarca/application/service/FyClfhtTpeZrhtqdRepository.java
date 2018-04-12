package com.soarca.application.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soarca.application.domain.FyClfhtTpeZrhtqd;

public interface FyClfhtTpeZrhtqdRepository extends JpaRepository<FyClfhtTpeZrhtqd, Long> {
	List<FyClfhtTpeZrhtqd> findByFwzlLikeOrderByHtqdsjDesc(String fwzl);

	List<FyClfhtTpeZrhtqd> findByHtqdsjAfterOrderByHtqdsjDesc(Date htqdsj);
}
