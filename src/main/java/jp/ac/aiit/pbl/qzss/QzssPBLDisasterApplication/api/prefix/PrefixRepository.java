package jp.ac.aiit.pbl.qzss.QzssPBLDisasterApplication.api.prefix;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface PrefixRepository {

    @Select
    public PrefixEntity findById(Long prefixId);

    @Select
    public List<PrefixEntity> findAll();

    @Insert
    public int create(PrefixEntity entity);

}
