package edu.ap.spring.redis;

import edu.ap.spring.model.InhaalExamen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

public interface InhaalExamenRepository {

    public interface CustomerRepository {

        void save(InhaalExamen customer);
        InhaalExamen find(Long id);
        Map<Long, InhaalExamen> findAll();
        void delete(Long id);
        Integer count();
    }

}
