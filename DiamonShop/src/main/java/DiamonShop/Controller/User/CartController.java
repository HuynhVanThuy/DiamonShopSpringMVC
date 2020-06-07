package DiamonShop.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.CartDto;
import DiamonShop.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController{
	
	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();
	
	@RequestMapping(value = "gio-hang")
	public ModelAndView Index() {
		_mvShare.addObject("slides", _homeService.GetDataSlide());
		_mvShare.addObject("categorys", _homeService.GetDataCategorys());
		_mvShare.addObject("products", _homeService.GetDataProducts());
		_mvShare.setViewName("user/cart/list_cart");
		return _mvShare;
	}
	
	@RequestMapping(value = "AddCart/{id}")
	public String AddCart(HttpServletRequest request ,HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value = "EditCart/{id}")
	public String EditCart(HttpServletRequest request ,HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
//		cart = cartService.EditCart(id, quanty, cart);
//		session.setAttribute("Cart", cart);
//		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
//		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	
	@RequestMapping(value = "DeleteCart/{id}")
	public String DeleteCart(HttpServletRequest request ,HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.DeleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
}
