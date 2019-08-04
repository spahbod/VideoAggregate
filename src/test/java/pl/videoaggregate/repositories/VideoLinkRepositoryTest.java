package pl.videoaggregate.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.videoaggregate.configuration.VideoLinkConfiguration;
import pl.videoaggregate.domain.VideoLink;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {VideoLinkConfiguration.class})
public class VideoLinkRepositoryTest {

    @Autowired
    private VideoLinkRepository videoLinkRepository;

    @Test
    public void testSaveProduct() {
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
        List<VideoLink> products = videoLinkRepository.findAll();

        assertEquals(products.size(), 1);
    }

    @Test
    public void testFindByPrice(){

        BigDecimal price = new BigDecimal("19.00");
        //setup product
        VideoLink product = new VideoLink();
        product.setDescription("Spring Framework Guru Shirt");
        product.setPrice(price);
        product.setProductId("1234");

        //save product, verify has ID value after save
        assertNull(product.getId()); //null before save
        videoLinkRepository.save(product);
        assertNotNull(product.getId()); //not null after save

        List<VideoLink> products = videoLinkRepository.findByPrice(price);

        assertEquals(products.size(), 1);
    }


    @Test
    public void testFindByPriceEmpty(){
        BigDecimal price = new BigDecimal("199.00");
        List<VideoLink> products = videoLinkRepository.findByPrice(price);

        assertEquals(products.size(), 0);
    }

    @Test
    public void testFindByDescription(){

        String description = "TEST";
        //setup product
        VideoLink product = new VideoLink();
        product.setDescription(description);
        product.setPrice(new BigDecimal("18.95"));
        product.setProductId("1234");

        //save product, verify has ID value after save
        assertNull(product.getId()); //null before save
        videoLinkRepository.save(product);
        assertNotNull(product.getId()); //not null after save

        List<VideoLink> products = videoLinkRepository.findByDescription(description);

        assertEquals(products.size(), 1);
    }

    @Test
    public void testFindByDescriptionEmpty(){
        String description = "EMPTY";
        List<VideoLink> products = videoLinkRepository.findByDescription(description);

        assertEquals(products.size(), 0);
    }
}

