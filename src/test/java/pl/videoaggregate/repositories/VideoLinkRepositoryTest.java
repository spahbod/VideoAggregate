package pl.videoaggregate.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.videoaggregate.configuration.VideoLinkConfiguration;
import pl.videoaggregate.domain.VideoLink;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {VideoLinkConfiguration.class})
public class VideoLinkRepositoryTest {

    @Autowired
    private VideoLinkRepository videoLinkRepository;

    @Test
    public void testSaveProduct(){
        //setup product
        VideoLink product = new VideoLink();
        product.setDescription("Spring Framework Guru Shirt");
        product.setPrice(new BigDecimal("18.95"));
        product.setProductId("1234");

        //save product, verify has ID value after save
        assertNull(product.getId()); //null before save
        videoLinkRepository.save(product);
        assertNotNull(product.getId()); //not null after save
        //fetch from DB
        VideoLink fetchedProduct = videoLinkRepository.findById(product.getId()).orElse(null);

        //should not be null
        assertNotNull(fetchedProduct);

        //should equal
        assertEquals(product.getId(), fetchedProduct.getId());
        assertEquals(product.getDescription(), fetchedProduct.getDescription());

        //update description and save
        fetchedProduct.setDescription("New Description");
        videoLinkRepository.save(fetchedProduct);

        //get from DB, should be updated
        VideoLink fetchedUpdatedProduct = videoLinkRepository.findById(fetchedProduct.getId()).orElse(null);
        assertEquals(fetchedProduct.getDescription(), fetchedUpdatedProduct.getDescription());

        //verify count of products in DB
        long productCount = videoLinkRepository.count();
        assertEquals(productCount, 1);

        //get all products, list should only have one
        Iterable<VideoLink> products = videoLinkRepository.findAll();

        int count = 0;

        for(VideoLink p : products){
            count++;
        }

        assertEquals(count, 1);
    }
}
