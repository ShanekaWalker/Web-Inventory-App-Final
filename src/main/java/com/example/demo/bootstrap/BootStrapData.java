package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
       this.inhousePartRepository=inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        if (inhousePartRepository.count()==0){
            InhousePart decks = new InhousePart();
            decks.setName("Decks");
            decks.setPrice(67.99);
            decks.setInv(10);
            decks.setMinInv(0);
            decks.setMaxInv(100);
            decks.setId(1);
            inhousePartRepository.save(decks);

            InhousePart trucks = new InhousePart();
            trucks.setName("Trucks");
            trucks.setPrice(75.99);
            trucks.setInv(10);
            trucks.setMinInv(0);
            trucks.setMaxInv(100);
            trucks.setId(2);
            inhousePartRepository.save(trucks);

            InhousePart wheel = new InhousePart();
            wheel.setName("Wheels");
            wheel.setPrice(45.99);
            wheel.setInv(10);
            wheel.setMinInv(0);
            wheel.setMaxInv(100);
            wheel.setId(3);
            inhousePartRepository.save(wheel);

            InhousePart bearings = new InhousePart();
            bearings.setName("Bearings");
            bearings.setPrice(15.99);
            bearings.setInv(10);
            bearings.setMinInv(0);
            bearings.setMaxInv(100);
            bearings.setId(4);
            inhousePartRepository.save(bearings);

            InhousePart bushings = new InhousePart();
            bushings.setName("Bushings");
            bushings.setPrice(22.99);
            bushings.setInv(10);
            bushings.setMinInv(0);
            bushings.setMaxInv(100);
            bushings.setId(5);
            inhousePartRepository.save(bushings);
        }

        if (productRepository.count()==0){

            Product ChocolateSkateboard = new Product("Chocolate Skateboard", 170.00, 5);
            Product RetroSkateboard = new Product("Retro Skateboard", 120.00, 5);
            Product PinkSkateboard = new Product("Pink Skateboard", 125.00, 5);
            Product BlackSkateboard = new Product("Black Skateboard", 175.00, 5);
            Product BlueSkateboard = new Product("Blue Skateboard", 155.00, 5);
            productRepository.save(ChocolateSkateboard);
            productRepository.save(RetroSkateboard);
            productRepository.save(PinkSkateboard);
            productRepository.save(BlackSkateboard);
            productRepository.save(BlueSkateboard);
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
