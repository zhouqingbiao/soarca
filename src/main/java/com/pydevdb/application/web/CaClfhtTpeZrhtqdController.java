package com.pydevdb.application.web;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.pydevdb.application.domain.CaClfhtTpeZrhtqd;
import com.pydevdb.application.service.CaClfhtTpeZrhtqdRepository;

@Controller
public class CaClfhtTpeZrhtqdController {

	@Autowired
	private CaClfhtTpeZrhtqdRepository caClfhtTpeZrhtqdRepository;

	@GetMapping("/CaClfhtTpeZrhtqd")
	public String caClfhtTpeZrhtqd(Model model, @ModelAttribute CaClfhtTpeZrhtqd caClfhtTpeZrhtqd) {

		model.addAttribute("fwzl", caClfhtTpeZrhtqd.getFwzl());

		List<CaClfhtTpeZrhtqd> listCaClfhtTpeZrhtqd = null;

		if (StringUtils.isEmpty(caClfhtTpeZrhtqd.getFwzl())) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.MONTH, -1);

			listCaClfhtTpeZrhtqd = caClfhtTpeZrhtqdRepository.findByHtqdsjAfterOrderByHtqdsjDesc(calendar.getTime());
		} else {
			listCaClfhtTpeZrhtqd = caClfhtTpeZrhtqdRepository
					.findByFwzlLikeOrderByHtqdsjDesc("%" + caClfhtTpeZrhtqd.getFwzl() + "%");
		}

		model.addAttribute("list", listCaClfhtTpeZrhtqd);

		return "CaClfhtTpeZrhtqd";
	}
}
