package real.street_test.real_street_test.Cloudinary;
import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {


    @Bean
    public Cloudinary getCloudinary(){
        Map config = new HashMap();
        config.put("cloud_name","dckurpktj");
        config.put("api_key","988748114281531");
        config.put("api_secret","qeiqYrsEQy5ODOwd8BQufgB8uDg");
        config.put("secure", true);
        return new Cloudinary(config);
    }



}
