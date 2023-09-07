package com.example.springex.service;

import com.example.springex.exceptions.KeyCacheException;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class KeyCacheService {

    private CacheManager cacheManager;
    /*
    user -> login -> key döncek
		key cache kaydettik, date ile

     user key ile istek attı,
	key ->cache service bakılacak
		-> varmı??
		-> date bak, expire olmuş mu

		-> ok. geçmezse exception fırlatcaz.
		-> expire olmussa, exception fırlatmadan önce cache'den o keyi silcez.

		belli aralıklarla kron job
     */

    public void putKey(String tmpKey) {
        Cache cache = cacheManager.getCache("keyCache");
        if (cache != null) {
            cache.put(tmpKey, new Date());
        }
    }


    public boolean checkKey(String tmpKey) throws KeyCacheException {
        Cache cache = cacheManager.getCache("keyCache");
        if (cache != null) {
            Date cacheDate = cache.get(tmpKey, Date.class);
            if (cacheDate == null) {
                throw new KeyCacheException(new Exception("Key is invalid"));
            }
            Date now = new Date();
            long diffInMillies = Math.abs(now.getTime() - cacheDate.getTime());
            long diff = TimeUnit.SECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            if (diff>600){
                cache.evict(tmpKey);
                throw new KeyCacheException(new Exception("Key is expired"));
            }
            return true;
        } else {
            throw new KeyCacheException(new Exception("Cache is null"));
        }
    }

//    @Scheduled(cron = "0 */1 * * * *")
//    @PostConstruct
//    private void clearExpiredKeys() {
//        System.out.println("Sql Refresh Cache is triggered.");
//        Cache cache = cacheManager.getCache("keyCache");
//
//        if (cache != null) {
//            cache.getName();
//            cache.
//        }
//    }

}
