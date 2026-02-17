package om.mashibing.springboot02.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * translatedText  http://translatedText：translatedText/context-path/ControllertranslatedTextURI/translatedTextURI
 * http://localhost:80/boot/user/list
 * @author Administrator
 * @Controller translatedTextSpringtranslatedText,translatedText
 */
@Controller
public class MainController {

	
	/**
	 * String translatedText，translatedText
	 * 
	 *   context/ + /user +  /list 
	 *   context/ + list
	 * @return
	 */
	@RequestMapping("/list")
	public String list(ModelMap map) {
		
		return "list";
	}
}
