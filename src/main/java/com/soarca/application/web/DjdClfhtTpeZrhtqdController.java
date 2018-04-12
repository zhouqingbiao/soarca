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

import com.soarca.application.domain.DjdClfhtTpeZrhtqd;
import com.soarca.application.service.DjdClfhtTpeZrhtqdRepository;

@Controller
public class DjdClfhtTpeZrhtqdController {

	@Autowired
	private DjdClfhtTpeZrhtqdRepository djdClfhtTpeZrhtqdRepository;

	@GetMapping("/DjdClfhtTpeZrhtqd")
	public String djdClfhtTpeZrhtqd(Model model, @ModelAttribute DjdClfhtTpeZrhtqd djdClfhtTpeZrhtqd) {

		model.addAttribute("fwzl", djdClfhtTpeZrhtqd.getFwzl());

		List<DjdClfhtTpeZrhtqd> listDjdClfhtTpeZrhtqd = null;

		if (StringUtils.isEmpty(djdClfhtTpeZrhtqd.getFwzl())) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.MONTH, -1);

			listDjdClfhtTpeZrhtqd = djdClfhtTpeZrhtqdRepository.findByHtqdsjAfterOrderByHtqdsjDesc(calendar.getTime());
		} else {
			listDjdClfhtTpeZrhtqd = djdClfhtTpeZrhtqdRepository
					.findByFwzlLikeOrderByHtqdsjDesc("%" + djdClfhtTpeZrhtqd.getFwzl() + "%");
		}

		model.addAttribute("list", listDjdClfhtTpeZrhtqd);

		return "DjdClfhtTpeZrhtqd";
	}
}
