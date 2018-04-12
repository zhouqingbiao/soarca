package com.soarca.application.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soarca.application.domain.CaClfhtTpeZrhtqd;

public interface CaClfhtTpeZrhtqdRepository extends JpaRepository<CaClfhtTpeZrhtqd, Long> {
	List<CaClfhtTpeZrhtqd> findByFwzlLikeOrderByHtqdsjDesc(String fwzl);

	List<CaClfhtTpeZrhtqd> findByHtqdsjAfterOrderByHtqdsjDesc(Date htqdsj);
}
