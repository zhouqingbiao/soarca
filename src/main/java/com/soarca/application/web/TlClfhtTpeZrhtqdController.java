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

import com.soarca.application.domain.TlClfhtTpeZrhtqd;
import com.soarca.application.service.TlClfhtTpeZrhtqdRepository;

@Controller
public class TlClfhtTpeZrhtqdController {

	@Autowired
	private TlClfhtTpeZrhtqdRepository tlClfhtTpeZrhtqdRepository;

	@GetMapping("/TlClfhtTpeZrhtqd")
	public String tlClfhtTpeZrhtqd(Model model, @ModelAttribute TlClfhtTpeZrhtqd tlClfhtTpeZrhtqd) {

		model.addAttribute("fwzl", tlClfhtTpeZrhtqd.getFwzl());

		List<TlClfhtTpeZrhtqd> listTlClfhtTpeZrhtqd = null;

		if (StringUtils.isEmpty(tlClfhtTpeZrhtqd.getFwzl())) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.MONTH, -1);

			listTlClfhtTpeZrhtqd = tlClfhtTpeZrhtqdRepository.findByHtqdsjAfterOrderByHtqdsjDesc(calendar.getTime());
		} else {
			listTlClfhtTpeZrhtqd = tlClfhtTpeZrhtqdRepository
					.findByFwzlLikeOrderByHtqdsjDesc("%" + tlClfhtTpeZrhtqd.getFwzl() + "%");
		}

		model.addAttribute("list", listTlClfhtTpeZrhtqd);

		return "TlClfhtTpeZrhtqd";
	}
}
