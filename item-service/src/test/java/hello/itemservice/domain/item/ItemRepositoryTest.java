package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemRepositoryTest {
    ItemRepository itemRepository = new ItemRepository();//아이템 리포지토리를 사용하기 위해 생성해준다.

    @AfterEach//테스트가 끝날때마다
    void afterEach(){
        itemRepository.clearStore(); //클리어해준다
    }

    @Test
    void save(){
        //given
        Item item = new Item("itemA",10000,10);//아이템생성
        //when
        Item savedItem = itemRepository.save(item);//그 아이템 저장해준다
        //then
        Item findItem = itemRepository.findById(item.getId());//저장한 아이템의 id값을 통해 찾은 값을 findItem에 저장한다

        assertThat(findItem).isEqualTo(savedItem);//findItem 과 savedItem이 일치하면 통과,저장이 잘되었다는 뜻.

    }
    @Test
    void findAll(){
        //given
        Item item1 = new Item("itemA",10000,10);
        Item item2 = new Item("itemB",20000,20);
        itemRepository.save(item1);
        itemRepository.save(item2);
        //when
        List<Item> result= itemRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(item1,item2);

    }
    @Test
    void updateItem(){
        //given
        Item item1 = new Item("itemA",10000,10);
        Item savedItem = itemRepository.save(item1);
        Long itemId = savedItem.getId();
        //when
        Item updatedItem = new Item("item2",20000,20);
        itemRepository.update(itemId,updatedItem);
        //then
        Item findItem = itemRepository.findById(itemId);

        assertThat(findItem.getItemName()).isEqualTo(updatedItem.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updatedItem.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(updatedItem.getQuantity());
    }
}
