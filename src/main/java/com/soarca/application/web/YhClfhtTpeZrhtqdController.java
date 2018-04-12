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

import com.soarca.application.domain.YhClfhtTpeZrhtqd;
import com.soarca.application.service.YhClfhtTpeZrhtqdRepository;

@Controller
public class YhClfhtTpeZrhtqdController {

	@Autowired
	private YhClfhtTpeZrhtqdRepository yhClfhtTpeZrhtqdRepository;

	@GetMapping("/YhClfhtTpeZrhtqd")
	public String yhClfhtTpeZrhtqd(Model model, @ModelAttribute YhClfhtTpeZrhtqd yhClfhtTpeZrhtqd) {

		model.addAttribute("fwzl", yhClfhtTpeZrhtqd.getFwzl());

		List<YhClfhtTpeZrhtqd> listYhClfhtTpeZrhtqd = null;

		if (StringUtils.isEmpty(yhClfhtTpeZrhtqd.getFwzl())) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.MONTH, -1);

			listYhClfhtTpeZrhtqd = yhClfhtTpeZrhtqdRepository.findByHtqdsjAfterOrderByHtqdsjDesc(calendar.getTime());
		} else {
			listYhClfhtTpeZrhtqd = yhClfhtTpeZrhtqdRepository
					.findByFwzlLikeOrderByHtqdsjDesc("%" + yhClfhtTpeZrhtqd.getFwzl() + "%");
		}

		model.addAttribute("list", listYhClfhtTpeZrhtqd);

		return "YhClfhtTpeZrhtqd";
	}
}
