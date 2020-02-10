package com.oracle.o2o.web.superadmin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/shopadmin")
public class ShopadminController {

	@RequestMapping(value="/shopoperation",method= RequestMethod.GET)
	public String getShopoperation() {
		return "shop/shopoperation";
	}
}