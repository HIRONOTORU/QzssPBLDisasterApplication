package jp.ac.aiit.pbl.qzss.QzssPBLDisasterApplication.api;

import jp.ac.aiit.pbl.qzss.QzssPBLDisasterApplication.api.prefix.PrefixEntity;
import jp.ac.aiit.pbl.qzss.QzssPBLDisasterApplication.api.prefix.PrefixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("list")
public class ListController {
    @Autowired
    PrefixRepository prefixRepository;

    // @RequestMapping(name="/list", method = RequestMethod.GET)
    @RequestMapping(method = RequestMethod.GET)
    String listDisasters(Model model) {
        List<PrefixEntity> prefixes = prefixRepository.findTop30();
        model.addAttribute("prefixes", prefixes);
        return "list";
    }
}
