package groupe4.Projet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import groupe4.Projet.Model.User;
import groupe4.Projet.Model.Card;
import groupe4.Projet.Service.CardService;
import groupe4.Projet.Service.UserService;

@Controller
public class BaseController {
	@Autowired
	UserService userService;
	@Autowired
	CardService cardService;

	@RequestMapping(method = RequestMethod.GET, value = "/user/signup")
	public String signup(Model model, @RequestParam("login") String login, @RequestParam("passwd") String passwd) {
		Integer authenticateid = userService.signup(login, passwd);
		if (authenticateid != null) {
			return "redirect:/user/show/" + authenticateid;
		} else {
			model.addAttribute("nok", "unreconnized user");
			return "index2";
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/show/{authenticateid}")
	public String showUser(Model model, @PathVariable Integer authenticateid) {
		if (UserService.isAuthenticate(authenticateid)) {
			User user = userService.getUser(authenticateid);
			model.addAttribute("name", user.getName());
			model.addAttribute("balance", user.getAccountBalance());
			return "show";
		} else {
			model.addAttribute("nok", "unreconnized user");
			return "index2";
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/card/showall/{authenticateid}")
	public String showAllCards(Model model, @PathVariable Integer authenticateid) {
		if (UserService.isAuthenticate(authenticateid)) {
			model.addAttribute("authenticateid", authenticateid);
			User user = userService.getUser(authenticateid);
			model.addAttribute("name", user.getName());
			model.addAttribute("balance", user.getAccountBalance());
			return "cardlist";
		} else {
			model.addAttribute("nok", "unreconnized user");
			return "index2";
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/card/buy/{id}/{authenticateid}")
	public String buyCard(Model model, @PathVariable Integer id, @PathVariable Integer authenticateid) {
		if (UserService.isAuthenticate(authenticateid)) {
			model.addAttribute("authenticateid", authenticateid);
			Card card = cardService.getCard(id);
			userService.addCard(card, authenticateid);
			return "redirect:/user/show/" + authenticateid;
		} else {
			model.addAttribute("nok", "unreconnized user");
			return "index2";
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/card/sellshowall/{authenticateid}")
	public String sellshowAllCards(Model model, @PathVariable Integer authenticateid) {
		if (UserService.isAuthenticate(authenticateid)) {
			model.addAttribute("authenticateid", authenticateid);
			User user = userService.getUser(authenticateid);
			model.addAttribute("name", user.getName());
			model.addAttribute("balance", user.getAccountBalance());
			return "sellcardlist";
		} else {
			model.addAttribute("nok", "unreconnized user");
			return "index2";
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/card/sell/{id}/{authenticateid}")
	public String sellCard(Model model, @PathVariable Integer id, @PathVariable Integer authenticateid) {
		if (UserService.isAuthenticate(authenticateid)) {
			model.addAttribute("authenticateid", authenticateid);
			Card card = cardService.getCard(id);
			userService.removeCard(card, authenticateid);
			return "redirect:/user/show/" + authenticateid;
		} else {
			model.addAttribute("nok", "unreconnized user");
			return "index2";
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/card/play/{authenticateid}")
	public String listUserCards(Model model, @PathVariable Integer authenticateid) {
		if (UserService.isAuthenticate(authenticateid)) {
			model.addAttribute("authenticateid", authenticateid);
			User user = userService.getUser(authenticateid);
			model.addAttribute("name", user.getName());
			model.addAttribute("balance", user.getAccountBalance());

			return "playuser";
		} else {
			model.addAttribute("nok", "unreconnized user");
			return "index2";
		}
	}

}