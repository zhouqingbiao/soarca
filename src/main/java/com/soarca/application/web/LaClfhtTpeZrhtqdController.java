package com.soarca.application.web;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.soarca.application.domain.LaClfhtTpeZrhtqd;
import com.soarca.application.service.LaClfhtTpeZrhtqdRepository;

@Controller
public class LaClfhtTpeZrhtqdController {

	@Autowired
	private LaClfhtTpeZrhtqdRepository laClfhtTpeZrhtqdRepository;

	@GetMapping("/LaClfhtTpeZrhtqd")
	public String laClfhtTpeZrhtqd(Model model, @ModelAttribute LaClfhtTpeZrhtqd laClfhtTpeZrhtqd) {

		model.addAttribute("fwzl", laClfhtTpeZrhtqd.getFwzl());

		List<LaClfhtTpeZrhtqd> listLaClfhtTpeZrhtqd = null;

		if (StringUtils.isEmpty(laClfhtTpeZrhtqd.getFwzl())) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.MONTH, -1);

			listLaClfhtTpeZrhtqd = laClfhtTpeZrhtqdRepository.findByHtqdsjAfterOrderByHtqdsjDesc(calendar.getTime());
		} else {
			listLaClfhtTpeZrhtqd = laClfhtTpeZrhtqdRepository
					.findByFwzlLikeOrderByHtqdsjDesc("%" + laClfhtTpeZrhtqd.getFwzl() + "%");
		}

		model.addAttribute("list", listLaClfhtTpeZrhtqd);

		return "LaClfhtTpeZrhtqd";
	}
}
