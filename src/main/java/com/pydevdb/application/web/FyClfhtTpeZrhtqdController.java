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

import com.pydevdb.application.domain.FyClfhtTpeZrhtqd;
import com.pydevdb.application.service.FyClfhtTpeZrhtqdRepository;

@Controller
public class FyClfhtTpeZrhtqdController {

	@Autowired
	private FyClfhtTpeZrhtqdRepository fyClfhtTpeZrhtqdRepository;

	@GetMapping("/FyClfhtTpeZrhtqd")
	public String fyClfhtTpeZrhtqd(Model model, @ModelAttribute FyClfhtTpeZrhtqd fyClfhtTpeZrhtqd) {

		model.addAttribute("fwzl", fyClfhtTpeZrhtqd.getFwzl());

		List<FyClfhtTpeZrhtqd> listFyClfhtTpeZrhtqd = null;

		if (StringUtils.isEmpty(fyClfhtTpeZrhtqd.getFwzl())) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.MONTH, -1);

			listFyClfhtTpeZrhtqd = fyClfhtTpeZrhtqdRepository.findByHtqdsjAfterOrderByHtqdsjDesc(calendar.getTime());
		} else {
			listFyClfhtTpeZrhtqd = fyClfhtTpeZrhtqdRepository
					.findByFwzlLikeOrderByHtqdsjDesc("%" + fyClfhtTpeZrhtqd.getFwzl() + "%");
		}

		model.addAttribute("list", listFyClfhtTpeZrhtqd);

		return "FyClfhtTpeZrhtqd";
	}
}
