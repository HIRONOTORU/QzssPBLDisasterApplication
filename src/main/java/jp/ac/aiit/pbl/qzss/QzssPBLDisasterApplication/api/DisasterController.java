package jp.ac.aiit.pbl.qzss.QzssPBLDisasterApplication.api;

import jp.ac.aiit.pbl.QZQSMDecoder;
import jp.ac.aiit.pbl.disaster.Disaster;
import jp.ac.aiit.pbl.disaster.prefix.Prefix;
import jp.ac.aiit.pbl.disaster.prefix.PrefixParser;
import jp.ac.aiit.pbl.qzss.QzssPBLDisasterApplication.api.prefix.PrefixEntity;
import jp.ac.aiit.pbl.qzss.QzssPBLDisasterApplication.api.prefix.PrefixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DisasterController {

    @Autowired
    PrefixService prefixService;


    @GetMapping("/disaster")
    public Disaster decode(@RequestParam("qzqsmdata") String qzqsm){
        QZQSMDecoder qzqsmDecoder = new QZQSMDecoder();
        return qzqsmDecoder.decode(qzqsm);
    }

    @GetMapping("/prefix")
    public void register(@RequestParam("qzqsmdata") String qzqsm){
        QZQSMDecoder qzqsmDecoder = new QZQSMDecoder();
        Disaster disaster = qzqsmDecoder.decode(qzqsm);
        PrefixService prefixService = new PrefixService();
        prefixService.create(new PrefixEntity(disaster.getDisasterPrefix()));
    }
}
