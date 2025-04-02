package EasyApply.Linkedin;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    		System.out.println( "Hello World!" );
        
    		Yaml yaml = new Yaml();

                try (InputStream input = new FileInputStream("config.yaml")) {
                	
                	
                	
                    Map<String, Object> data = yaml.load(input);
                    System.out.println("Server: " + data.get("server"));
                    System.out.println("Port: " + data.get("port"));
                    
                    
                    
                } catch (Exception e) {
                	
                	
                    e.printStackTrace();
                }
      
        
    }
}
