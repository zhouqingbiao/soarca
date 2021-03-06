package com.soarca.application.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soarca.application.domain.XsClfhtTpeZrhtqd;

public interface XsClfhtTpeZrhtqdRepository extends JpaRepository<XsClfhtTpeZrhtqd, Long> {
	List<XsClfhtTpeZrhtqd> findByFwzlLikeOrderByHtqdsjDesc(String fwzl);

	List<XsClfhtTpeZrhtqd> findByHtqdsjAfterOrderByHtqdsjDesc(Date htqdsj);
}
