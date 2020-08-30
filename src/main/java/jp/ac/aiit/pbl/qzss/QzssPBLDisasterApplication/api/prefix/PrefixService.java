package jp.ac.aiit.pbl.qzss.QzssPBLDisasterApplication.api.prefix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrefixService {

    @Autowired
    PrefixRepository prefixRepository;


    public List<PrefixEntity> findAll(){
        return prefixRepository.findAll();
    }

    public void create(PrefixEntity prefixEntity){
        prefixRepository.create(prefixEntity);
    }
}
