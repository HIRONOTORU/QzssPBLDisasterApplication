package jp.ac.aiit.pbl.qzss.QzssPBLDisasterApplication.api;

import java.util.List;
import jp.ac.aiit.pbl.QZQSMDecoder;
import jp.ac.aiit.pbl.disaster.Disaster;
import jp.ac.aiit.pbl.disaster.prefix.Prefix;
import jp.ac.aiit.pbl.disaster.prefix.PrefixParser;
import jp.ac.aiit.pbl.qzss.QzssPBLDisasterApplication.api.prefix.PrefixEntity;
import jp.ac.aiit.pbl.qzss.QzssPBLDisasterApplication.api.prefix.PrefixRepository;
import jp.ac.aiit.pbl.qzss.QzssPBLDisasterApplication.api.prefix.PrefixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DisasterController {

    @Autowired
    PrefixService prefixService;

    @Autowired
    PrefixRepository prefixRepository;


    @GetMapping("/disaster")
    public Disaster decode(@RequestParam("qzqsmdata") String qzqsm){
        QZQSMDecoder qzqsmDecoder = new QZQSMDecoder();
        return qzqsmDecoder.decode(qzqsm);
    }

    @GetMapping("/prefixTop30")
    public List<PrefixEntity> PrefixTop30(){
        return prefixRepository.findTop30();
    }

    @GetMapping("/prefix")
    public void register(@RequestParam("qzqsmdata") String qzqsm){
        QZQSMDecoder qzqsmDecoder = new QZQSMDecoder();
        Disaster disaster = qzqsmDecoder.decode(qzqsm);
        System.out.println(disaster.getDisasterPrefix().toString());
        prefixRepository.create(new PrefixEntity(disaster.getDisasterPrefix()));
    }
}
