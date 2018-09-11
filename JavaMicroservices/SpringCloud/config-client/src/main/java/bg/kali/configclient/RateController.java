package bg.kali.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RateController {
	
	@Value("${rate}")
	private String rate;
	
	@Value("${lanecount}")
	private String laneCount;
	
	@Value("${tollstart}")
	private String tollStart;
	
	@GetMapping("/rate")
	public String getRate(Model model) {
		model.addAttribute("rateamount", rate);
		model.addAttribute("lanes", laneCount);
		model.addAttribute("tollstart", tollStart);
		
		return "rateview";
	}
}
