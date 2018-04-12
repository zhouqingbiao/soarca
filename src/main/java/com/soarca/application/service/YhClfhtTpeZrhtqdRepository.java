package com.soarca.application.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soarca.application.domain.YhClfhtTpeZrhtqd;

public interface YhClfhtTpeZrhtqdRepository extends JpaRepository<YhClfhtTpeZrhtqd, Long> {
	List<YhClfhtTpeZrhtqd> findByFwzlLikeOrderByHtqdsjDesc(String fwzl);

	List<YhClfhtTpeZrhtqd> findByHtqdsjAfterOrderByHtqdsjDesc(Date htqdsj);
}
