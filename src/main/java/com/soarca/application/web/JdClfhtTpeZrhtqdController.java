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

import com.soarca.application.domain.JdClfhtTpeZrhtqd;
import com.soarca.application.service.JdClfhtTpeZrhtqdRepository;

@Controller
public class JdClfhtTpeZrhtqdController {

	@Autowired
	private JdClfhtTpeZrhtqdRepository jdClfhtTpeZrhtqdRepository;

	@GetMapping("/JdClfhtTpeZrhtqd")
	public String jdClfhtTpeZrhtqd(Model model, @ModelAttribute JdClfhtTpeZrhtqd jdClfhtTpeZrhtqd) {

		model.addAttribute("fwzl", jdClfhtTpeZrhtqd.getFwzl());

		List<JdClfhtTpeZrhtqd> listJdClfhtTpeZrhtqd = null;

		if (StringUtils.isEmpty(jdClfhtTpeZrhtqd.getFwzl())) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.MONTH, -1);

			listJdClfhtTpeZrhtqd = jdClfhtTpeZrhtqdRepository.findByHtqdsjAfterOrderByHtqdsjDesc(calendar.getTime());
		} else {
			listJdClfhtTpeZrhtqd = jdClfhtTpeZrhtqdRepository
					.findByFwzlLikeOrderByHtqdsjDesc("%" + jdClfhtTpeZrhtqd.getFwzl() + "%");
		}

		model.addAttribute("list", listJdClfhtTpeZrhtqd);

		return "JdClfhtTpeZrhtqd";
	}
}
