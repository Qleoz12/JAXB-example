import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;

import org.wiztools.xsdgen.ParseException;
import org.wiztools.xsdgen.XsdConfig;
import org.wiztools.xsdgen.XsdGen;

public class XmlToObject {
    public static void main(final String[] args)
    {

        try
        {   
            XsdConfig conf=new XsdConfig();
            XsdGen gen = new XsdGen(conf);
            gen.parse(new File("src/main/resources/modelXml.xml"));
            validarCarpetas("src/main/xsd/");
            File out = new File("src/main/xsd/out.xsd");
            gen.write(new FileOutputStream(out));
        } catch (IOException | ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }  

    private static void validarCarpetas(String ruta) 
	{	
		java.nio.file.Path path = Paths.get(ruta);
		if (Files.notExists(path, LinkOption.NOFOLLOW_LINKS)) 
		{
			new File(ruta).mkdirs();
		}
	}
}  