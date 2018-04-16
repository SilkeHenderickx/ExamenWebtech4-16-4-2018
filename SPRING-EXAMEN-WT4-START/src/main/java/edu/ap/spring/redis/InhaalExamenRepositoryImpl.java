package edu.ap.spring.redis;

import com.javasampleapproach.redis.model.Customer;
import edu.ap.spring.model.InhaalExamen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Set;

@Repository
public class InhaalExamenRepositoryImpl implements InhaalExamenRepository {

	private static final String KEY = "Examen";
	private static final String BITKEY = "Examens";

	private RedisTemplate<String, Object> redisTemplate;
	private HashOperations<String, Long, InhaalExamen> hashOperations;

	@Autowired
	public InhaalExamenRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@PostConstruct
	private void init() {
		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void save(InhaalExamen customer){


		hashOperations.put(KEY, InhaalExamen.getStudent(), customer);
		redisTemplate.opsForValue().setBit(BITKEY, InhaalExamen.getStudent(), true);
	}

	@Override
	public InhaalExamen find(Long id) {
		return hashOperations.get(KEY, id);
	}

	@Override
	public Map<Long, InhaalExamen> findAll() {
		return hashOperations.entries(KEY);
	}

	@Override
	public void delete(Long id) {
		hashOperations.delete(KEY, id);
		redisTemplate.opsForValue().setBit(BITKEY, id, false);
	}

	@Override
	public Integer count(){
		Set<Long> keys = hashOperations.keys(KEY);

		Integer count = 0;

		for (Long key:keys) {
			if(redisTemplate.opsForValue().getBit(BITKEY,key)){
				count += 1;
			}
		}
		return count;
	}

}
