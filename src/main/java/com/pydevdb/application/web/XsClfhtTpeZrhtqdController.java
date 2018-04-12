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

import com.pydevdb.application.domain.XsClfhtTpeZrhtqd;
import com.pydevdb.application.service.XsClfhtTpeZrhtqdRepository;

@Controller
public class XsClfhtTpeZrhtqdController {

	@Autowired
	private XsClfhtTpeZrhtqdRepository xsClfhtTpeZrhtqdRepository;

	@GetMapping("/XsClfhtTpeZrhtqd")
	public String xsClfhtTpeZrhtqd(Model model, @ModelAttribute XsClfhtTpeZrhtqd xsClfhtTpeZrhtqd) {

		model.addAttribute("fwzl", xsClfhtTpeZrhtqd.getFwzl());

		List<XsClfhtTpeZrhtqd> listXsClfhtTpeZrhtqd = null;

		if (StringUtils.isEmpty(xsClfhtTpeZrhtqd.getFwzl())) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.MONTH, -1);

			listXsClfhtTpeZrhtqd = xsClfhtTpeZrhtqdRepository.findByHtqdsjAfterOrderByHtqdsjDesc(calendar.getTime());
		} else {
			listXsClfhtTpeZrhtqd = xsClfhtTpeZrhtqdRepository
					.findByFwzlLikeOrderByHtqdsjDesc("%" + xsClfhtTpeZrhtqd.getFwzl() + "%");
		}

		model.addAttribute("list", listXsClfhtTpeZrhtqd);

		return "XsClfhtTpeZrhtqd";
	}
}
