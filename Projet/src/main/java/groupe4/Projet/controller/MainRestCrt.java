package groupe4.Projet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import groupe4.Projet.Model.Card;
import groupe4.Projet.Model.User;
import groupe4.Projet.Service.CardService;
import groupe4.Projet.Service.UserService;

@RestController
public class MainRestCrt {
	@Autowired
	UserService userService;
	@Autowired
	CardService cardService;

	@RequestMapping(method = RequestMethod.POST, value = "/user/add/{authenticateid}")
	public void addUser(@RequestBody User user, Integer authenticateid) {
		if (UserService.isAuthenticate(authenticateid)) {
			userService.saveUser(user);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}/{authenticateid}")
	public User getUser(@PathVariable Integer id, @PathVariable Integer authenticateid) {
		if (UserService.isAuthenticate(authenticateid)) {
			User h = userService.getUser(id);
			return h;
		}
		return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/card/{id}/{authenticateid}")
	public Card getCard(@PathVariable Integer id, @PathVariable Integer authenticateid) {
		if (UserService.isAuthenticate(authenticateid)) {
			Card c = cardService.getCard(id);
			return c;
		}
		return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/card/list/{authenticateid}")
	public List<Card> listCard(@PathVariable Integer authenticateid) {
		if (UserService.isAuthenticate(authenticateid)) {
			return cardService.getAllCards();
		}
		return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/card/list/{authenticateid}")
	public List<Card> listUserCard(@PathVariable Integer authenticateid) {
		if (UserService.isAuthenticate(authenticateid)) {
			User user = userService.getUser(authenticateid);
			List<Integer> idList = user.getUserCardList();
			List<Card> cardList = new ArrayList<Card>();
			for (Integer id : idList) {
				Card card = cardService.getCard(id);
				if (card != null) {
					cardList.add(card);
				}
			}

			return cardList;
		}
		return null;
	}

	/*
	 * buy(card_id, auth_id) sell(card_id, auth_id)
	 * 
	 * listCard(auth_id)
	 * 
	 * listUserCard(auth_id)
	 */

}
