package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
    private static final Map<Long,Item> store = new HashMap<>();//static Map의 key값은 ID자료형과 맞춤
    //멀티쓰레드환경에서는 HashMap사용하면 안됨, 사용하고싶다면 ConcurrentHashMap사용해야함
    private static long sequence =0l;//static,얘도 동시접근하면 꼬일 수 있어서

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(),item);
        return item;
    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam){
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore(){
        store.clear(); //hashmap 데이터가 다 날라감
    }


}
